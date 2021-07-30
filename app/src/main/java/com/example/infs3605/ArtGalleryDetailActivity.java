package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.bumptech.glide.Glide;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class ArtGalleryDetailActivity extends AppCompatActivity {

    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3605.assignment.intent_message";

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private TextView mTitle;
    private TextView mType;
    private TextView mRegion;
    private TextView mCreator;
    private TextView mDescription;
    private ImageView mImage;
    FirebaseUser user;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_detail);
        setTitle("Art Gallery");

        mTitle = findViewById(R.id.artName);
        mType = findViewById(R.id.artType);
        mRegion = findViewById(R.id.artRegion);
        mCreator = findViewById(R.id.artCreator);
        mDescription = findViewById(R.id.artPhysicalDescription);
        mImage = findViewById(R.id.artImg);

        Intent intent = getIntent();
        String message = intent.getStringExtra(INTENT_MESSAGE);

        ArrayList<Art> artGallery = Art.getArtworks();
        for(final Art art : artGallery){
            if(art.getArtId().equals(message)){
                setTitle(art.getArtTitle());
                mTitle.setText(art.getArtTitle());
                mType.setText("Type   " + art.getArtType());
                mRegion.setText(art.getArtRegion());
                if(art.getArtDate().equals("Unknown")){
                    mCreator.setText(art.getArtCreator());
                } else {
                    mCreator.setText(art.getArtCreator() +", "+ art.getArtDate());
                }
                mDescription.setText(art.getArtPhysicalDescription());
                Glide.with(this)
                        .load("http://collectionsearch.nma.gov.au/nmacs-image-download/emu/" + art.getArtIdentifier() + ".640x640_640.jpg")
                        .fitCenter()
                        .into(mImage);
            }
        }

    // imports nav view id written at bottom of pages XML file
    navigationView = findViewById(R.id.nav_View);
    // Identifying the Page ID set in the xml (first few lines)
    drawerLayout = findViewById(R.id.Detail);

    //action when navigation menu open and close
    toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
    drawerLayout.addDrawerListener(toggle);
    toggle.syncState();
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Get current user
        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();

        //Display the user's email in the navigation menu header
        View headerView = navigationView.getHeaderView(0);
        TextView userEmail = headerView.findViewById(R.id.email);
        if (userEmail != null) {
            userEmail.setText(user.getEmail());;
        }

        //Navigation menu logic
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mHome:
                    Toast.makeText(ArtGalleryDetailActivity.this, "Profile page", Toast.LENGTH_SHORT);
                    Intent activityChangeIntent = new Intent(ArtGalleryDetailActivity.this, MainActivity.class);
                    ArtGalleryDetailActivity.this.startActivity(activityChangeIntent);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule1:
                    Toast.makeText(ArtGalleryDetailActivity.this, "ArtGallery", Toast.LENGTH_SHORT);
                    Intent activityChangeIntentCalculator = new Intent(ArtGalleryDetailActivity.this, ArtGallery.class);
                    ArtGalleryDetailActivity.this.startActivity(activityChangeIntentCalculator);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule2:
                    Toast.makeText(ArtGalleryDetailActivity.this, "Maps", Toast.LENGTH_SHORT);
                    Intent activityChangeIntentSmartInvesting = new Intent(ArtGalleryDetailActivity.this, GoogleMaps.class);
                    ArtGalleryDetailActivity.this.startActivity(activityChangeIntentSmartInvesting);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule3:
                    Toast.makeText(ArtGalleryDetailActivity.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentFG = new Intent(ArtGalleryDetailActivity.this, EventsOffers.class);
                    ArtGalleryDetailActivity.this.startActivity(activityChangeIntentFG);
                    break;
                case R.id.mModule4:
                    Toast.makeText(ArtGalleryDetailActivity.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentS = new Intent(ArtGalleryDetailActivity.this, StoriesMain.class);
                    ArtGalleryDetailActivity.this.startActivity(activityChangeIntentS);
                    break;
                case R.id.mProfile:
                    Toast.makeText(ArtGalleryDetailActivity.this, "Profile", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentP = new Intent(ArtGalleryDetailActivity.this, Profile.class);
                    ArtGalleryDetailActivity.this.startActivity(activityChangeIntentP);
                    break;
                case R.id.mShare:
                    String shareMessage = "Join, it's fun and eductaional.";
                    Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
                    mSharingIntent.setType("Text/Plain");
                    mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "MYFinance HighScore");
                    mSharingIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(mSharingIntent, "Share Score Via"));
                    break;
                case R.id.mLogout:
                    FirebaseAuth.getInstance().signOut();
                    Toast.makeText(ArtGalleryDetailActivity.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                    Intent logout = new Intent(ArtGalleryDetailActivity.this, Welcome.class);
                    startActivity(logout);
                    drawerLayout.closeDrawers();
                    break;
            }

            return false;
        }
    });
}

    // Returning whether menu selected true or false
    @Override
    public boolean onOptionsItemSelected (@NonNull MenuItem item){
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}