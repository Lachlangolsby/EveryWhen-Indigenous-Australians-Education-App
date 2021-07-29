package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class StoriesDetailActivity extends AppCompatActivity {
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3605.assignment.intent_message";

    private TextView mTitle;
    private TextView mStory;
    private ImageView mImage;
    private ImageButton mVideoBtn;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories_detail);
        setTitle("Stories");

        mTitle = findViewById(R.id.dStoryTitle);
        mStory = findViewById(R.id.dStoryText);
        mImage = findViewById(R.id.dStoryImg);
        mVideoBtn = findViewById(R.id.dStoryPlayBtn);

        Intent intent = getIntent();
        String message = intent.getStringExtra(INTENT_MESSAGE);

        ArrayList<Stories> stories = Stories.getStories();
        for(final Stories story : stories) {
            if (story.getId().equals(message)) {
                setTitle(story.getTitle());
                mTitle.setText(story.getTitle());
                mStory.setText(story.getStory());
                mImage.setImageResource(story.getImg());
                mVideoBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchVideo(story.getUrl());
                    }
                });
            }
        }

        // imports nav view id written at bottom of pages XML file
        navigationView = findViewById(R.id.nav_View);
        // Identifying the Page ID set in the xml (first few lines)
        drawerLayout = findViewById(R.id.StoriesDetail);

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
                        Toast.makeText(StoriesDetailActivity.this, "Profile page", Toast.LENGTH_SHORT);
                        Intent activityChangeIntent = new Intent(StoriesDetailActivity.this, MainActivity.class);
                        StoriesDetailActivity.this.startActivity(activityChangeIntent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule1:
                        Toast.makeText(StoriesDetailActivity.this, "ArtGallery", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentCalculator = new Intent(StoriesDetailActivity.this, ArtGallery.class);
                        StoriesDetailActivity.this.startActivity(activityChangeIntentCalculator);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule2:
                        Toast.makeText(StoriesDetailActivity.this, "Maps", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentSmartInvesting = new Intent(StoriesDetailActivity.this, GoogleMaps.class);
                        StoriesDetailActivity.this.startActivity(activityChangeIntentSmartInvesting);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule3:
                        Toast.makeText(StoriesDetailActivity.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentFG = new Intent(StoriesDetailActivity.this, EventsOffers.class);
                        StoriesDetailActivity.this.startActivity(activityChangeIntentFG);
                        break;
                    case R.id.mModule4:
                        Toast.makeText(StoriesDetailActivity.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentS = new Intent(StoriesDetailActivity.this, StoriesMain.class);
                        StoriesDetailActivity.this.startActivity(activityChangeIntentS);
                        break;
                    case R.id.mProfile:
                        Toast.makeText(StoriesDetailActivity.this, "Profile", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentP = new Intent(StoriesDetailActivity.this, Profile.class);
                        StoriesDetailActivity.this.startActivity(activityChangeIntentP);
                        break;
                    case R.id.mShare:
                        String shareMessage = "Join, it's fun and educational.";
                        Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
                        mSharingIntent.setType("Text/Plain");
                        mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "MYFinance HighScore");
                        mSharingIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                        startActivity(Intent.createChooser(mSharingIntent, "Share Score Via"));
                        break;
                    case R.id.mLogout:
                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(StoriesDetailActivity.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                        Intent logout = new Intent(StoriesDetailActivity.this, Welcome.class);
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
    private void searchVideo(String url) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(intent);
    }
}