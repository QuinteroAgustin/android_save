package com.quintero.fredi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsLigne extends AppCompatActivity {

    Intent myIntent;
    TextView myViewIdNote;
    TextView myViewDate;
    TextView myViewTrajet;
    TextView myViewKm;
    TextView myViewPeage;
    TextView myViewRepas;
    TextView myViewHebergement;
    TextView myViewMotif;
    TextView myViewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_ligne);

        // Récupère les données à afficher
        myIntent = getIntent();
        String myData[] = myIntent.getStringArrayExtra(MyAsyncTask.EXTRA_MESSAGE);

        // Affiche les données dans le layout
        myViewIdNote = (TextView) findViewById(R.id.tv_id_note);
        myViewIdNote.setText("ID Note : " + myData[0]);

        myViewDate = (TextView) findViewById(R.id.tv_date);
        myViewDate.setText("Date : " + myData[1]);

        myViewTrajet = (TextView) findViewById(R.id.tv_trajet);
        myViewTrajet.setText("Trajet : " + myData[2]);

        myViewKm = (TextView) findViewById(R.id.tv_mt_km);
        myViewKm.setText("Mt_Km : " + myData[3]);

        myViewPeage = (TextView) findViewById(R.id.tv_mt_peage);
        myViewPeage.setText("Mt_Peage : " + myData[4]);

        myViewRepas = (TextView) findViewById(R.id.tv_mt_repas);
        myViewRepas.setText("Mt_Repas : " + myData[5]);

        myViewHebergement = (TextView) findViewById(R.id.tv_mt_hebergement);
        myViewHebergement.setText("Mt_Hebergement : " + myData[6]);

        myViewMotif = (TextView) findViewById(R.id.tv_mt_repas);
        myViewMotif.setText("Mt_Repas : " + myData[7]);

        myViewTotal = (TextView) findViewById(R.id.tv_mt_total);
        myViewTotal.setText("Mt_Total : " + myData[8]);
    }
}