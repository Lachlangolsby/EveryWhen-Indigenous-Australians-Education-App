package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseAuth;

public class EventsOffers extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    TabLayout tabLayout;
    ViewPager2 pager2;
    EventsOffersFragmentAdapter adapter;
    OffersAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_discounts);
        setTitle("Events & Promotions");

        // imports nav view id written at bottom of pages XML file
        navigationView = findViewById(R.id.nav_View);
        // Identifying the Page ID set in the xml (first few lines)
        drawerLayout = findViewById(R.id.EventsDiscounts);

        // initialising views for tab layout
        tabLayout = findViewById(R.id.tab_layout);
        pager2 = findViewById(R.id.view_pager2);

        FragmentManager fm = getSupportFragmentManager();
        adapter = new EventsOffersFragmentAdapter(fm,getLifecycle());
        pager2.setAdapter(adapter);

        tabLayout.addTab(tabLayout.newTab().setText("Events"));
        tabLayout.addTab(tabLayout.newTab().setText("Offers"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
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
                        Toast.makeText(EventsOffers.this, "Profile page", Toast.LENGTH_SHORT);
                        Intent activityChangeIntent = new Intent(EventsOffers.this, MainActivity.class);
                        EventsOffers.this.startActivity(activityChangeIntent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule1:
                        Toast.makeText(EventsOffers.this, "ArtGallery", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentCalculator = new Intent(EventsOffers.this, ArtGallery.class);
                        EventsOffers.this.startActivity(activityChangeIntentCalculator);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule2:
                        Toast.makeText(EventsOffers.this, "Maps", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentSmartInvesting = new Intent(EventsOffers.this, GoogleMaps.class);
                        EventsOffers.this.startActivity(activityChangeIntentSmartInvesting);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule3:
                        Toast.makeText(EventsOffers.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentFG = new Intent(EventsOffers.this, EventsOffers.class);
                        EventsOffers.this.startActivity(activityChangeIntentFG);
                        break;
                    case R.id.mModule4:
                        Toast.makeText(EventsOffers.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentS = new Intent(EventsOffers.this, StoriesMain.class);
                        EventsOffers.this.startActivity(activityChangeIntentS);
                        break;
                    case R.id.mProfile:
                        Toast.makeText(EventsOffers.this, "Profile", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentP = new Intent(EventsOffers.this, Profile.class);
                        EventsOffers.this.startActivity(activityChangeIntentP);
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
                        Toast.makeText(EventsOffers.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                        Intent logout = new Intent(EventsOffers.this, Welcome.class);
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
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
