package com.example.awani.registerrumor.Login.View;

import com.example.awani.registerrumor.Login.Model.Data.LoginData;

/**
 * Created by awani on 4/2/17.
 */

public interface LoginViewMethods {
void showProgress(boolean visible);
void    showMessage(String text);
void     onLoginVerified(LoginData loginData);
}
