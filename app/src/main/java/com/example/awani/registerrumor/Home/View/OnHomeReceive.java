package com.example.awani.registerrumor.Home.View;

import com.example.awani.registerrumor.Home.Model.Data.HomeData;

/**
 * Created by awani on 4/2/17.
 */

public interface OnHomeReceive {
    void success(HomeData homeData);
    void failure(Throwable throwable);
}
