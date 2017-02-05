package com.example.awani.registerrumor.Register.Model;

import com.example.awani.registerrumor.Register.View.RegisterSend;

/**
 * Created by awani on 4/2/17.
 */

public interface RegisterProvider {
    void register_send(String userid, String email , String name, String access, String designation, String address, String village, String city, String state, String mo, String contact, RegisterSend registerSend);
}
