package com.example.awani.registerrumor.Home.View;

import com.example.awani.registerrumor.Home.Model.Data.HomeData;

/**
 * Created by awani on 4/2/17.
 */

public interface HomeViewMethods {
    void showProgress(boolean visible);
    void showMessage(String text);
    void display_home(HomeData homeData);
}
