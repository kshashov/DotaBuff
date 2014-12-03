package com.dotabuff.mvc.service;


import com.dotabuff.mvc.model.Player;
import com.dotabuff.mvc.utils.UnirestUtilsService;
import com.dotabuff.mvc.utils.UtilsHelper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kirill on 22.11.2014.
 */
@Component
public class PlayerService {

    public Player getPlayer(String playerId) {
        Player player = new Player();
        player.setId(playerId);
        player.setSteamId(UtilsHelper.idTo64(new BigInteger(playerId)));
        player.setPersonaName("");
        Map<String, String> params = new HashMap<String, String>();
        params.put("steamids", player.getSteamId().toString());
        HttpResponse<JsonNode> response = UnirestUtilsService.getPlayerResponse(params);
        if (response == null) {
            return player;
        }

        JSONObject matchJSON = (JSONObject) response.getBody().getObject().get("response");
        JSONArray players = matchJSON.getJSONArray("players");
        for (int i = 0; i < players.length() ; i++) {
            JSONObject player1 = players.getJSONObject(i);
            player.setPersonaName(player1.getString("personaname"));
        }
        return player;
    }
}
