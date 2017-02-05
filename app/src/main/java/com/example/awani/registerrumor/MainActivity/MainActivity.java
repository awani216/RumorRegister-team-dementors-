package com.example.awani.registerrumor.MainActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuInflater;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.awani.registerrumor.AboutUs.AboutUs;
import com.example.awani.registerrumor.Contact.Contacts;
import com.example.awani.registerrumor.Developers.Developers;
import com.example.awani.registerrumor.Home.View.HomeView;
import com.example.awani.registerrumor.Home.View.HomeViewMethods;
import com.example.awani.registerrumor.Login.View.LoginView;
import com.example.awani.registerrumor.R;
import com.example.awani.registerrumor.Register.View.RegisterView;
import com.example.awani.registerrumor.Report.View.ReportView;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
       // getMenuInflater().inflate(R.menu.main, menu);
        //return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        Intent next;
        //noinspection SimplifiableIfStatement


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Intent nav;

        switch(id)
        {
            case(R.id.nav_aboutUs):
                nav=new Intent(MainActivity.this, AboutUs.class);
                startActivity(nav);

                break;
            case(R.id.nav_report):
                nav=new Intent(MainActivity.this,ReportView.class);
                startActivity(nav);
                break;
            case(R.id.nav_contact):
                nav=new Intent(MainActivity.this, Contacts.class);
                startActivity(nav);
                break;
            case(R.id.nav_developers):
                nav=new Intent(MainActivity.this, Developers.class);
                startActivity(nav);
                break;

            case(R.id.nav_home):
                nav= new Intent(MainActivity.this,HomeView.class);
                startActivity(nav);
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
