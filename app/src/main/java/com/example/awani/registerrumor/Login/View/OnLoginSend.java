package com.example.awani.registerrumor.Login.View;

import com.example.awani.registerrumor.Login.Model.Data.LoginData;

/**
 * Created by awani on 4/2/17.
 */

public interface OnLoginSend {
    void success(LoginData loginData);
    void failure(Throwable throwable);

}
