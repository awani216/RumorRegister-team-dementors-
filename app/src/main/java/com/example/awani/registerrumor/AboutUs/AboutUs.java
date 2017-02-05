package com.example.awani.registerrumor.AboutUs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.awani.registerrumor.MainActivity.MainActivity;
import com.example.awani.registerrumor.R;

/**
 * Created by awani on 4/2/17.
 */

public class AboutUs extends Activity {
    Toolbar toolbar;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_us);
        toolbar = (Toolbar) findViewById(R.id.toolbar_contactus);
        toolbar.setTitle("About Us");
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next = new Intent(AboutUs.this,MainActivity.class);
                startActivity(next);
                finish();              //  Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                //        .setAction("Action", null).show();
            }
        });

    }
}
