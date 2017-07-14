package com.example.loginrealm.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginrealm.R;
import com.example.loginrealm.models.User;
import com.example.loginrealm.servicesRealm.RealmServices;
import com.example.loginrealm.userRegister.UserRegisterActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;
import io.realm.RealmConfiguration;

public class LoginActivity extends AppCompatActivity {

    RealmServices realmServices;

    @BindView(R.id.edt_user)
    EditText edtUser;
    @BindView(R.id.edt_password)
    EditText edtPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.txt_crear_cuenta)
    TextView txtCrearCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
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

    @OnClick({R.id.btn_login, R.id.txt_crear_cuenta})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                buscarUsuario(edtUser.getText().toString(),edtPassword.getText().toString());
                break;
            case R.id.txt_crear_cuenta:
                Intent intent = new Intent(this, UserRegisterActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void buscarUsuario(String username, String pass) {
        User userName = realmServices.obtenerUsername(username);
        User password = realmServices.obtenerPassword(pass);
        if (username == null && pass == null){
            Toast.makeText(this, "Usuario o contraseña incorrectas", Toast.LENGTH_SHORT).show();
        }else{
            Log.e("MyLog",""+userName.getUserName());
            Log.e("MyLog",""+password.getPassword());
        }
    }
}
