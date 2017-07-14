package net.edgon.realmdatabases.servicesRealm;


import net.edgon.realmdatabases.models.Curso;
import net.edgon.realmdatabases.models.User;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

public class RealmServices {

    Realm realm;

    public RealmServices(Realm realm) {
        this.realm = realm;
    }

    //obtener usuarios
    public RealmResults<User> obtenerUsuarios(){
        RealmResults<User> listUsuarios = realm.where(User.class).findAll();
        return listUsuarios;
    }

    //obtener un usuario por id
    public User obtenerUsuarioId(int id){
        User user = realm.where(User.class).equalTo("id",id).findFirst();
        return user;
    }

    //Actualizar nombre del usuario
    public void actualizarUser(User user, String name){
        realm.beginTransaction();
        user.setName(name);
        realm.commitTransaction();
    }

    //Insertar un usuario
    public void insertUser(int id, String name, String email, boolean option){
        realm.beginTransaction();
        User user = realm.createObject(User.class,id);
        user.setName(name);
        user.setEmail(email);
        user.setOption(option);
        realm.commitTransaction();
    }


    //Eliminar usuario
    public void deleteUser(int id){
        User user = obtenerUsuarioId(id);
        realm.beginTransaction();
        user.deleteFromRealm();
        realm.commitTransaction();
    }


    //obtenerCurso
    public RealmResults<Curso> obtenerCurso(){
        RealmResults<Curso> cursoRealmResults = realm.where(Curso.class).findAll();
        return cursoRealmResults;
    }

    //obtener curso por id
    public Curso obtenerCursoId(int id){
        Curso curso = realm.where(Curso.class).equalTo("id",id).findFirst();
        return curso;
    }

    //insertar curso
    public void insertarCurso(int id, String name){

        //combertir el realmlist a
        RealmResults<User> lista = obtenerUsuarios();
        RealmList<User>  result = new RealmList<>();
        result.addAll(lista.subList(0,lista.size()));

        Curso curso = new Curso(id,name,result);
        realm.beginTransaction();
        realm.copyToRealmOrUpdate(curso);
        realm.commitTransaction();
    }




}
