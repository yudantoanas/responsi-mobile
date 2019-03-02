package com.example.responsimobile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    EditText inputUsername, inputPassword;
    Button buttonLogin;
    TextView linkSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // findViewByID
        inputUsername = findViewById(R.id.inputUsername);
        inputPassword = findViewById(R.id.inputPassword);
        buttonLogin = findViewById(R.id.buttonLogin);
        linkSignup = findViewById(R.id.linkSignup);

        // add onclick listener to button
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inputUsername.getText().toString().equals("admin")
                        && inputPassword.getText().toString().equals("12345")){

                    // melakukan intent
                    Intent home = new Intent(LoginActivity.this, MainActivity.class);
                    home.putExtra("user", inputUsername.getText().toString());
                    startActivity(home);
                }
            }
        });

        linkSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // melakukan intent
                Intent signUp = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(signUp);
            }
        });
    }
}
