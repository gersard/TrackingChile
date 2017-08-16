package cl.gersard.trackingchile.repository;

import android.util.Log;

import cl.gersard.trackingchile.domain.Track;
import cl.gersard.trackingchile.util.RunnableArgs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Gerardo on 15-08-2017.
 */

public class FuncionesRest {


    public static void consultarSeguimiento(String codSeguimiento, final RunnableArgs block){
        Call<Track> callback = ApiAdapter.getApiService().consultarSeguimiento(codSeguimiento);

        callback.enqueue(new Callback<Track>() {
            @Override
            public void onResponse(Call<Track> call, Response<Track> response) {
                Track tracking = response.body();
                Log.d("RESPUESTA",tracking.getRegistros().get(0).getEstado());
                //TODO AÑADIR A REALM
                //TODO OPCION JSON CON GSON . RETORNAR EN EL BLOCK, LA CLASE TRACKING
                //TODO OPTION REALM, GUARDAS EL TRACK EN BD, TOMAS EL ID Y LO PASAS EN EL BLOCK
                if (tracking.getRegistros() != null){
                    if (block != null){
                        block.setTrack(tracking);
                        block.setResponse(ApiConstants.RESPONSE_OK);
                        block.run();
                    }
                }else{
                    if (block != null){
                        block.setResponse(ApiConstants.RESPONSE_ERROR);
                        block.run();
                    }
                }
            }

            @Override
            public void onFailure(Call<Track> call, Throwable t) {
                if (block != null){
                    block.setResponse(ApiConstants.RESPONSE_ERROR);
                    block.run();
                }
            }
        });

    }

}
