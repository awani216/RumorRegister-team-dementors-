package com.example.awani.registerrumor.Login.View;

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

import com.example.awani.registerrumor.Login.Model.Data.LoginData;
import com.example.awani.registerrumor.Login.Model.RetrofitLoginProvider;
import com.example.awani.registerrumor.Login.Presenter.LoginPresenter;
import com.example.awani.registerrumor.Login.Presenter.LoginPresenterImpl;
import com.example.awani.registerrumor.MainActivity.MainActivity;
import com.example.awani.registerrumor.R;
import com.example.awani.registerrumor.Register.View.RegisterView;

/**
 * Created by awani on 4/2/17.
 */

public class LoginView extends Activity implements LoginViewMethods {
    EditText et1,et2;
    ProgressBar pb;
    Button b;
    LoginPresenter loginPresenter;
    String username,password;
    Toolbar toolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        toolbar = (Toolbar) findViewById(R.id.toolbar_contactus);
        toolbar.setTitle("Login");
        et1= (EditText) findViewById(R.id.login_username);
        et2= (EditText) findViewById(R.id.login_password);
        pb= (ProgressBar) findViewById(R.id.login_progressbar);
        b= (Button) findViewById(R.id.login_button);
        loginPresenter= new LoginPresenterImpl(new RetrofitLoginProvider(),this);
        username=et1.getText().toString();
        password=et2.getText().toString();
        pb.setVisibility(View.INVISIBLE);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login_send(username,password);
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(LoginView.this,MainActivity.class);
                startActivity(next);
                finish();              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
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
        Toast.makeText(LoginView.this, ""+text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onLoginVerified(LoginData loginData) {
        if(loginData.isSuccess())
        {
            if(loginData.isRegister())
            {
                Intent next = new Intent(LoginView.this,RegisterView.class);
                startActivity(next);
                finish();
            }
            else
            {
                Intent next = new Intent(LoginView.this, MainActivity.class);
                startActivity(next);
                finish();
            }
        }
        else
        {
            showMessage(loginData.getMessage());
        }
    }
}
