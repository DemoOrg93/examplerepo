package com.sonika.onlineshoes.Pojo;

import java.io.Serializable;

/**
 * Created by sonika on 5/9/2017.
 */

public class Datamodel implements Serializable {

    public String id, price, image, description;

    public Datamodel() {
    }

    public Datamodel(String id, String price, String image, String description) {
        this.id = id;
        this.price = price;
        this.image = image;
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

