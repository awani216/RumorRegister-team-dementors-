package com.example.awani.registerrumor.Home.Api;

import com.example.awani.registerrumor.Home.Model.Data.HomeData;
import com.example.awani.registerrumor.Login.Model.Data.LoginData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by awani on 4/2/17.
 */

public interface HomeApi {
    @FormUrlEncoded
    @POST("test/")
    Call<HomeData> getHomeData(@Field("username") String text);
}
