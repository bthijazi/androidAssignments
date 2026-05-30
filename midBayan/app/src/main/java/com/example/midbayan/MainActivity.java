package com.example.midbayan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;

    private boolean doubleBackPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        btnLogin = findViewById(R.id.btnLogin);
        etPassword = findViewById(R.id.etPassword);

        TextWatcher watcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
                validateInputs();
            }

            @Override
            public void afterTextChanged(Editable s) {}
        };

        etEmail.addTextChangedListener(watcher);
        etPassword.addTextChangedListener(watcher);

        btnLogin.setOnClickListener(v -> {
            Intent intent =
                    new Intent(MainActivity.this,
                            ModeActivity.class);
            startActivity(intent);
        });

        getOnBackPressedDispatcher().addCallback(this,
                new OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {

                        if (doubleBackPressed) {
                            finishAffinity();
                            return;
                        }

                        doubleBackPressed = true;

                        Snackbar.make(
                                        findViewById(android.R.id.content),
                                        "Press back again to exit",
                                        Snackbar.LENGTH_SHORT)
                                .show();

                        new Handler().postDelayed(() ->
                                doubleBackPressed = false, 2000);
                    }
                });
    }

    private void validateInputs() {

        String email = etEmail.getText().toString().trim();
        String password = etPassword.getText().toString();

        boolean validEmail =
                Patterns.EMAIL_ADDRESS.matcher(email).matches();

        boolean validPassword =
                password.length() >= 6;

        btnLogin.setEnabled(validEmail && validPassword);
    }
}