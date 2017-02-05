package com.example.awani.registerrumor.Register.Model;


import com.example.awani.registerrumor.Register.Api.RegisterApi;
import com.example.awani.registerrumor.Register.Model.Data.RegisterData;
import com.example.awani.registerrumor.Register.View.RegisterSend;
import com.example.awani.registerrumor.Url.Urls;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by awani on 4/2/17.
 */

public class RetrofitRegisterProvider implements RegisterProvider {
    @Override
    public void register_send(String userid, String email, String name, String access, String designation, String address, String village, String city, String state, String mo, String contact, final RegisterSend registerSend) {
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Urls.Base_Url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
        final RegisterApi request=retrofit.create(RegisterApi.class);
        Call<RegisterData> call = request.getRegisterSuccess(userid, email, name, access, designation, address, village, city, state, mo, contact);

        call.enqueue(new Callback<RegisterData>() {


            @Override
            public void onResponse(Call<RegisterData> call, Response<RegisterData> response) {
                registerSend.success(response.body());
            }

            @Override
            public void onFailure(Call<RegisterData> call, Throwable t) {

            }
        });
}
}
