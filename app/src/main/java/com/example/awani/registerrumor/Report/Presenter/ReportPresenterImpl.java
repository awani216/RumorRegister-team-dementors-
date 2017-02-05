package com.example.awani.registerrumor.Report.Presenter;

import com.example.awani.registerrumor.Report.Model.Data.ReportData;
import com.example.awani.registerrumor.Report.Model.ReportProvider;
import com.example.awani.registerrumor.Report.Model.RetrofitReportProvider;
import com.example.awani.registerrumor.Report.View.OnReportSend;
import com.example.awani.registerrumor.Report.View.ReportView;
import com.example.awani.registerrumor.Report.View.ReportViewMethods;

/**
 * Created by awani on 4/2/17.
 */

public class ReportPresenterImpl implements ReportPresenter {
    ReportProvider reportProvider;
    ReportViewMethods reportViewMethods;



    public ReportPresenterImpl(ReportProvider reportProvider, ReportViewMethods reportViewMethods) {
        this.reportViewMethods = reportViewMethods;
        this.reportProvider = reportProvider;
    }

    @Override
    public void report_send(String No_of_cases, String Probable_cause, String doctor_reponse, String symptoms, String current_situation, String local_response) {
      reportViewMethods.showProgress(true);
        reportProvider.report_send(No_of_cases, Probable_cause, doctor_reponse, symptoms, current_situation, local_response, new OnReportSend() {
            @Override
            public void success(ReportData reportData) {
                reportViewMethods.showProgress(false);
                reportViewMethods.OnReportReceived(reportData);
            }

            @Override
            public void failure(Throwable t) {
                reportViewMethods.showProgress(false);
                reportViewMethods.showMessage("Error please try again !!!!!!!!");
            }
        });
    }
}
