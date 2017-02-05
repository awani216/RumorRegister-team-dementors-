package com.example.awani.registerrumor.Login.Model;

import com.example.awani.registerrumor.Login.Api.LoginApi;
import com.example.awani.registerrumor.Login.Model.Data.LoginData;
import com.example.awani.registerrumor.Login.View.OnLoginSend;
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

public class RetrofitLoginProvider implements LoginProvider {
    @Override
    public void login_data(String username, String password, final OnLoginSend onLoginSend) {
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
        final LoginApi request=retrofit.create(LoginApi.class);
        Call<LoginData> call = request.getSuccess(username,password);

        call.enqueue(new Callback<LoginData>() {


            @Override
            public void onResponse(Call<LoginData> call, Response<LoginData> response) {
                onLoginSend.success(response.body());
            }

            @Override
            public void onFailure(Call<LoginData> call, Throwable t) {

            }
        });
    }
}
