package com.example.awani.registerrumor.Home.Model.Data;

/**
 * Created by awani on 4/2/17.
 */

public class HomeData {
    String feed1, feed2, feed3,feed4;

    public HomeData(String feed1, String feed2, String feed3, String feed4) {
        this.feed1 = feed1;
        this.feed2 = feed2;
        this.feed3 = feed3;
        this.feed4 = feed4;
    }

    public String getFeed1() {
        return feed1;
    }

    public String getFeed2() {
        return feed2;
    }

    public String getFeed3() {
        return feed3;
    }

    public String getFeed4() {
        return feed4;
    }
}
