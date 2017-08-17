
package cl.gersard.trackingchile.domain;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import cl.gersard.trackingchile.MyApplication;
import io.realm.RealmList;
import io.realm.RealmObject;
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

    public Datosgenerales getDatosgenerales() {
        return mDatosgenerales;
    }

    public RealmList<Registro> getRegistros() {
        return mRegistros;
    }

    public void setIdTrack(){
        idTrack = MyApplication.idTrack.getAndIncrement();
    }

}
