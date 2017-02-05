package com.example.awani.registerrumor.Login.Presenter;

import com.example.awani.registerrumor.Login.Model.Data.LoginData;
import com.example.awani.registerrumor.Login.Model.LoginProvider;
import com.example.awani.registerrumor.Login.View.LoginViewMethods;
import com.example.awani.registerrumor.Login.View.OnLoginSend;

/**
 * Created by awani on 4/2/17.
 */

public class LoginPresenterImpl implements LoginPresenter {
    LoginProvider loginProvider;
    LoginViewMethods loginViewMethods;

    public LoginPresenterImpl(LoginProvider loginProvider, LoginViewMethods loginViewMethods) {
        this.loginProvider = loginProvider;
        this.loginViewMethods = loginViewMethods;
    }

    @Override
    public void login_send(String username, String password) {
        loginViewMethods.showProgress(true);
        loginProvider.login_data(username, password, new OnLoginSend() {
            @Override
            public void success(LoginData loginData) {
                loginViewMethods.showProgress(false);
                loginViewMethods.onLoginVerified(loginData);
            }

            @Override
            public void failure(Throwable throwable) {
                loginViewMethods.showProgress(false);
                loginViewMethods.showMessage("Error please Try again !!!!!!");
            }
        });

    }
}
