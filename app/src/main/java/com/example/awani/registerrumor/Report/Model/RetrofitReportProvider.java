package com.example.awani.registerrumor.Report.Model;

import com.example.awani.registerrumor.Report.Api.ReportApi;
import com.example.awani.registerrumor.Report.Model.Data.ReportData;
import com.example.awani.registerrumor.Report.View.OnReportSend;
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

public class RetrofitReportProvider implements  ReportProvider {
    @Override
    public void report_send(String No_of_cases, String Probable_cause, String doctor_reponse, String symptoms, String current_situation, String local_response, final OnReportSend onReportSend) {
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
        final ReportApi request=retrofit.create(ReportApi.class);
        Call<ReportData> call = request.getReportSucess(No_of_cases,Probable_cause,doctor_reponse,symptoms,current_situation,local_response);

        call.enqueue(new Callback<ReportData>() {
            @Override
            public void onResponse(Call<ReportData> call, Response<ReportData> response) {
            onReportSend.success(response.body());
            }

            @Override
            public void onFailure(Call<ReportData> call, Throwable t) {

            }
        } );
    }
}
