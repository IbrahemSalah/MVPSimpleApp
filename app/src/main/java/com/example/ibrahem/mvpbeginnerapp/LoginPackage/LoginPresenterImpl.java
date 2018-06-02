package com.example.ibrahem.mvpbeginnerapp.LoginPackage;

public class LoginPresenterImpl implements LoginPresenter, LoginModel.onLoginFinishedListener {

    LoginView mLoginView;
    LoginModel mLoginModel;

    public LoginPresenterImpl(LoginView mLoginView) {
        this.mLoginView = mLoginView;
        mLoginModel = new LoginModelImpl();
    }

    @Override
    public void validateCred(String username, String password) {
        if (mLoginView != null) {
            mLoginView.showProgress();
            mLoginModel.login(username, password, this);
        }
    }

    @Override
    public void onDestroy() {
        if (mLoginView != null) {
            mLoginView = null;
        }
    }

    @Override
    public void onUserNameError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setUsernameError();
        }
    }

    @Override
    public void onPassWordError() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.setPasswordError();
        }
    }

    @Override
    public void onSuccess() {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.navigateToMainActivity();
        }
    }

    @Override
    public void onFailure(String message) {
        if (mLoginView != null) {
            mLoginView.hideProgress();
            mLoginView.showAlert(message);
        }
    }
}
