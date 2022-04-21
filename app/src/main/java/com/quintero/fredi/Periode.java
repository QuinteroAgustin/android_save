package com.quintero.fredi;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

public class Periode {
    public int id_periode;
    public String lib_periode;
    public int est_active;
    public Double mt_km;

    /**
     * Constructeur
     * Construit un objet à partir d'un JSONObject
     * @param jsonObject
     */
    public Periode(JSONObject jsonObject) {
        try {
            setId_periode(jsonObject.getInt("id_periode"));
            setLib_periode(jsonObject.getString("lib_periode"));
            setEst_active(jsonObject.getInt("est_active"));
            setMt_km(jsonObject.getDouble("mt_km"));

        } catch (JSONException e) {
            Log.d(MainActivity.LOG_TAG,"Erreur lors de la conversion de l'objet JSON en objet Ligne");
            e.printStackTrace();
        }
    }

    public int getId_periode() {
        return id_periode;
    }

    public void setId_periode(int id_periode) {
        this.id_periode = id_periode;
    }

    public String getLib_periode() {
        return lib_periode;
    }

    public void setLib_periode(String lib_periode) {
        this.lib_periode = lib_periode;
    }

    public int getEst_active() {
        return est_active;
    }

    public void setEst_active(int est_active) {
        this.est_active = est_active;
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
                Integer.toString(getId_periode()),
                getLib_periode(),
                Integer.toString(getEst_active()),
                Double.toString(getMt_km()),
        };
        return data;
    }
}
