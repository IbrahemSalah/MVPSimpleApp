package com.example.ibrahem.mvpbeginnerapp.LoginPackage;

import android.text.TextUtils;
import android.os.Handler;


public class LoginModelImpl implements LoginModel {
    @Override
    public void login(String username, String password,final onLoginFinishedListener listener) {
        if (TextUtils.isEmpty(username)) listener.onUserNameError();
        else if(TextUtils.isEmpty(password)) listener.onPassWordError();
        else if(username.equals("admin")&&password.equals("12345")){
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    listener.onSuccess();
                }
            },3000);
        }
        else listener.onFailure("Error In Your Login Process");
    }
}
