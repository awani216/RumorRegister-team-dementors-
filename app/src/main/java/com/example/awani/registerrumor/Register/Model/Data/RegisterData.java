package com.example.awani.registerrumor.Register.Model.Data;

/**
 * Created by awani on 4/2/17.
 */

public class RegisterData {
    String message;
    boolean success;

    public RegisterData(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public boolean isSuccess() {
        return success;
    }
}
