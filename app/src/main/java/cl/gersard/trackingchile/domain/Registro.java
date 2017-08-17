package cl.gersard.trackingchile.domain;

import com.google.gson.annotations.SerializedName;

import cl.gersard.trackingchile.MyApplication;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gerardo on 16-08-2017.
 */

public class Registro extends RealmObject {

    public static final String FIELD_ID = "idRegistro";
    @PrimaryKey
    private int idRegistro;
    @SerializedName("estado")
    private String mEstado;
    @SerializedName("fecha")
    private String mFecha;
    @SerializedName("lugar")
    private String mLugar;

    public String getEstado() {
        return mEstado;
    }

    public String getFecha() {
        return mFecha;
    }

    public String getLugar() {
        return mLugar;
    }

    public void setIdRegistro() {
        this.idRegistro = MyApplication.idRegistro.getAndIncrement();
    }
}