package cl.gersard.trackingchile.repository;

import okhttp3.ResponseBody;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Gerardo on 15-08-2017.
 */

interface IApiService {

    @GET()
    Callback<ResponseBody> consultarSeguimiento ();
}
