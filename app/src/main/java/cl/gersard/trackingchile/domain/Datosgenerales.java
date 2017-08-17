package cl.gersard.trackingchile.domain;

import com.google.gson.annotations.SerializedName;

import cl.gersard.trackingchile.MyApplication;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Gerardo on 16-08-2017.
 */
public class Datosgenerales extends RealmObject {

    public static final String FIELD_ID = "idDatosGenerales";
    @PrimaryKey
    private int idDatosGenerales;
    @SerializedName("Entregado_a")
    private String mEntregadoA;
    @SerializedName("Envio")
    private String mEnvio;
    @SerializedName("Fecha_Entrega")
    private String mFechaEntrega;
    @SerializedName("Rut")
    private String mRut;

    public String getEntregadoA() {
        return mEntregadoA;
    }

    public String getEnvio() {
        return mEnvio;
    }

    public String getFechaEntrega() {
        return mFechaEntrega;
    }

    public String getRut() {
        return mRut;
    }

    public void setIdDatosGenerales() {
        this.idDatosGenerales = MyApplication.idDatosGenerales.getAndIncrement();
    }
}