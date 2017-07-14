package net.edgon.realmdatabases.models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;


public class Curso extends RealmObject{

    @PrimaryKey
    private int idCurso;

    private String nameCurso;

    private RealmList<User> users;

    public Curso() {
    }

    public Curso(int idCurso, String nameCurso, RealmList<User> users) {
        this.idCurso = idCurso;
        this.nameCurso = nameCurso;
        this.users = users;
    }

    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNameCurso() {
        return nameCurso;
    }

    public void setNameCurso(String nameCurso) {
        this.nameCurso = nameCurso;
    }

    public RealmList<User> getUsers() {
        return users;
    }

    public void setUsers(RealmList<User> users) {
        this.users = users;
    }
}
