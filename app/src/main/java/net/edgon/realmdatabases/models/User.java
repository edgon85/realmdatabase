package net.edgon.realmdatabases.models;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;



public class User extends RealmObject{

    @PrimaryKey
    private int id;
    private String name;
    private String email;
    private Boolean option;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Boolean getOption() {
        return option;
    }

    public void setOption(Boolean option) {
        this.option =option;
    }
}
