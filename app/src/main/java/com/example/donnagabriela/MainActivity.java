package com.example.donnagabriela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button BtnLogin, BtnCadastrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the StatusBar and Action Bar:
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

            BtnLogin = findViewById(R.id.BtnLogin);
            BtnCadastrar = findViewById(R.id.BtnCadastrar);


            BtnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent it = new Intent(getBaseContext(),Login_User.class);
                    startActivity(it);
                }
            });

            BtnCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent it = new Intent(getBaseContext(),Cadastrar_User.class);
                    startActivity(it);
                }
            });





    }


}