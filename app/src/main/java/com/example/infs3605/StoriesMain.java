package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class StoriesMain extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private StoriesAdapter mAdapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    FirebaseUser user;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_stories);
        setTitle("Stories");

        LinearLayoutManager layoutManager = new LinearLayoutManager(StoriesMain.this);
        mRecyclerView = findViewById(R.id.stories_rv);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setHasFixedSize(true);
        StoriesAdapter.RecyclerViewClickListener listener = new StoriesAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String id) {
                launchStoriesDetailActivity(id);
            }
        };
        mAdapter = new StoriesAdapter(Stories.getStories(), listener);
        mRecyclerView.setAdapter(mAdapter);

        // imports nav view id written at bottom of pages XML file
        navigationView = findViewById(R.id.nav_View);
        // Identifying the Page ID set in the xml (first few lines)
        drawerLayout = findViewById(R.id.StoriesMain);

        //action when navigation menu open and close
        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Get current user
        fAuth = FirebaseAuth.getInstance();
        user = fAuth.getCurrentUser();

        //Displays users email in the drawer
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
                        Toast.makeText(StoriesMain.this, "Profile page", Toast.LENGTH_SHORT);
                        Intent activityChangeIntent = new Intent(StoriesMain.this, MainActivity.class);
                        StoriesMain.this.startActivity(activityChangeIntent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule1:
                        Toast.makeText(StoriesMain.this, "ArtGallery", Toast.LENGTH_SHORT);
                        Intent activityArtGallery = new Intent(StoriesMain.this, ArtGallery.class);
                        StoriesMain.this.startActivity(activityArtGallery);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule2:
                        Toast.makeText(StoriesMain.this, "Maps", Toast.LENGTH_SHORT);
                        Intent activityMaps = new Intent(StoriesMain.this, GoogleMaps.class);
                        StoriesMain.this.startActivity(activityMaps);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule3:
                        Toast.makeText(StoriesMain.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityEventsOffers = new Intent(StoriesMain.this, EventsOffers.class);
                        StoriesMain.this.startActivity(activityEventsOffers);
                        break;
                    case R.id.mModule4:
                        Toast.makeText(StoriesMain.this, "Stories", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityStories = new Intent(StoriesMain.this, StoriesMain.class);
                        StoriesMain.this.startActivity(activityStories);
                        break;
                    case R.id.mProfile:
                        Toast.makeText(StoriesMain.this, "Profile", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityProfile = new Intent(StoriesMain.this, Profile.class);
                        StoriesMain.this.startActivity(activityProfile);
                        break;
                    case R.id.mShare:
                        String shareMessage = "Join, it's fun and educational.";
                        Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
                        mSharingIntent.setType("Text/Plain");
                        mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Everywhen");
                        mSharingIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                        startActivity(Intent.createChooser(mSharingIntent, "Everywhen"));
                        break;
                    case R.id.mLogout:
                        FirebaseAuth.getInstance().signOut();
                        Toast.makeText(StoriesMain.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                        Intent logout = new Intent(StoriesMain.this, Welcome.class);
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
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        switch (item.getItemId()) {
            case R.id.sortType:
                mAdapter.sort(StoriesAdapter.SORT_METHOD_ALPHABETICAL);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void launchStoriesDetailActivity(String message) {
        Intent intent = new Intent(this, StoriesDetailActivity.class);
        intent.putExtra(StoriesDetailActivity.INTENT_MESSAGE, message);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.searchList).getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                mAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                mAdapter.getFilter().filter(newText);
                return false;
            }
        });

        return true;
    }
}