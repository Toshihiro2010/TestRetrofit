package com.stecon.patipan_on.testretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by patipan_on on 5/2/2018.
 */

public class GitHubService {

    public GitHubService() {
    }

    public void callServer() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);


    }
}
