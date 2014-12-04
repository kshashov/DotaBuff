package com.dotabuff.mvc.model;

import java.util.List;

/**
 * User: kish0713
 * Date: 04.12.14
 */
public class Unit {
    private String name;

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    private String imageSrc;

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private List<Item> items;
}
