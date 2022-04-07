package com.quintero.fredi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class MyAsyncTask extends AsyncTask<String, Void, String> {
    public static final String EXTRA_MESSAGE = "com.quintero.fredi.MESSAGE";

    // http://172.17.1.147/FREDI/connexion_android.php?user=ph&password=Honore31000-/
    String MyURL = "http://172.17.1.147/FREDI/connexion_android.php";
    //String MyUser = "ph";
    String MyUser;
    //String MyPassword = "Honore31000-/";
    String MyPassword;
    ListView myListView;
    Context myContext;
    ArrayList<Ligne> myLignes = new ArrayList<>();
    ArrayList<String> myArrayList = new ArrayList<>();
    Activity myActivity;

    /**
     * Constructeur
     * @param listView la listView qui va recevoir le contenu
     */
    public MyAsyncTask(ListView listView, Activity activity) {
        super();
        myListView = listView;
        myContext = listView.getContext();
        myActivity = activity;
    }

    /**
     * Quand on lance la tâche asynchrone (.execute() dans ListActivity)
     * @param authentification le login et le mot de passe
     * @return Chaîne JSON
     */
    @Override
    protected String doInBackground(String... authentification) {
        MyUser = authentification[0];
        MyPassword = authentification[1];

        String url = MyURL + "?user=" + MyUser + "&password=" + MyPassword;
        Log.d(MainActivity.LOG_TAG, "URL=" + url);
        // Accède à Internet, consomme un service Web en RESTful et renvoie un contenu JSON
        return NetworkUtils.request(url);
    }

    /**
     * Quand la tâche asynchrone est terminée
     * @param jsonString le contenu JSON renvoyé par la méthode doInBackground()
     */
    @Override
    protected void onPostExecute(String jsonString) {
        super.onPostExecute(jsonString);
        // Interprète le contenu JSON pour récupérer le token
        if (jsonString != null) {
            try {
                // Récupère le contenu du fichier JSON
                JSONObject jsonObject = new JSONObject(jsonString);
                String message = jsonObject.getString("succes");
                Log.d(MainActivity.LOG_TAG, "zebi_all_json_string=" + jsonString);
                Log.d(MainActivity.LOG_TAG, "zebi_all_message=" + message);
                // Récupère la liste des clubs
                if (jsonObject.isNull("succes")==false) {
                    JSONArray lignesArray = jsonObject.getJSONArray("succes");
                    // Boucle de lecture des clubs
                    for (int i = 0; i < lignesArray.length(); i++) {
                        JSONObject listJsonObject = lignesArray.getJSONObject(i);
                        // Crée un objet métier Club à partir de l'objet JSONObject
                        Ligne ligne = new Ligne(listJsonObject);
                        // Ajoute l'objet métier dans la collection ArrayList<Club>
                        myLignes.add(ligne);
                        // Ajoute le libellé du club dans la collection ArrayList<String>
                        myArrayList.add(ligne.lib_trajet);

                    }
                } else {
                    // Pas de liste club à afficher
                    Toast.makeText(myContext, "Identification impossible !", Toast.LENGTH_LONG).show();
                    Log.d(MainActivity.LOG_TAG, "Rien à afficher");
                    //création de l'INTENT
                    Intent loginPage = new Intent(myActivity, LoginActivity.class);
                    //lancement de l'activité
                    myActivity.startActivity(loginPage);

                }

            } catch (Exception e) {
                Log.d(MainActivity.LOG_TAG, "Erreur lors de la lecture du fichier JSON");
                e.printStackTrace();
            }
        } else {
            Log.d(MainActivity.LOG_TAG, "zebi Erreur : le fichier JSON est vide !");
        }



    }

}
