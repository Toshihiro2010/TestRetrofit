package com.stecon.patipan_on.testretrofit;

import okhttp3.ResponseBody;
import retrofit2.Retrofit;

/**
 * Created by patipan_on on 5/2/2018.
 */

public interface OnNetworkCallbackListener {
    public void onResponse(User user, Retrofit retrofit);

    public void onBodyError(ResponseBody responseBody);

    public void onBodyErrorIsNull();

    public void onFialure(Throwable throwable);
}
