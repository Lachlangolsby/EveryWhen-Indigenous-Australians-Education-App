package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class StoriesDetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.movierecommender.intent_message";

    private TextView mTitle;
    private TextView mStory;
    private ImageView mImage;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_detail);

    mTitle = (TextView) findViewById(R.id.tvStoryTitleValue);
    mStory = (TextView) findViewById(R.id.tvStoryValue);
    mImage = (ImageView) findViewById(R.id.ivStoryImage);
    mButton = (Button) findViewById(R.id.button);

    Intent intent = getIntent();
    String id = intent.getStringExtra(INTENT_MESSAGE);

    Stories story = Stories.getStory(id);
        if(story != null) {
        mTitle.setText(story.getTitle());
        mStory.setText(story.getStory());
        int poster = getResources().getIdentifier("com.example.infs3605:drawable/poster" + story.getId(), null, null);
        mImage.setImageResource(poster);
            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    searchVideo(story.getUrl());
                }
            });
        }
    }
    private void searchVideo(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}