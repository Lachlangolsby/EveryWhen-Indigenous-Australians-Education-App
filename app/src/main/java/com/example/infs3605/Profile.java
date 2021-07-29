package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class Profile extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3605.assignment.intent_message";
    private String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");

        Intent intent = getIntent();
        message = intent.getStringExtra(INTENT_MESSAGE);

        // imports nav view id written at bottom of pages XML file
        navigationView = findViewById(R.id.nav_View);
        // Identifying the Page ID set in the xml (first few lines)
        drawerLayout = findViewById(R.id.Profile);

        //action when navigation menu open and close
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close);
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
                switch (item.getItemId()){
                    case R.id.mHome:
                        Toast.makeText(Profile.this, "Profile page", Toast.LENGTH_SHORT);
                        Intent activityChangeIntent = new Intent(Profile.this, MainActivity.class);
                        Profile.this.startActivity(activityChangeIntent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule1:
                        Toast.makeText(Profile.this, "ArtGallery", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentCalculator = new Intent(Profile.this, ArtGallery.class);
                        Profile.this.startActivity(activityChangeIntentCalculator);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule2:
                        Toast.makeText(Profile.this, "Maps", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentSmartInvesting = new Intent(Profile.this, GoogleMaps.class);
                        Profile.this.startActivity(activityChangeIntentSmartInvesting);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule3:
                        Toast.makeText(Profile.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentFG = new Intent(Profile.this, EventsOffers.class);
                        Profile.this.startActivity(activityChangeIntentFG);
                        break;
                    case R.id.mModule4:
                        Toast.makeText(Profile.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentS = new Intent(Profile.this, StoriesMain.class);
                        Profile.this.startActivity(activityChangeIntentS);
                        break;
                    case R.id.mProfile:
                        Toast.makeText(Profile.this, "Profile", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentP = new Intent(Profile.this, Profile.class);
                        Profile.this.startActivity(activityChangeIntentP);
                        break;
                    case R.id.mShare:
                        String shareMessage = "Join, it's fun and educational.";
                        Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
                        mSharingIntent.setType("Text/Plain");
                        mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "MYFinance HighScore");
                        mSharingIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                        startActivity(Intent.createChooser(mSharingIntent,"Share Score Via"));
                        break;
                    case R.id.mLogout:
                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(Profile.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                        Intent logout = new Intent(Profile.this, Welcome.class);
                        startActivity(logout);
                        drawerLayout.closeDrawers();
                }

                return false;
            }
        });
    }

    // Returning whether menu selected true or false
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}