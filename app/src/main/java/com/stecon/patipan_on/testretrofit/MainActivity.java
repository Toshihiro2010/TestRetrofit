package com.stecon.patipan_on.testretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import okhttp3.CertificatePinner;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //freadJson();


        new NetworkConnectionManager().callServer( new OnNetworkCallbackListener() {
            @Override
            public void onResponse(User user, Retrofit retrofit) {
                Log.d("Request => ", "onResponse");
                Toast.makeText(MainActivity.this, user.getId() + " / " + user.getLogin() + " บ้าบอ", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onBodyError(ResponseBody responseBody) {

                Log.d("Request => ", "onBodyError");
            }

            @Override
            public void onBodyErrorIsNull() {

                Log.d("Request => ", "onBodyErrorIsNull");
            }

            @Override
            public void onFialure(Throwable throwable) {

                Log.d("Request => ", "onFialure");
                Log.d("onFialure => ", throwable + "");
            }
        }, "toshihiro2010");



    }

    private void freadJson() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService apiService = retrofit.create(APIService.class);
        Call<User> call = apiService.getUser("toshihiro2010");

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Log.d("Request => ", "onResponse");
                User user = response.body();
                Toast.makeText(MainActivity.this, user.getId() + " / " + user.getLogin(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.d("Request => ", "onFailure / => " + t);
            }
        });
    }
}
