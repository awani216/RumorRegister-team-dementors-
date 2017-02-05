package com.example.awani.registerrumor.Home.Model;

import com.example.awani.registerrumor.Home.View.OnHomeReceive;

/**
 * Created by awani on 4/2/17.
 */

public interface HomeProvider {
void getFeed(String text, OnHomeReceive onHomeReceive);
}
