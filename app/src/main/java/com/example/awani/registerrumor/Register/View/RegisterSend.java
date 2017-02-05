package com.example.awani.registerrumor.Register.View;

import com.example.awani.registerrumor.Register.Model.Data.RegisterData;

/**
 * Created by awani on 4/2/17.
 */

public interface RegisterSend {
    void success(RegisterData registerData);
    void failure(Throwable throwable);
}
