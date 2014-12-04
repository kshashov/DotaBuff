package com.dotabuff.mvc.service;

import com.dotabuff.mvc.model.Item;
import com.dotabuff.mvc.model.Match;
import com.dotabuff.mvc.model.UserInMatch;
import com.dotabuff.mvc.utils.Constants;
import com.dotabuff.mvc.utils.DictionaryUtilService;
import com.dotabuff.mvc.utils.UnirestUtilsService;
import com.dotabuff.mvc.utils.UtilsHelper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.math.BigInteger;
import java.sql.Time;
import java.text.DateFormat;
import java.util.*;

/**
 * Created by kirill on 22.11.2014.
 */
@Component
public class MatchesService {
    private DictionaryUtilService dictionaryUtilService;
    private ItemsService itemsService;

    @Autowired
    public MatchesService(DictionaryUtilService dictionaryUtilService, ItemsService itemsService) {
        this.dictionaryUtilService = dictionaryUtilService;
        this.itemsService = itemsService;
    }

    private List<String> getLastMatchesIds(String playerId, int count) {
        ArrayList<String> matches = new ArrayList<String>();
        Map<String, String> params = new HashMap<String, String>();

        params.put("account_id", playerId);
        if (count != 0) {
            params.put("matches_requested", String.valueOf(count));
        }

        HttpResponse<JsonNode> response = UnirestUtilsService.getMatchHistoryResponse(params);
        if (response == null) {
            return matches;
        }

        JSONArray matchesJSON = (JSONArray) ((JSONObject) response.getBody().getObject().get("result")).get("matches");
        for (int i = 0; i < matchesJSON.length(); i++) {
            matches.add(String.valueOf((Integer) ((JSONObject) matchesJSON.get(i)).get("match_id")));
        }

        return matches;
    }


    private Match createMatch(String id, String playerId) {
        Match match = new Match();
        match.setId(id);
        Map<String, String> params = new HashMap<String, String>();
        params.put("account_id", playerId);
        params.put("match_id", id);
        HttpResponse<JsonNode> response = UnirestUtilsService.getMatchDetailsResponse(params);
        if (response == null) {
            return match;
        }

        JSONObject matchJSON = (JSONObject) response.getBody().getObject().get("result");
        match.setRadiantWin(matchJSON.getBoolean("radiant_win"));
        match.setGameMode(DictionaryUtilService.getGameMode(matchJSON.getInt("game_mode")));
        match.setLobbieType(DictionaryUtilService.getLobbieType(matchJSON.getInt("lobby_type")));
        match.setUrl(UtilsHelper.getFullUrl("matches/" + match.getId()));
        match.setStartTime(new Date(matchJSON.getLong("start_time") * 1000));
        match.setDuration(new Time(matchJSON.getLong("duration") * 1000));

        JSONArray players = matchJSON.getJSONArray("players");
        UserInMatch userInMatch = new UserInMatch();
        for (int i = 0; i < players.length(); i++) {
            if (players.getJSONObject(i).getLong("account_id") == new Long(playerId)) {
                JSONObject player = players.getJSONObject(i);
                userInMatch.setHero(DictionaryUtilService.getHero(player.getInt("hero_id")));
                userInMatch.setLocHero(DictionaryUtilService.getLocHero(player.getInt("hero_id")));
                userInMatch.setLeaverStatus(DictionaryUtilService.getLeaverStatus(player.getInt("leaver_status")));
                userInMatch.setWin((player.getInt("player_slot") < 5) == match.isRadiantWin());
                List<Integer> kda = new ArrayList<Integer>();
                kda.add(player.getInt("kills"));
                kda.add(player.getInt("deaths"));
                kda.add(player.getInt("assists"));
                userInMatch.setKda(kda);
            }
        }

        match.setUserInMatch(userInMatch);
        return match;
    }

    public List<Match> getLastMatches(Locale locale, String playerId, int count) {
        List<String> matchesIds = getLastMatchesIds(playerId, count);
        List<Match> matches = new ArrayList<Match>();
        for (String matchesId : matchesIds) {
            Match match = createMatch(matchesId, playerId);
            //   match.getStartTime().
            // match.setStartTime(match.getStartTime());
            matches.add(match);
        }


        return matches;
    }

    public Match getFullMatch(Locale locale, String matchId) {
        Match match = new Match();

        match.setId(matchId);
        Map<String, String> params = new HashMap<String, String>();
        params.put("match_id", matchId);
        HttpResponse<JsonNode> response = UnirestUtilsService.getMatchDetailsResponse(params);
        if (response == null) {
            return match;
        }

        JSONObject matchJSON = (JSONObject) response.getBody().getObject().get("result");
        match.setRadiantWin(matchJSON.getBoolean("radiant_win"));
        match.setGameMode(DictionaryUtilService.getGameMode(matchJSON.getInt("game_mode")));
        match.setLobbieType(DictionaryUtilService.getLobbieType(matchJSON.getInt("lobby_type")));
        match.setStartTime(new Date(matchJSON.getLong("start_time") * 1000));
        match.setDuration(new Time(matchJSON.getLong("duration") * 1000));

        JSONArray players = matchJSON.getJSONArray("players");
        ArrayList<UserInMatch> direPlayersList = new ArrayList<UserInMatch>();
        ArrayList<UserInMatch> radientPlayersList = new ArrayList<UserInMatch>();
        for (int i = 0; i < players.length(); i++) {
            JSONObject player = players.getJSONObject(i);
            UserInMatch userInMatch = getUserInMath(String.valueOf(player.getInt("account_id")));
            userInMatch.setUrl(UtilsHelper.getFullUrl("players/" + userInMatch.getId()));
            userInMatch.setHero(DictionaryUtilService.getHero(player.getInt("hero_id")));
            userInMatch.setLocHero(DictionaryUtilService.getLocHero(player.getInt("hero_id")));
            userInMatch.setLeaverStatus(DictionaryUtilService.getLeaverStatus(player.getInt("leaver_status")));
            userInMatch.setWin((player.getInt("player_slot") < 5) == match.isRadiantWin());
            List<Integer> kda = new ArrayList<Integer>();
            kda.add(player.getInt("kills"));
            kda.add(player.getInt("deaths"));
            kda.add(player.getInt("assists"));
            userInMatch.setKda(kda);
            List<Item> items = new ArrayList<Item>();
            if (player.getInt("item_0") != 0) {
                items.add(itemsService.getItem(player.getInt("item_0")));
            }
            if (player.getInt("item_1") != 0) {
                items.add(itemsService.getItem(player.getInt("item_1")));
            }
            if (player.getInt("item_2") != 0) {
                items.add(itemsService.getItem(player.getInt("item_2")));
            }
            if (player.getInt("item_3") != 0) {
                items.add(itemsService.getItem(player.getInt("item_3")));
            }
            if (player.getInt("item_4") != 0) {
                items.add(itemsService.getItem(player.getInt("item_4")));
            }
            if (player.getInt("item_5") != 0) {
                items.add(itemsService.getItem(player.getInt("item_5")));
            }
            userInMatch.setItems(items);
            if (player.getInt("player_slot") < 5) {
                radientPlayersList.add(userInMatch);
            } else {
                direPlayersList.add(userInMatch);
            }
        }

        match.setDirePlayers(direPlayersList);
        match.setRadientPlayers(radientPlayersList);
        return match;
    }

    public UserInMatch getUserInMath(String id) {
        UserInMatch userInMatch = new UserInMatch();
        userInMatch.setId(id);
        userInMatch.setSteamId(UtilsHelper.idTo64(new BigInteger(id)));
        userInMatch.setPersonaName("");
        Map<String, String> params = new HashMap<String, String>();
        params.put("steamids", userInMatch.getSteamId().toString());
        HttpResponse<JsonNode> response = UnirestUtilsService.getPlayerResponse(params);
        if (response == null) {
            return userInMatch;
        }

        JSONObject matchJSON = (JSONObject) response.getBody().getObject().get("response");
        JSONArray players = matchJSON.getJSONArray("players");
        for (int i = 0; i < players.length(); i++) {
            JSONObject player = players.getJSONObject(i);
            userInMatch.setPersonaName(player.getString("personaname"));
        }
        return userInMatch;
    }
}
