package com.quintero.fredi;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class Note {
    public int id;
    public int est_valide;
    public Double mt_total;
    public String dat_remise;
    public String nr_ordre;
    public int id_periode;
    public int id_utilisateur;

    /**
     * Constructeur
     * Construit un objet à partir d'un JSONObject
     * @param jsonObject
     */
    public Note(JSONObject jsonObject) {
        try {
            setId(jsonObject.getInt("id"));
            setEst_valide(jsonObject.getInt("est_valide"));
            setMt_total(jsonObject.getDouble("mt_total"));
            setDat_remise(jsonObject.getString("dat_remise"));
            setNr_ordre(jsonObject.getString("nr_ordre"));
            setId_periode(jsonObject.getInt("id_periode"));
            setId_utilisateur(jsonObject.getInt("id_utilisateur"));

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

    public int getEst_valide() {
        return est_valide;
    }

    public void setEst_valide(int est_valide) {
        this.est_valide = est_valide;
    }

    public Double getMt_total() {
        return mt_total;
    }

    public void setMt_total(Double mt_total) {
        this.mt_total = mt_total;
    }

    public String getDat_remise() {
        return dat_remise;
    }

    public void setDat_remise(String dat_remise) {
        this.dat_remise = dat_remise;
    }

    public String getNr_ordre() {
        return nr_ordre;
    }

    public void setNr_ordre(String nr_ordre) {
        this.nr_ordre = nr_ordre;
    }

    public int getId_periode() {
        return id_periode;
    }

    public void setId_periode(int id_periode) {
        this.id_periode = id_periode;
    }

    public int getId_utilisateur() {
        return id_utilisateur;
    }

    public void setId_utilisateur(int id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    /**
     * Convertit l'objet courant en array
     * @return le tableau
     */
    public String[] toArray() {
        String data[] = {
                Integer.toString(getId()),
                Integer.toString(getEst_valide()),
                Double.toString(getMt_total()),
                getDat_remise(),
                getNr_ordre(),
                Integer.toString(getId_periode()),
                Integer.toString(getId_utilisateur())
        };
        return data;
    }
}
