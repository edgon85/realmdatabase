package com.example.loginrealm.servicesRealm;


import com.example.loginrealm.models.User;

import io.realm.Realm;
import io.realm.RealmResults;

public class RealmServices {
    Realm realm;


    public RealmServices(Realm realm) {
        this.realm = realm;
    }

    //Insertar un usuario nuevo
    public void insertUser(/*int id,*/ String name, String email, String userName, String password){
        realm.beginTransaction();
        User user = realm.createObject(User.class,userName);
        user.setName(name);
        user.setEmail(email);
        //user.setUserName(userName);
        user.setPassword(password);
        realm.commitTransaction();
    }

    //Obtener usuarios
    public RealmResults<User> obtenerUsuarios(){
        RealmResults<User> listUsuarios = realm.where(User.class).findAll();
        return listUsuarios;
    }

    //obterner usuario por userName
    public User obtenerUsername(String userName){
        User user = realm.where(User.class).equalTo("userName",userName).findFirst();
        return user;
    }

    //obterner usuario por userName
    public User obtenerPassword(String password){
        User user = realm.where(User.class).equalTo("password",password).findFirst();
        return user;
    }


    /*
     //obtener un usuario por id
    public User obtenerUsuarioId(int id){
        User user = realm.where(User.class).equalTo("id",id).findFirst();
        return user;
    }
     */

}
