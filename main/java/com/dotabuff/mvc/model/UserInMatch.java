package com.dotabuff.mvc.model;

import java.math.BigInteger;
import java.util.List;

/**
 * Created by kirill on 22.11.2014.
 */
public class UserInMatch {
    private boolean win;
    private String hero;
    private String leaverStatus;
    private String locHero;
    private List<Integer> kda;
    private String id;
    private BigInteger steamId;
    private String personaName;
    private List<Item> items;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getLeaverStatus() {
        return leaverStatus;
    }

    public void setLeaverStatus(String leaveStatus) {
        this.leaverStatus = leaveStatus;
    }



    public String getLocHero() {
        return locHero;
    }

    public void setLocHero(String locHero) {
        this.locHero = locHero;
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public String getHero() {
        return hero;
    }

    public void setHero(String hero) {
        this.hero = hero;
    }

    public List<Integer> getKda() {
        return kda;
    }

    public void setKda(List<Integer> kda) {
        this.kda = kda;
    }
}
