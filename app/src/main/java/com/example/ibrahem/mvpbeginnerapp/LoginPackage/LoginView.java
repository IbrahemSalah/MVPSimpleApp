package com.example.ibrahem.mvpbeginnerapp.LoginPackage;

public interface LoginView {

    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToMainActivity();

    void showAlert(String message);
}
