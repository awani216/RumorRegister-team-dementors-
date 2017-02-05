package com.example.awani.registerrumor.Report.View;

import com.example.awani.registerrumor.Report.Model.Data.ReportData;

/**
 * Created by awani on 4/2/17.
 */

public interface OnReportSend {
    void success(ReportData reportData);
    void failure(Throwable t);
}
