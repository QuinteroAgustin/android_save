package com.quintero.fredi;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class Ligne {
    public int id;
    public String dat_ligne;
    public String lib_trajet;
    public int nb_km;
    public double mt_km;
    public double mt_peage;
    public double mt_repad;
    public double mt_hebergement;
    public double mt_total;
    public String lib_motif;
    public int id_note;

    /**
     * Constructeur
     * Construit un objet à partir d'un JSONObject
     * @param jsonObject
     */
    public Ligne(JSONObject jsonObject) {
        try {
            setId(jsonObject.getInt("id"));
            setDat_ligne(jsonObject.getString("dat_ligne"));
            setLib_trajet(jsonObject.getString("lib_trajet"));
            setNb_km(jsonObject.getInt("nb_km"));
            setMt_km(jsonObject.getDouble("mt_km"));
            setMt_peage(jsonObject.getDouble("mt_peage"));
            setMt_repad(jsonObject.getDouble("mt_repas"));
            setMt_hebergement(jsonObject.getDouble("mt_hebergement"));
            setMt_total(jsonObject.getDouble("mt_total"));
            setLib_motif(jsonObject.getString("lib_motif"));
            setId_note(jsonObject.getInt("id_note"));

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

    public String getDat_ligne() {
        return dat_ligne;
    }

    public void setDat_ligne(String dat_ligne) {
        this.dat_ligne = dat_ligne;
    }

    public String getLib_trajet() {
        return lib_trajet;
    }

    public void setLib_trajet(String lib_trajet) {
        this.lib_trajet = lib_trajet;
    }

    public int getNb_km() {
        return nb_km;
    }

    public void setNb_km(int nb_km) {
        this.nb_km = nb_km;
    }

    public double getMt_km() {
        return mt_km;
    }

    public void setMt_km(double mt_km) {
        this.mt_km = mt_km;
    }

    public double getMt_peage() {
        return mt_peage;
    }

    public void setMt_peage(double mt_peage) {
        this.mt_peage = mt_peage;
    }

    public double getMt_repad() {
        return mt_repad;
    }

    public void setMt_repad(double mt_repad) {
        this.mt_repad = mt_repad;
    }

    public double getMt_hebergement() {
        return mt_hebergement;
    }

    public void setMt_hebergement(double mt_hebergement) {
        this.mt_hebergement = mt_hebergement;
    }

    public double getMt_total() {
        return mt_total;
    }

    public void setMt_total(double mt_total) {
        this.mt_total = mt_total;
    }

    public String getLib_motif() {
        return lib_motif;
    }

    public void setLib_motif(String lib_motif) {
        this.lib_motif = lib_motif;
    }

    public int getId_note() {
        return id_note;
    }

    public void setId_note(int id_note) {
        this.id_note = id_note;
    }

    /**
     * Convertit l'objet courant en array
     * @return le tableau
     */
    public String[] toArray() {
        String data[] = {
                Integer.toString(getId()),
                getDat_ligne(),
                getLib_trajet(),
                Integer.toString(getNb_km()),
                Double.toString(getMt_km()),
                Double.toString(getMt_peage()),
                Double.toString(getMt_repad()),
                Double.toString(getMt_hebergement()),
                Double.toString(getMt_total()),
                getLib_motif(),
                Integer.toString(getId_note())
        };
        return data;
    }
}
