package com.sonika.onlineshoes.Pojo;

/**
 * Created by sonika on 5/3/2017.
 */

public class UserInfo {

  public   String id, name, password, contact, email;

    public UserInfo(String id, String name, String password, String contact, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.contact = contact;
        this.email = email;
    }

    public UserInfo(){

    }

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}