package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class ArtGallery extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_gallery);
        setTitle("Art Gallery");

        mRecyclerView = findViewById(R.id.display_rv);

        ArrayList artItems = new ArrayList<String>();
        artItems.add("Art 1");
        artItems.add("Art 2");
        artItems.add("Art 3");
        artItems.add("Art 4");
        artItems.add("Art 5");
        artItems.add("Art 6");
        artItems.add("Art 7");
        artItems.add("Art 8");
        artItems.add("Art 9");
        artItems.add("Art 10");


        GalleryAdapter.RecyclerViewClickListener galleryListener = new GalleryAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String art) {
                launchSubPage("detail");
            }
        };

        mAdapter = new GalleryAdapter(artItems, galleryListener);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecyclerView.setAdapter(mAdapter);


    // imports nav view id written at bottom of pages XML file
    navigationView = findViewById(R.id.nav_View);
    // Identifying the Page ID set in the xml (first few lines)
    drawerLayout = findViewById(R.id.ArtGallery);

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
                    Toast.makeText(ArtGallery.this, "Profile page", Toast.LENGTH_SHORT);
                    Intent activityChangeIntent = new Intent(ArtGallery.this, MainActivity.class);
                    ArtGallery.this.startActivity(activityChangeIntent);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule1:
                    Toast.makeText(ArtGallery.this, "ArtGallery", Toast.LENGTH_SHORT);
                    Intent activityChangeIntentCalculator = new Intent(ArtGallery.this, ArtGallery.class);
                    ArtGallery.this.startActivity(activityChangeIntentCalculator);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule2:
                    Toast.makeText(ArtGallery.this, "Maps", Toast.LENGTH_SHORT);
                    Intent activityChangeIntentSmartInvesting = new Intent(ArtGallery.this, Maps.class);
                    ArtGallery.this.startActivity(activityChangeIntentSmartInvesting);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule3:
                    Toast.makeText(ArtGallery.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentFG = new Intent(ArtGallery.this, EventsOffers.class);
                    ArtGallery.this.startActivity(activityChangeIntentFG);
                    break;
                case R.id.mProfile:
                    Toast.makeText(ArtGallery.this, "Profile", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentP = new Intent(ArtGallery.this, Profile.class);
                    ArtGallery.this.startActivity(activityChangeIntentP);
                    break;
                case R.id.mShare:
                    String shareMessage = "Join, it's fun and eductaional.";
                    Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
                    mSharingIntent.setType("Text/Plain");
                    mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "MYFinance HighScore");
                    mSharingIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                    startActivity(Intent.createChooser(mSharingIntent,"Share Score Via"));
                    break;
                case R.id.mLogout:
                    FirebaseAuth.getInstance().signOut();
                    Toast.makeText(ArtGallery.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                    Intent logout = new Intent(ArtGallery.this, Welcome.class);
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

    private void launchSubPage (String message) {
        Intent intent = new Intent(this, Detail.class);
        startActivity(intent);
    }
}
