
package cl.gersard.trackingchile.domain;

import java.util.List;
import com.google.gson.annotations.SerializedName;

@SuppressWarnings("unused")
public class Track {

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

    public class Registro {

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

    public class Datosgenerales {

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
