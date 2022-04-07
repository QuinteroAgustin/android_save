package com.quintero.fredi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    static final String LOG_TAG = "com.quintero.fredi.LOG"; // Tag pour la log
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void suivant(View view){
        //création de l'INTENT
        Intent loginPage = new Intent(this, LoginActivity.class);
        //lancement de l'activité
        startActivity(loginPage);
    }
}