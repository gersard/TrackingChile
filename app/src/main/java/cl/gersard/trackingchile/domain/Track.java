
package cl.gersard.trackingchile.domain;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import cl.gersard.trackingchile.MyApplication;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

@SuppressWarnings("unused")
public class Track extends RealmObject {

    public static final String FIELD_ID = "idTrack";

    @PrimaryKey
    private int idTrack;
    @SerializedName("datosgenerales")
    private Datosgenerales mDatosgenerales;
    @SerializedName("registros")
    private RealmList<Registro> mRegistros;
    private String codigoSeguimiento;
    private String descripcion;

    public Datosgenerales getDatosgenerales() {
        return mDatosgenerales;
    }

    public RealmList<Registro> getRegistros() {
        return mRegistros;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCodigoSeguimiento() {
        return codigoSeguimiento;
    }

    public void setCodigoSeguimiento(String codigoSeguimiento) {
        this.codigoSeguimiento = codigoSeguimiento;
    }

    public void setIdTrack(){
        idTrack = MyApplication.idTrack.getAndIncrement();
    }

    public static RealmResults<Track> getTracks(){
        Realm realm = Realm.getDefaultInstance();
        return realm.where(Track.class).findAll();
    }

}
