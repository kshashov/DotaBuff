package com.dotabuff.mvc.model;


import com.sun.istack.internal.NotNull;

import java.math.BigInteger;

/**
 * Created by kirill on 22.11.2014.
 */
public class Player {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigInteger getSteamId() {
        return steamId;
    }

    public void setSteamId(BigInteger steamId) {
        this.steamId = steamId;
    }

    public String getPersonaName() {
        return personaName;
    }

    public void setPersonaName(String personaName) {
        this.personaName = personaName;
    }

    private BigInteger steamId;
    private String personaName;

    @NotNull
    private String id;
}
