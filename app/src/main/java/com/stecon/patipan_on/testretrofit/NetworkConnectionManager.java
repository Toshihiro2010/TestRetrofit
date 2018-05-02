package com.stecon.patipan_on.testretrofit;

import okhttp3.CertificatePinner;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by patipan_on on 5/2/2018.
 */

public class NetworkConnectionManager {

    public NetworkConnectionManager() {

    }

    public void callServer(final OnNetworkCallbackListener listener, String username) {

        OkHttpClient okHttpClient = UnsafeOkHttpClient.getUnsafeOkHttpClient();





        final Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        APIService apiService = retrofit.create(APIService.class);
        Call call = apiService.getUser(username);

        call.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Call<User> call, Response<User> response) {

                User user = response.body();

                if (user == null) {
                    ResponseBody responseBody = response.errorBody();
                    if (responseBody != null) {
                        listener.onBodyError(responseBody);

                    } else {
                        listener.onBodyErrorIsNull();

                    }
                } else {
                    listener.onResponse(user, retrofit);

                }

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                listener.onFialure(t);

            }
        });
    }
}
