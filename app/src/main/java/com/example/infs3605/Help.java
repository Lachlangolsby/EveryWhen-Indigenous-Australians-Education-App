package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Help extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3605.assignment.intent_message";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Intent intent = getIntent();
        message = intent.getStringExtra(INTENT_MESSAGE);
    }
}