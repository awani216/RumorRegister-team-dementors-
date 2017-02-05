package com.example.awani.registerrumor.Report.Api;

import com.example.awani.registerrumor.Login.Model.Data.LoginData;
import com.example.awani.registerrumor.Report.Model.Data.ReportData;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by awani on 4/2/17.
 */

public interface ReportApi {
    @FormUrlEncoded
    @POST("test/")
    Call<ReportData> getReportSucess(@Field("no_cases") String No_of_cases,@Field("prob_cause") String Probable_cause,
                                     @Field("doc_response") String doctor_reponse,@Field("symptoms") String symptoms,
                                     @Field("cur_sit") String current_situation,@Field("loc_response") String local_response);
}
