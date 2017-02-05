package com.example.awani.registerrumor.Register.Presenter;

import com.example.awani.registerrumor.Register.Model.Data.RegisterData;
import com.example.awani.registerrumor.Register.Model.RegisterProvider;
import com.example.awani.registerrumor.Register.View.RegisterSend;
import com.example.awani.registerrumor.Register.View.RegisterViewMethods;

/**
 * Created by awani on 4/2/17.
 */

public class RegisterPresenterImpl implements RegisterPresenter {
    RegisterViewMethods registerViewMethods;
    RegisterProvider registerProvider;

    public RegisterPresenterImpl( RegisterProvider registerProvider, RegisterViewMethods registerViewMethods) {
        this.registerViewMethods = registerViewMethods;
        this.registerProvider = registerProvider;
    }

    @Override
    public void register_send(String userid, String email, String name, String access, String designation, String address, String village, String city, String state, String mo, String contact) {
    registerViewMethods.showProgress(true);
        registerProvider.register_send(userid, email, name, access, designation, address, village, city, state, mo, contact, new RegisterSend() {
            @Override
            public void success(RegisterData registerData) {
                registerViewMethods.showProgress(false);
                registerViewMethods.Registered(registerData);
            }

            @Override
            public void failure(Throwable throwable) {
                registerViewMethods.showProgress(false);
                registerViewMethods.showMessage("Error try again later !!!!!!");

            }
        });
    }
}
