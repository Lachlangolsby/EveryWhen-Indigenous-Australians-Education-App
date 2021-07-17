package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Detail extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3605.assignment.intent_message";

    private TextView mTitle;
    private TextView mType;
    private TextView mRegion;
    private TextView mDate;
    private TextView mCreator;
    private TextView mDescription;
    private ImageView mArt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = (TextView) findViewById(R.id.tvArtTitle);
        mType = (TextView) findViewById(R.id.tvArtType);
        mRegion = (TextView) findViewById(R.id.tvArtRegion);
        mDate = (TextView) findViewById(R.id.tvArtDate);
        mCreator = (TextView) findViewById(R.id.tvArtCreator);
        mDescription = (TextView) findViewById(R.id.tvArtDescription);
        mArt = (ImageView) findViewById(R.id.ivArt);

        Intent intent = getIntent();
        String id = intent.getStringExtra(INTENT_MESSAGE);

        Art art = Art.getArt(id);
        if(art != null) {
            mTitle.setText(art.getArtTitle());
            mType.setText(art.getArtType());
            mRegion.setText(art.getArtRegion());
            mDate.setText(art.getArtDate());
            mCreator.setText(art.getArtCreator());
            mDescription.setText(art.getArtPhysicalDescription());
//            int poster = getResources().getIdentifier("au.edu.unsw.infs3634.movierecommender:drawable/poster" + movie.getId(), null, null);
//            mPoster.setImageResource(poster);
        }
    }
}