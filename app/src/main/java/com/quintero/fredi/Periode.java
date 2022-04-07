package com.quintero.fredi;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class Periode {
    public int id;
    public String lib;
    public int estActive;
    public Double mt_km;

    /**
     * Constructeur
     * Construit un objet à partir d'un JSONObject
     * @param jsonObject
     */
    public Periode(JSONObject jsonObject) {
        try {
            setId(jsonObject.getInt("id"));
            setLib(jsonObject.getString("lib"));
            setEstActive(jsonObject.getInt("estActive"));
            setMt_km(jsonObject.getDouble("mt_km"));

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

    public String getLib() {
        return lib;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    public int getEstActive() {
        return estActive;
    }

    public void setEstActive(int estActive) {
        this.estActive = estActive;
    }

    public Double getMt_km() {
        return mt_km;
    }

    public void setMt_km(Double mt_km) {

        this.mt_km = mt_km;
    }

    /**
     * Convertit l'objet courant en array
     * @return le tableau
     */
    public String[] toArray() {
        String data[] = {
                Integer.toString(getId()),
                getLib(),
                Integer.toString(getEstActive()),
                Double.toString(getMt_km()),
        };
        return data;
    }
}
