package com.example.donnagabriela;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class Cadastrar_User extends AppCompatActivity {

    TextView TxtTile2;
    String login, termos_de_uso;
    CheckBox CbTermosDeUso;
    Button btnCadastrar;


    @SuppressLint({"SetTextI18n", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Hide the StatusBar and Action Bar:
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();

        //Prepare the Activity XML.
        setContentView(R.layout.activity_cadastrar_user);


        //-------------------------     From here you can program:    ------------------------------

        // ------------------------------     Checkbox:     ----------------------------------------

        //Inserting a hypertext in the Checkbox text.
        CheckBox CbTermosDeUso = (CheckBox) findViewById(R.id.CbTermosDeUso);
        String termos_de_uso = "<html> Estou ciente e aceito todos os <a href=\"http://www.google.com\">Termos de Uso</a> da marca.";
        CbTermosDeUso.setText("termos_de_uso");

        //Finding the URLs within the text and configuring them (using the "Linkify" class).
        CbTermosDeUso.setText(Html.fromHtml(termos_de_uso));
        CbTermosDeUso.setLinkTextColor(getResources().getColor(R.color.termos_text));
        CbTermosDeUso.setMovementMethod(LinkMovementMethod.getInstance());


        // ------------------------------     Textview:     ----------------------------------------

        //Inserting a hypertext in the TextView.
        TextView TxtTile2 = (TextView) findViewById(R.id.TxtTile2);
        String login = "<html>Já é cadastrado? <a href=\"http://www.google.com\">Faça o login aqui.</a>";
        TxtTile2.setText("login");

        //Finding the URLs within the text and configuring them (using the "Linkify" class).
        TxtTile2.setText(Html.fromHtml(login));
        TxtTile2.setMovementMethod(LinkMovementMethod.getInstance());

        Button btnCadastrar = (Button) findViewById(R.id.btnCadastrar);

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(CbTermosDeUso.isChecked()) {

                    Intent OpenLocalizationPage = new Intent(getBaseContext(), Localization_Page.class);
                    startActivity(OpenLocalizationPage);

                }
                else {
                    Toast.makeText(Cadastrar_User.this, "É necessário estar de acordo com os Termos de Uso da marca, " +
                            "caso contrário não poderá continuar o cadastro!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}