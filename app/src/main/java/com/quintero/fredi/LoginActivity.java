package com.quintero.fredi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    // Récupère les views
    EditText myViewUser;
    EditText myViewPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Récupère les views
        myViewUser = (EditText) findViewById(R.id.et_username);
        myViewPassword = (EditText) findViewById(R.id.et_password);
    }
    /**
     * Quand on clique sur le bouton "Connecter"
     * @param view
     * TODO : ajouter le user et le mot de passe dans l'intent pour l'authentification
     */
    public void connecter(View view) {
        // Création de l'intent pour Login
        Intent connexion = new Intent(this, NoteActivity.class);
        // Ajoute le login et le password dans l'intent
        String myData[]={myViewUser.getText().toString(),myViewPassword.getText().toString()};
        connexion.putExtra(MyAsyncTask.EXTRA_MESSAGE, myData);
        // Lancement de l'activité
        startActivity(connexion);
    }
}