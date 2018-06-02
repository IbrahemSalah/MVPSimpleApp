package com.example.ibrahem.mvpbeginnerapp.LoginPackage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.ibrahem.mvpbeginnerapp.MainActivity;
import com.example.ibrahem.mvpbeginnerapp.R;

public class LoginViewActivity extends AppCompatActivity implements LoginView {

    private EditText userNameEditText;
    private EditText passwordEditText;
    private Button doneButton;
    private ProgressBar progressBar;
    private LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mLoginPresenter = new LoginPresenterImpl(this);
        userNameEditText = findViewById(R.id.user_name);
        passwordEditText = findViewById(R.id.user_password);
        doneButton = findViewById(R.id.doneButton);
        progressBar = findViewById(R.id.progressBar);

        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresenter.validateCred(userNameEditText.getText().toString().trim(), passwordEditText.getText().toString().trim());
            }
        });
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        userNameEditText.setError("UserName Empty");
    }

    @Override
    public void setPasswordError() {
        passwordEditText.setError("Password Empty");
    }

    @Override
    public void navigateToMainActivity() {
        startActivity(new Intent(LoginViewActivity.this, MainActivity.class));
    }

    @Override
    public void showAlert(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLoginPresenter.onDestroy();
    }
}
