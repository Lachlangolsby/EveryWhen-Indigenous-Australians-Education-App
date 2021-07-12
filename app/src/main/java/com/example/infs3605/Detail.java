package com.example.infs3605;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;
import java.util.concurrent.Executors;

public class Detail extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3605.assignment.intent_message";

    private ArtDatabase mDb;
    private String message;
    private ImageView artwork;
    private TextView title;
    private TextView mediumTitle;
    private TextView regionTitle;
    private TextView artistTitle;
    private TextView descriptionTitle;
    private TextView medium;
    private TextView region;
    private TextView artist;
    private TextView description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        message = intent.getStringExtra(INTENT_MESSAGE);

        artwork = (ImageView) findViewById(R.id.ivArtImage);
        title = (TextView) findViewById(R.id.tvArtTitle);
        mediumTitle = (TextView) findViewById(R.id.tvMediumTitle);
        regionTitle = (TextView) findViewById(R.id.tvRegionTitle);
        artistTitle = (TextView) findViewById(R.id.tvArtistTitle);
        descriptionTitle = (TextView) findViewById(R.id.tvPhysicalDescriptionTitle);
        medium = (TextView) findViewById(R.id.tvMedium);
        region = (TextView) findViewById(R.id.tvRegion);
        artist = (TextView) findViewById(R.id.tvArtist);
        description = (TextView) findViewById(R.id.tvPhysicalDescription);

        mDb = Room.databaseBuilder(getApplicationContext(), ArtDatabase.class, "art-database").build();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                Art artworks = (Art) mDb.artDao().getArtworks();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Glide.with(Detail.this)
                                .load("http://collectionsearch.nma.gov.au/nmacs-image-download/emu/59/985/" + artworks.getArtId() + ".640x640_640.jpg")
                                .fitCenter()
                                .into(artwork);
                        title.setText(String.valueOf(artworks.getArtTitle()));
                        medium.setText(String.valueOf(artworks.getArtAdditionalType()));
                        region.setText(String.valueOf(artworks.getArtRegion()));
                        artist.setText(String.valueOf(artworks.getArtCreator()));
                        description.setText(String.valueOf(artworks.getArtPhysicalDescription()));
                    }
                });
            }
        });

    }
}