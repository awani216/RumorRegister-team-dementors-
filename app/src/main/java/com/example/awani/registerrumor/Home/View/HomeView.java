package com.example.awani.registerrumor.Home.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.awani.registerrumor.Contact.Contacts;
import com.example.awani.registerrumor.Home.Model.Data.HomeData;
import com.example.awani.registerrumor.Home.Model.RetrofitHomeProvider;
import com.example.awani.registerrumor.Home.Presenter.HomePresenter;
import com.example.awani.registerrumor.Home.Presenter.HomePresenterImpl;
import com.example.awani.registerrumor.MainActivity.MainActivity;
import com.example.awani.registerrumor.R;

/**
 * Created by awani on 5/2/17.
 */

public class HomeView extends Activity implements HomeViewMethods {
    TextView tv1, tv2, tv3, tv4;
    HomePresenter homePresenter;
    Toolbar toolbar;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        toolbar = (Toolbar) findViewById(R.id.toolbar_contactus);
        toolbar.setTitle("Contacts");
        pb = (ProgressBar) findViewById(R.id.home_progressbar);
        pb.setVisibility(View.INVISIBLE);
        tv1 = (TextView) findViewById(R.id.home_feed1);
        tv2 = (TextView) findViewById(R.id.home_feed2);
        tv3 = (TextView) findViewById(R.id.home_feed3);
        tv4 = (TextView) findViewById(R.id.home_feed4);
        homePresenter = new HomePresenterImpl(new RetrofitHomeProvider(), this);
        homePresenter.getFeed("getFeed");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(HomeView.this,MainActivity.class);
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
        {
            pb.setVisibility(View.INVISIBLE);
        }

    }

    @Override
    public void showMessage(String text) {
        Toast.makeText(HomeView.this, ""+text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void display_home(HomeData homeData) {
        tv1.setText(homeData.getFeed1());
        tv2.setText(homeData.getFeed2());
        tv3.setText(homeData.getFeed3());
        tv4.setText(homeData.getFeed4());
    }
}
