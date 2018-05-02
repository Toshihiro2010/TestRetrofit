package com.stecon.patipan_on.testretrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by patipan_on on 4/30/2018.
 */

public interface APIService {

    @GET("/users/{username}")
    Call<User> getUser(@Path("username") String username);

}
