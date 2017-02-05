package com.example.awani.registerrumor.Register.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.awani.registerrumor.MainActivity.MainActivity;
import com.example.awani.registerrumor.R;
import com.example.awani.registerrumor.Register.Model.Data.RegisterData;
import com.example.awani.registerrumor.Register.Model.RetrofitRegisterProvider;
import com.example.awani.registerrumor.Register.Presenter.RegisterPresenter;
import com.example.awani.registerrumor.Register.Presenter.RegisterPresenterImpl;

/**
 * Created by awani on 4/2/17.
 */

public class RegisterView extends Activity implements RegisterViewMethods {
    ProgressBar pb;
    Toolbar toolbar;
    EditText et1, et2, et3, et4, et5, et6, et7, et8, et9, et10, et11;
    String userid, email, name, access, designation, address, village, city, state, mo, contact;
    Button b;
    RegisterPresenter registerPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        toolbar = (Toolbar) findViewById(R.id.toolbar_register);
        toolbar.setTitle("Register");
       pb= (ProgressBar) findViewById(R.id.register_progressbar);
        et1= (EditText) findViewById(R.id.register_userid);
        et2= (EditText) findViewById(R.id.register_email);
        et3= (EditText) findViewById(R.id.register_name);
        et4= (EditText) findViewById(R.id.register_access);
        et5= (EditText) findViewById(R.id.register_designation);
        et6= (EditText) findViewById(R.id.register_address);
        et7= (EditText) findViewById(R.id.register_village);
        et8= (EditText) findViewById(R.id.register_city);
        et9= (EditText) findViewById(R.id.register_state);
        et10= (EditText) findViewById(R.id.register_mo);
        et11= (EditText) findViewById(R.id.register_contact);
        pb.setVisibility(View.INVISIBLE);
        registerPresenter= new RegisterPresenterImpl(new RetrofitRegisterProvider(), this);
        b= (Button) findViewById(R.id.register_button_submit);
        userid=et1.getText().toString();
        email=et2.getText().toString();
        name=et3.getText().toString();
        access=et4.getText().toString();
        designation=et5.getText().toString();
        address=et6.getText().toString();
        village=et7.getText().toString();
        city=et8.getText().toString();
        state=et9.getText().toString();
        mo=et10.getText().toString();
        contact=et11.getText().toString();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerPresenter.register_send(userid,email,name,access,designation,address,village,city,state,mo,contact);
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
        Toast.makeText(RegisterView.this, ""+text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void Registered(RegisterData registerData)
    {
        if(registerData.isSuccess())
        {
            Intent next = new Intent(RegisterView.this,MainActivity.class);
            startActivity(next);
            finish();
        }
        else
        {
            showMessage(registerData.getMessage());
        }
    }



}