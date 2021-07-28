package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class ArtGallery extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private GalleryAdapter mAdapter;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_art_gallery);
        setTitle("Art Gallery");

        mRecyclerView = findViewById(R.id.art_gallery_rv);
        GalleryAdapter.RecyclerViewClickListener galleryListener = new GalleryAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String id) {
                launchDetailActivity(id);
            }
        };

        mAdapter = new GalleryAdapter(Art.getArtworks(), galleryListener);
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
                    Intent activityChangeIntentSmartInvesting = new Intent(ArtGallery.this, GoogleMaps.class);
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

    private void launchDetailActivity(String message) {
        Intent intent = new Intent(this, Detail.class);
        intent.putExtra(Detail.INTENT_MESSAGE, message);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.gallery_menu, menu);
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

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()) {
            case R.id.sortType:
                mAdapter.sort(GalleryAdapter.SORT_TYPE);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
