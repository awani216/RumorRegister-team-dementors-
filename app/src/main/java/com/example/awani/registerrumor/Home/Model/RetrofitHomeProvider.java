package com.example.awani.registerrumor.Home.Model;

import com.example.awani.registerrumor.Home.Api.HomeApi;
import com.example.awani.registerrumor.Home.Model.Data.HomeData;
import com.example.awani.registerrumor.Home.View.OnHomeReceive;
import com.example.awani.registerrumor.Login.Api.LoginApi;
import com.example.awani.registerrumor.Login.Model.Data.LoginData;
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

public class RetrofitHomeProvider implements HomeProvider {
    @Override
    public void getFeed(final String text, final OnHomeReceive onHomeReceive) {
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
        final HomeApi request = retrofit.create(HomeApi.class);
        Call<HomeData> call = request.getHomeData(text);

        call.enqueue(new Callback<HomeData>() {


            @Override
            public void onResponse(Call<HomeData> call, Response<HomeData> response) {
                onHomeReceive.success(response.body());
            }

            @Override
            public void onFailure(Call<HomeData> call, Throwable t) {

            }
        });
    }
}