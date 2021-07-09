package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    //Initialise Variables
    private Button skipToMain;
    private Button login;
    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        skipToMain = (Button) findViewById(R.id.skipToMain);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);

        //Set OnClickListeners for Buttons
        skipToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toMain = new Intent(Welcome.this, MainActivity.class);
                startActivity(toMain);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(Welcome.this, Login.class);
                startActivity(login);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent register = new Intent(Welcome.this, SignUp.class);
                startActivity(register);
            }
        });
    }
}