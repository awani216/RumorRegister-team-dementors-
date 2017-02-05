package com.example.awani.registerrumor.Login.Model.Data;

/**
 * Created by awani on 4/2/17.
 */

public class LoginData {
    String message;
    int id;
    boolean success;
    boolean register;

    public boolean isRegister() {
        return register;
    }

    public LoginData(int id, boolean success, String message,boolean register) {
        this.id = id;
        this.success = success;
        this.message = message;
        this.register=register;
    }

    public String getMessage() {
        return message;
    }

    public int getId() {
        return id;
    }

    public boolean isSuccess() {
        return success;
    }
}

