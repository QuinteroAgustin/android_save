package com.quintero.fredi;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class User {
    public int id;
    public String pseudo;
    public String mail;
    public String nom;
    public String prenom;
    public int role;

    /**
     * Constructeur
     * Construit un objet à partir d'un JSONObject
     * @param jsonObject
     */
    public User(JSONObject jsonObject) {
        try {
            setId(jsonObject.getInt("id"));
            setPseudo(jsonObject.getString("pseudo"));
            setMail(jsonObject.getString("mail"));
            setNom(jsonObject.getString("nom"));
            setPrenom(jsonObject.getString("prenom"));
            setRole(jsonObject.getInt("role"));

        } catch (JSONException e) {
            Log.d(MainActivity.LOG_TAG,"Erreur lors de la conversion de l'objet JSON en objet Ligne");
            e.printStackTrace();
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    /**
     * Convertit l'objet courant en array
     * @return le tableau
     */
    public String[] toArray() {
        String data[] = {
                Integer.toString(getId()),
                getMail(),
                getMail(),
                getNom(),
                getPrenom(),
                Integer.toString(getRole()),
        };
        return data;
    }
}
