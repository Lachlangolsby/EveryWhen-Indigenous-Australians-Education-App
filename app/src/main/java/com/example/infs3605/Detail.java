package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Detail extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3605.assignment.intent_message";

    private TextView mTitle;
    private TextView mType;
    private TextView mRegion;
    private TextView mDate;
    private TextView mCreator;
    private TextView mDescription;
    private ImageView mImage;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        mTitle = findViewById(R.id.tvArtTitle);
        mType = findViewById(R.id.tvArtType);
        mRegion = findViewById(R.id.tvArtRegion);
        mDate = findViewById(R.id.tvArtDate);
        mCreator = findViewById(R.id.tvArtCreator);
        mDescription = findViewById(R.id.tvArtDescription);
        mImage = findViewById(R.id.ivArt);

        Intent intent = getIntent();
        message = intent.getStringExtra(INTENT_MESSAGE);

        ArrayList<Art> artGallery = Art.getArtworks();
        for(final Art art : artGallery){
            if(art.getArtId().equals(message)){
                mTitle.setText(art.getArtTitle());
                mType.setText(art.getArtType());
                mRegion.setText(art.getArtRegion());
                mDate.setText(art.getArtDate());
                mCreator.setText(art.getArtCreator());
                mDescription.setText(art.getArtPhysicalDescription());
                Glide.with(this)
                        .load("http://collectionsearch.nma.gov.au/nmacs-image-download/emu/" + art.getArtIdentifier() + ".640x640_640.jpg")
                        .fitCenter()
                        .into(mImage);
            }
        }


    }
}