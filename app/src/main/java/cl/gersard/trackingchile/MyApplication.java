package cl.gersard.trackingchile;

import android.app.Application;

import java.util.concurrent.atomic.AtomicInteger;

import cl.gersard.trackingchile.domain.Datosgenerales;
import cl.gersard.trackingchile.domain.Registro;
import cl.gersard.trackingchile.domain.Track;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by Gerardo on 16-08-2017.
 */

public class MyApplication extends Application {

    public static AtomicInteger idTrack;
    public static AtomicInteger idRegistro;
    public static AtomicInteger idDatosGenerales;

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        RealmConfiguration realmConfig = new RealmConfiguration.Builder()
//                .schemaVersion(0)
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(realmConfig);

        Realm realm = Realm.getDefaultInstance();
        idTrack = getIdByTable(realm, Track.class, Track.FIELD_ID);
        idRegistro = getIdByTable(realm, Registro.class, Registro.FIELD_ID);
        idDatosGenerales = getIdByTable(realm, Datosgenerales.class, Datosgenerales.FIELD_ID);
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass, String nameField) {
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max(nameField).intValue()) : new AtomicInteger();

    }
}
