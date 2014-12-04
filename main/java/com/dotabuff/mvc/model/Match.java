package com.dotabuff.mvc.model;

import org.springframework.stereotype.Component;

import java.sql.Time;
import java.util.Date;
import java.util.List;

/**
 * Created by kirill on 22.11.2014.
 */

public class Match {

    private String id;
    private boolean radiantWin;
    private Date startTime;

    private Time duration;
    private String gameMode;
    private UserInMatch userInMatch;
    private List<UserInMatch> direPlayers;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    private String url;

    public List<UserInMatch> getRadientPlayers() {
        return radientPlayers;
    }

    public void setRadientPlayers(List<UserInMatch> radientPlayers) {
        this.radientPlayers = radientPlayers;
    }

    public List<UserInMatch> getDirePlayers() {
        return direPlayers;
    }

    public void setDirePlayers(List<UserInMatch> direPlayers) {
        this.direPlayers = direPlayers;
    }

    private List<UserInMatch> radientPlayers;

    public String getLobbieType() {
        return lobbieType;
    }

    public void setLobbieType(String lobbieType) {
        this.lobbieType = lobbieType;
    }

    private String lobbieType;

    public UserInMatch getUserInMatch() {
        return userInMatch;
    }

    public void setUserInMatch(UserInMatch userInMatch) {
        this.userInMatch = userInMatch;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public boolean isRadiantWin() {
        return radiantWin;
    }

    public void setRadiantWin(boolean radiantWin) {
        this.radiantWin = radiantWin;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Time getDuration() {
        return duration;
    }

    public void setDuration(Time duration) {
        this.duration = duration;
    }

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

}
