package com.dotabuff.mvc.utils;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by kirill on 01.12.2014.
 */
@Component
@Scope(value = "singleton")
public class UtilsHelper {
    private static String host = "http://shashov.com:8080/DotaBuff/";
    private static Map<String, String> urls;

    @PostConstruct
    private static final void initUrls() {
        urls = new HashMap<String, String>();
        urls.put("home", host + "home/");
        urls.put("matches", host + "matches/");
        urls.put("players", host + "players/");
        urls.put("bootstrap.min.css", host + "resources/bootstrap/css/bootstrap.min.css");
        urls.put("jquery", "https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js");
        urls.put("bootstrap.min.js", host + "resources/bootstrap/js/bootstrap.min.js");
        urls.put("moment.js", host + "resources/moment.js");
        urls.put("players", host + "players/");


    }

    public static String getUrl(String key) {
        return urls.get(key);
    }

    public static HashMap<String, String> getUrls() {
        return (HashMap<String, String>) urls;
    }

    public static String getFullUrl(String path){
        return host + path;
    }


    public static final BigInteger idTo32(BigInteger id) {
        return (id.subtract(new BigInteger("76561197960265728")));
    }

    public static final BigInteger idTo64(BigInteger id) {
        return (id.add(new BigInteger("76561197960265728")));
    }

    public static final String profileUrl(String id) {
        return "http://steamcommunity.com/profiles/" + id;
    }

    public static boolean isNumeric(String str)
    {
        try
        {
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe)
        {
            return false;
        }
        return true;
    }
}
