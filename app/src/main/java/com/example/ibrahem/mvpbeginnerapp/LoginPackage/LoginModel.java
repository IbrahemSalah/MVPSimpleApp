package com.example.ibrahem.mvpbeginnerapp.LoginPackage;

public interface LoginModel {

    interface onLoginFinishedListener {

        void onUserNameError();

        void onPassWordError();

        void onSuccess();

        void onFailure(String message);
    }

    void login(String username, String password, onLoginFinishedListener listener);
}
