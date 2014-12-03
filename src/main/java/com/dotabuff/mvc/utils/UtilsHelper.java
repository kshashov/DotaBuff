package com.dotabuff.mvc.utils;

import java.math.BigInteger;

/**
 * Created by kirill on 01.12.2014.
 */
public class UtilsHelper {
    public static final BigInteger idTo32(BigInteger id){
        return (id.subtract(new BigInteger("76561197960265728")));
    }

    public static final BigInteger idTo64(BigInteger id){
        return (id.add(new BigInteger("76561197960265728")));
    }

    public static final String profileUrl(String id)  {
        return "http://steamcommunity.com/profiles/" + id;
    }
}
