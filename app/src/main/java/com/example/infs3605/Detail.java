package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
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

import java.util.ArrayList;

public class Detail extends AppCompatActivity {

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
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setTitle("Art Gallery");

        mTitle = findViewById(R.id.tvArtTitle);
        mType = findViewById(R.id.tvArtType);
        mRegion = findViewById(R.id.tvArtRegion);
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

    //THIS IS THE CODE TO DISPLAY THE EMAIL OF THE CURRENT USER IN THE NAV MENU
    //CURRENTLY THIS CRASHES THE APP IF NO USER LOGGED IN (I.E. SKIP TO MAIN)
        /*
        //Get current user
        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();

        //Displays users email in the drawer
        View headerView = navigationView.getHeaderView(0);
        TextView userEmail = headerView.findViewById(R.id.email);
        if (userEmail != null) {
            userEmail.setText(user.getEmail());;
        }
        */

    //Navigation menu logic
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.mHome:
                    Toast.makeText(Detail.this, "Profile page", Toast.LENGTH_SHORT);
                    Intent activityChangeIntent = new Intent(Detail.this, MainActivity.class);
                    Detail.this.startActivity(activityChangeIntent);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule1:
                    Toast.makeText(Detail.this, "ArtGallery", Toast.LENGTH_SHORT);
                    Intent activityChangeIntentCalculator = new Intent(Detail.this, ArtGallery.class);
                    Detail.this.startActivity(activityChangeIntentCalculator);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule2:
                    Toast.makeText(Detail.this, "Maps", Toast.LENGTH_SHORT);
                    Intent activityChangeIntentSmartInvesting = new Intent(Detail.this, GoogleMaps.class);
                    Detail.this.startActivity(activityChangeIntentSmartInvesting);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule3:
                    Toast.makeText(Detail.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentFG = new Intent(Detail.this, EventsOffers.class);
                    Detail.this.startActivity(activityChangeIntentFG);
                    break;
                case R.id.mProfile:
                    Toast.makeText(Detail.this, "Profile", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentP = new Intent(Detail.this, Profile.class);
                    Detail.this.startActivity(activityChangeIntentP);
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
                    Toast.makeText(Detail.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                    Intent logout = new Intent(Detail.this, Welcome.class);
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