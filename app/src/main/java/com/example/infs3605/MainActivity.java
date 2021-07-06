package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.top_search_rv);
        mRecyclerView.setHasFixedSize(true);

        ArrayList items = new ArrayList<String>();
        items.add("L1");
        items.add("L2");
        items.add("L3");
        items.add("L4");
        items.add("L5");
        items.add("L6");

        TopSearchAdapter.RecyclerViewClickListener listener = new TopSearchAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String locationName) {
                launchSubPage("detail");
            }
        };

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        mAdapter = new TopSearchAdapter(items, listener);
        mRecyclerView.setAdapter(mAdapter);


        Button profile = findViewById(R.id.profile_button);
        Button interactiveMap = findViewById(R.id.map_button);
        Button eventsOffers = findViewById(R.id.eo_button);
        Button help = findViewById(R.id.help_button);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSubPage("profile");
            }
        });

        interactiveMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSubPage("map");
            }
        });

        eventsOffers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSubPage("events/offers");
            }
        });

        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchSubPage("help");
            }
        });

        // imports nav view id written at bottom of pages XML file
        navigationView = findViewById(R.id.nav_View);
        // Identifying the Page ID set in the xml (first few lines)
        drawerLayout = findViewById(R.id.MainLayout);

        //action when navigation menu open and close
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Navigation menu logic
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.mHome:
                        Toast.makeText(MainActivity.this, "Profile page", Toast.LENGTH_SHORT);
                        Intent activityChangeIntent = new Intent(MainActivity.this, MainActivity.class);
                        MainActivity.this.startActivity(activityChangeIntent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule1:
                        Toast.makeText(MainActivity.this, "ArtGallery", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentCalculator = new Intent(MainActivity.this, ArtGallery.class);
                        MainActivity.this.startActivity(activityChangeIntentCalculator);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule2:
                        Toast.makeText(MainActivity.this, "Maps", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentSmartInvesting = new Intent(MainActivity.this, Maps.class);
                        MainActivity.this.startActivity(activityChangeIntentSmartInvesting);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule3:
                        Toast.makeText(MainActivity.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentFG = new Intent(MainActivity.this, EventsDiscounts.class);
                        MainActivity.this.startActivity(activityChangeIntentFG);
                        break;
                    case R.id.mShare:
                        String shareMessage = "Join, it's fun and eductaional.";
                        Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
                        mSharingIntent.setType("Text/Plain");
                        mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "MYFinance HighScore");
                        mSharingIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                        startActivity(Intent.createChooser(mSharingIntent, "Share Score Via"));
                        break;
//                case R.id.mLogout:
//                    FirebaseAuth.getInstance().signOut();
//                    Toast.makeText(BadgesPage.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
//                    Intent activityChangeIntent2 = new Intent(BadgesPage.this, MainActivity.class);
//                    BadgesPage.this.startActivity(activityChangeIntent2);
//                    drawerLayout.closeDrawers();
//                    break;
                }

                return false;
            }
        });
    }

    //initiating the button's page
    private void launchSubPage(String message) {

        if (message.equals("detail")) {
            Intent intent = new Intent(this, Detail.class);
            startActivity(intent);
        } else if (message.equals("profile")) {
            Intent intent = new Intent(this, Profile.class);
            startActivity(intent);
        } else if (message.equals("map")) {
            Intent intent = new Intent(this, Maps.class);
            startActivity(intent);
        } else if (message.equals("events/offers")) {
            Intent intent = new Intent(this, EventsDiscounts.class);
            startActivity(intent);
        } else if (message.equals("help")) {
            Intent intent = new Intent(this, Help.class);
            startActivity(intent);
        }
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

