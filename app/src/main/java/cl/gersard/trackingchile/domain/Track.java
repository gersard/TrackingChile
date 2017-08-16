
package cl.gersard.trackingchile.domain;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

@SuppressWarnings("unused")
public class Track extends RealmObject {

    @PrimaryKey
    private int idTrack;
    @SerializedName("datosgenerales")
    private Datosgenerales mDatosgenerales;
    @SerializedName("registros")
    private List<Registro> mRegistros;

    public Datosgenerales getDatosgenerales() {
        return mDatosgenerales;
    }

    public List<Registro> getRegistros() {
        return mRegistros;
    }



    public class Registro extends RealmObject {

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

    }

    public class Datosgenerales extends RealmObject {

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


    }


}
