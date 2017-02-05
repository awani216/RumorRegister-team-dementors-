package com.example.awani.registerrumor.Login.Model;

import com.example.awani.registerrumor.Login.View.OnLoginSend;

/**
 * Created by awani on 4/2/17.
 */

public interface LoginProvider {
void login_data(String username, String password, OnLoginSend onLoginSend);
}
