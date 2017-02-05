package com.example.awani.registerrumor.Report.View;

import android.app.Activity;

import com.example.awani.registerrumor.Report.Model.Data.ReportData;

/**
 * Created by awani on 4/2/17.
 */

public interface ReportViewMethods  {
void showProgress(boolean visible);
    void showMessage(String text);
    void OnReportReceived(ReportData reportData);
}
