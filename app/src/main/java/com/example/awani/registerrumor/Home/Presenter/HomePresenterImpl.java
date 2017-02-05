package com.example.awani.registerrumor.Home.Presenter;

import com.example.awani.registerrumor.Home.Model.Data.HomeData;
import com.example.awani.registerrumor.Home.Model.HomeProvider;
import com.example.awani.registerrumor.Home.View.HomeViewMethods;
import com.example.awani.registerrumor.Home.View.OnHomeReceive;

/**
 * Created by awani on 4/2/17.
 */

public class HomePresenterImpl implements HomePresenter{
    HomeProvider homeProvider;
    HomeViewMethods homeViewMethods;

    public HomePresenterImpl(HomeProvider homeProvider, HomeViewMethods homeViewMethods) {
        this.homeViewMethods = homeViewMethods;
        this.homeProvider = homeProvider;
    }

    @Override
    public void getFeed(String text) {
        homeViewMethods.showProgress(true);
        homeProvider.getFeed(text,new OnHomeReceive() {
            @Override
            public void success(HomeData homeData) {
                homeViewMethods.showProgress(false);
                homeViewMethods.display_home(homeData);
            }

            @Override
            public void failure(Throwable throwable) {
                homeViewMethods.showProgress(false);
                homeViewMethods.showMessage("Error in loading.....Try again......");
            }
        });

    }
}
