package com.example.ibrahem.mvpbeginnerapp.LoginPackage;

public interface LoginPresenter {

    void validateCred(String username, String password);

    void onDestroy();
}
