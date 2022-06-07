package com.example.donnagabriela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.donnagabriela.dao.UsuarioDAO;
import com.example.donnagabriela.model.Usuario;

public class Login_User extends AppCompatActivity {

    Button btn_logar;
    EditText txtUser;
    EditText txtPassword;
    TextView txtResultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the StatusBar and Action Bar:
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_login_user);

        txtUser = findViewById(R.id.txtUser);
        txtPassword = findViewById(R.id.txtPassword);
        Button btn_logar = (Button) findViewById(R.id.btn_logar);
        txtResultado = findViewById(R.id.txtResultado);


        String usuario = txtUser.getText().toString();
        String senha = txtPassword.getText().toString();

        Usuario usu = new UsuarioDAO().selecionaUsuario(usuario, senha);

        btn_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(usu != null){

                    startClass();
                    finish();

                } else {

                    txtResultado.setText("Usuário ou senha inválidos. \n Tente novamente!");
                    limpar();
                }
            }
        });

    }

    public void startClass (){
        Intent OpenLocalizationPage = new Intent(getBaseContext(), Localization_Page.class);
        startActivity(OpenLocalizationPage);
    }
    public void limpar() {
        txtPassword.setText("");
        txtPassword.requestFocus();
    }
}