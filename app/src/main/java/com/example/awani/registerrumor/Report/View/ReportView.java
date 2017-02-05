package com.example.awani.registerrumor.Report.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.awani.registerrumor.MainActivity.MainActivity;
import com.example.awani.registerrumor.R;
import com.example.awani.registerrumor.Register.View.RegisterView;
import com.example.awani.registerrumor.Report.Model.Data.ReportData;
import com.example.awani.registerrumor.Report.Model.RetrofitReportProvider;
import com.example.awani.registerrumor.Report.Presenter.ReportPresenter;
import com.example.awani.registerrumor.Report.Presenter.ReportPresenterImpl;

/**
 * Created by awani on 4/2/17.
 */

public class ReportView extends Activity implements ReportViewMethods {
    EditText et1, et2,et3,et4,et5,et6;
    ReportPresenter reportPresenter;
    Toolbar toolbar;
    Button b;
    ProgressBar pb;
    String No_of_cases,Probable_cause,doctor_reponse,symptoms,current_situation,local_response;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);
        et1= (EditText) findViewById(R.id.report_noofcases);
        et2= (EditText) findViewById(R.id.report_probablecause);
        et3= (EditText) findViewById(R.id.report_doctorresponse);
        et4= (EditText) findViewById(R.id.report_symptoms);
        et5= (EditText) findViewById(R.id.report_currentsituation);
        et6= (EditText) findViewById(R.id.report_localresponse);
        b = (Button) findViewById(R.id.report_submit_button);
        pb= (ProgressBar) findViewById(R.id.report_progressbar);
        toolbar = (Toolbar) findViewById(R.id.toolbar_contactus);
        toolbar.setTitle("Report");
        pb.setVisibility(View.INVISIBLE);
        No_of_cases=et1.getText().toString();
        Probable_cause=et2.getText().toString();
        doctor_reponse=et3.getText().toString();
        symptoms=et4.getText().toString();
        current_situation=et5.getText().toString();
        local_response=et6.getText().toString();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(ReportView.this,MainActivity.class);
                startActivity(next);
                finish();              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });
        reportPresenter= new ReportPresenterImpl(new RetrofitReportProvider(),this);
      b.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {

              //  showMessage("REported Sucessfully");
               reportPresenter.report_send(No_of_cases,Probable_cause,doctor_reponse,symptoms,current_situation,local_response);
          }
      });

    }

    @Override
    public void showProgress(boolean visible) {
        if(visible)
        {
            pb.setVisibility(View.VISIBLE);
        }
        else
            pb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(ReportView.this, ""+text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void OnReportReceived(ReportData reportData) {
if(reportData.isSuccess())
{
    showMessage("Succcessfuly reported");
    Intent next = new Intent(ReportView.this,RegisterView.class);
    startActivity(next);
    finish();
}
        else
{
    showMessage("Not reported sucessfully");
    et1.setText(" ");
    et2.setText(" ");
    et3.setText(" ");
    et4.setText(" ");
    et5.setText(" ");
    et6.setText(" ");
}
    }

}
