package com.example.awani.registerrumor.Login.Api;

import com.example.awani.registerrumor.Login.Model.Data.LoginData;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by awani on 4/2/17.
 */

public interface LoginApi {
    @FormUrlEncoded
    @POST("test/")
     Call<LoginData> getSuccess(@Field("username") String username, @Field("password") String password);
}
