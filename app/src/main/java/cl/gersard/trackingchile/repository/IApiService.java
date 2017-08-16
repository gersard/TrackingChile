package cl.gersard.trackingchile.repository;

import cl.gersard.trackingchile.domain.Track;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Gerardo on 15-08-2017.
 */

interface IApiService {


    @GET("{codigo}")
    Call<Track> consultarSeguimiento(@Path("codigo") String codigo);

}
