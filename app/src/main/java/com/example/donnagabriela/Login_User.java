package com.example.donnagabriela;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

public class Login_User extends AppCompatActivity {

    Button btn_logar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the StatusBar and Action Bar:
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        setContentView(R.layout.activity_login_user);


        Button btn_logar = (Button) findViewById(R.id.btn_logar);

        btn_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent OpenLocalizationPage = new Intent(getBaseContext(), Localization_Page.class);
                startActivity(OpenLocalizationPage);
            }
        });





    }
}