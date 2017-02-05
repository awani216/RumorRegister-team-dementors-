package com.example.awani.registerrumor.Report.Model;

import com.example.awani.registerrumor.Report.View.OnReportSend;

/**
 * Created by awani on 4/2/17.
 */

public interface ReportProvider  {
    void report_send(String No_of_cases, String Probable_cause, String doctor_reponse, String symptoms, String current_situation, String local_response, OnReportSend onReportSend);
}
