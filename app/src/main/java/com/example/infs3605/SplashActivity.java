package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {

    TextView textView;
    ImageView cross;
    ImageView background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        textView = (TextView) findViewById(R.id.tvSplash);
        background = (ImageView) findViewById(R.id.ivBackground);
        cross = (ImageView) findViewById(R.id.ivCross);

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveForward();
            }
        });
    }

    private void moveForward() {
        Intent intent = new Intent(SplashActivity.this, Welcome.class);
        startActivity(intent);
    }
}