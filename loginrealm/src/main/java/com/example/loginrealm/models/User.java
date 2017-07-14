package com.example.loginrealm.models;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class User extends RealmObject{


  //  private int userId;
    private String name;
    private String email;

    @PrimaryKey
    private String userName;
    private String password;

    public User() {
    }

    public User( String name, String email, String user, String password) {
        //this.userId = userId;
        this.name = name;
        this.email = email;
        this.userName = user;
        this.password = password;
    }
/*
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }*/

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
