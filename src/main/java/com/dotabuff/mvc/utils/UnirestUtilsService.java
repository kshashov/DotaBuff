package com.dotabuff.mvc.utils;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kirill on 22.11.2014.
 */
public class UnirestUtilsService {
    public static final String MATCH_HISTORY_URL = "https://api.steampowered.com/IDOTA2Match_570/GetMatchHistory/V001/?";
    public static final String MATCH_DETAILS_URL = "https://api.steampowered.com/IDOTA2Match_570/GetMatchDetails/V001/?";
    public static final String HEROES_URL = "https://api.steampowered.com/IEconDOTA2_570/GetHeroes/v0001/?";

    public static final String PLAYER_URL = "http://api.steampowered.com/ISteamUser/GetPlayerSummaries/v0002/?";

    public static final String ITEMS_URL = "https://api.steampowered.com/IEconDOTA2_570/GetGameItems/v0001/?";

    private static final String fillUrlFromParams(String url, Map<String, String> params){
        params.put("format","JSON");
        params.put("key", Constants.QUERY_AUTH_API);

        StringBuilder sb = new StringBuilder(url);
        for (String param : params.keySet()) {
            sb.append("&").append(param).append("=").append(params.get(param));
        }
        return sb.toString();
    }

    public static final HttpResponse<JsonNode> getMatchHistoryResponse(Map<String, String> params){
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.get(fillUrlFromParams(MATCH_HISTORY_URL, params)).asJson();
        } catch (UnirestException e) {

        }
        return response;
    }


    public static final HttpResponse<JsonNode> getMatchDetailsResponse(Map<String, String> params){
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.get(fillUrlFromParams(MATCH_DETAILS_URL, params)).asJson();
        } catch (UnirestException e) {

        }
        return response;

    }

    public static final HttpResponse<JsonNode> getHeroesResponse(){
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.get(fillUrlFromParams(HEROES_URL, new HashMap<String, String>())).asJson();
        } catch (UnirestException e) {

        }
        return response;

    }

    public static final HttpResponse<JsonNode> getPlayerResponse(Map<String, String> params){
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.get(fillUrlFromParams(PLAYER_URL, params)).asJson();
        } catch (UnirestException e) {

        }
        return response;

    }

    public static final HttpResponse<JsonNode> getItemResponse(Map<String, String> params){
        HttpResponse<JsonNode> response = null;

        try {
            response = Unirest.get(fillUrlFromParams(PLAYER_URL, params)).asJson();
        } catch (UnirestException e) {

        }
        return response;

    }
}
