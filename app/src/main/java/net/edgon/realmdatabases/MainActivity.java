package net.edgon.realmdatabases;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import net.edgon.realmdatabases.models.Curso;
import net.edgon.realmdatabases.models.User;
import net.edgon.realmdatabases.servicesRealm.RealmServices;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    RealmServices realmServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);  //prepara real

        //configuracion de la base
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("test")       //nombre de la base de datos
                .schemaVersion(1)   //mumero de version de la base de datos
                .deleteRealmIfMigrationNeeded()
                .build();           //Construye con las configuraciones establesidad

        Realm.setDefaultConfiguration(realmConfiguration);

        realmServices = new RealmServices(Realm.getDefaultInstance());
        realmTareas();
        realmCursos();
    }


    public void realmTareas(){
       // realmServices.insertUser(1,"Edwin","edwin@devf.com",false);

       //  realmServices.insertUser(2,"Brandon","brandon@devf.com",true);
      //  realmServices.insertUser(3,"Sergio","sergio@devf.com",true);

       RealmResults<User> listUsers = realmServices.obtenerUsuarios();
        for (int i=0;i<listUsers.size();i++){
            Log.e("MyLogFor",listUsers.get(i).getEmail());
        }
        Log.e("MyLog-user",""+listUsers/*.get(0).getEmail()*/);

      //  User user = realmServices.obtenerUsuarioId(2);
      //  Log.e("MyLog",""+ user.getName());

     //   User user = realmServices.obtenerUsuarioId(2);
     //   realmServices.actualizarUser(user,"Brandon2");
     //   Log.e("MyLog",""+ user.getName());

       // realmServices.deleteUser(1);


    }

    public void realmCursos(){
        realmServices.insertarCurso(1,"Cinta Negra Android");

        RealmResults<Curso> cursoRealmResults = realmServices.obtenerCurso();
        Log.e("MyLog",""+ cursoRealmResults);
        for (int i = 0; i < cursoRealmResults.size(); i++) {
            Log.e("MyLog-cursos",cursoRealmResults.get(0).getUsers().get(i).getName());
        }
    }
}
