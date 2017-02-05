package com.example.awani.registerrumor.Register.Api;

import com.example.awani.registerrumor.Login.Model.Data.LoginData;
import com.example.awani.registerrumor.Register.Model.Data.RegisterData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by awani on 4/2/17.
 */

public interface RegisterApi {
    @FormUrlEncoded
    @POST("test/")
    Call<RegisterData> getRegisterSuccess(@Field("user_id") String userid,@Field("email") String email ,@Field("name") String name,@Field("access") String access,@Field("desig") String designation,@Field("address") String address,@Field("vill") String village,@Field("city") String city,@Field("state") String state,@Field("po") String mo,@Field("phone") String contact);

}
