package com.sonika.onlineshoes.Pojo;

import java.io.Serializable;

/**
 * Created by sonika on 5/27/2017.
 */

public class OrderInfo {

    public String id, shoe_id, name, email, color, size, deliveryDate, address;

    public OrderInfo() {

    }

    public OrderInfo(String id, String shoe_id, String name, String email, String color, String size, String deliveryDate, String address) {
        this.id = id;
        this.shoe_id = shoe_id;
        this.name = name;
        this.email = email;
        this.color = color;
        this.size = size;
        this.deliveryDate = deliveryDate;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getShoe_id() {
        return shoe_id;
    }

    public void setShoe_id(String shoe_id) {
        this.shoe_id = shoe_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

