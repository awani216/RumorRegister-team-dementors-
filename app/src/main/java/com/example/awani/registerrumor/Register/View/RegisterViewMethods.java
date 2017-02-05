package com.example.awani.registerrumor.Register.View;

import com.example.awani.registerrumor.Register.Model.Data.RegisterData;

/**
 * Created by awani on 4/2/17.
 */

public interface  RegisterViewMethods {
    void showProgress(boolean visible);
    void showMessage(String text);
    void Registered(RegisterData registerData);
}
