package com.example.loginrealm.userRegister;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.loginrealm.R;
import com.example.loginrealm.login.LoginActivity;
import com.example.loginrealm.models.User;
import com.example.loginrealm.servicesRealm.RealmServices;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class UserRegisterActivity extends AppCompatActivity {

    RealmServices realmServices;

    @BindView(R.id.edt_name_register)
    EditText edtNameRegister;
    @BindView(R.id.edt_email_register)
    EditText edtEmailRegister;
    @BindView(R.id.edt_username_register)
    EditText edtUsernameRegister;
    @BindView(R.id.edt_password_register)
    EditText edtPasswordRegister;
    @BindView(R.id.btn_create_register)
    Button btnCreateRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);
        ButterKnife.bind(this);
        Realm.init(this);

        //Configurar la base de datos
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("dbLogin")
                .schemaVersion(1)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
        realmServices = new RealmServices(Realm.getDefaultInstance());
        //registrarUsuario();

    }

    private void registrarUsuario() {
        realmServices.insertUser(
                edtNameRegister.getText().toString(),
                edtEmailRegister.getText().toString(),
                edtUsernameRegister.getText().toString(),
                edtPasswordRegister.getText().toString());

        RealmResults<User> listUsers = realmServices.obtenerUsuarios();
        for (int i = 0; i < listUsers.size(); i++) {
            Log.e("MyLogFor",""+listUsers.get(i).getUserName());
        }
        Log.e("MyLog-user",""+listUsers/*.get(0).getEmail()*/);
    }

    @OnClick(R.id.btn_create_register)
    public void onViewClicked() {
        registrarUsuario();
        Intent intent = new Intent(UserRegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
