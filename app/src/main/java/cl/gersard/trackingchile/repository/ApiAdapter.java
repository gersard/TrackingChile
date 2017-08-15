package cl.gersard.trackingchile.repository;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gerardo on 15-08-2017.
 */

public class ApiAdapter {

    private static IApiService API_SERVICE;

    public static IApiService getApiService(){
        if (API_SERVICE == null){

            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder()
//                    .addInterceptor(new Interceptor() {
//                        @Override
//                        public Response intercept(Chain chain) throws IOException {
////                            Request request = chain.request().newBuilder()
////                                    .addHeader("assert-api-key", MyApplication.apiKey).build();
////                            return chain.proceed(request);
//                        }
//                    })
                    .addInterceptor(interceptor)
                    .connectTimeout(10, TimeUnit.SECONDS)
                    .readTimeout(10, TimeUnit.SECONDS)
                    .build();

            Retrofit adapter = new Retrofit.Builder()
                    .baseUrl(ApiConstants.URL_BASE)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            API_SERVICE = adapter.create(IApiService.class);


        }
        return API_SERVICE;
    }
}
