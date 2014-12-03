package com.dotabuff.mvc.model;

/**
 * Created by kirill on 01.12.2014.
 */
public class Item {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String id;
    private String name;

}
