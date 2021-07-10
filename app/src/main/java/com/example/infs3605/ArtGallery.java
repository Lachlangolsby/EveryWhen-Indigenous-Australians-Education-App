package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ArtGallery extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArtAdapter mAdapter;
    private ArtDatabase mDb;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_art_gallery);
        setTitle("Art Gallery");

        mRecyclerView = findViewById(R.id.display_rv);
        mRecyclerView.setHasFixedSize(true);
        ArtAdapter.RecyclerViewClickListener listener = new ArtAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, String id) {
                launchDetailActivity(id);
            }
        };
        mAdapter = new ArtAdapter(new ArrayList<Art>(), listener);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
        mDb = Room.databaseBuilder(getApplicationContext(), ArtDatabase.class, "art-database").build();

        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                ArrayList<Art> artworks = (ArrayList<Art>) mDb.artDao().getArtworks();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mAdapter.setData(artworks);
                    }
                });
            }
        });

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://data.nma.gov.au/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ArtService service = retrofit.create(ArtService.class);
        Call<List<Art>> responseCall = service.getArt();
        responseCall.enqueue(new Callback<List<Art>>() {
            @Override
            public void onResponse(Call<List<Art>> call, retrofit2.Response<List<Art>> response) {

            }

            @Override
            public void onFailure(Call<List<Art>> call, Throwable t) {

            }

        });
    }

    private void launchDetailActivity(String message) {
        Intent intent = new Intent(this, Detail.class);
        intent.putExtra(Detail.INTENT_MESSAGE, message);
        startActivity(intent);
    }
}

//    // imports nav view id written at bottom of pages XML file
//    navigationView = findViewById(R.id.nav_View);
//    // Identifying the Page ID set in the xml (first few lines)
//    drawerLayout = findViewById(R.id.ArtGallery);
//
//    //action when navigation menu open and close
//    toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close);
//    drawerLayout.addDrawerListener(toggle);
//    toggle.syncState();
//    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//    //Navigation menu logic
//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()){
//                case R.id.mHome:
//                    Toast.makeText(ArtGallery.this, "Profile page", Toast.LENGTH_SHORT);
//                    Intent activityChangeIntent = new Intent(ArtGallery.this, MainActivity.class);
//                    ArtGallery.this.startActivity(activityChangeIntent);
//                    drawerLayout.closeDrawers();
//                    break;
//                case R.id.mModule1:
//                    Toast.makeText(ArtGallery.this, "ArtGallery", Toast.LENGTH_SHORT);
//                    Intent activityChangeIntentCalculator = new Intent(ArtGallery.this, ArtGallery.class);
//                    ArtGallery.this.startActivity(activityChangeIntentCalculator);
//                    drawerLayout.closeDrawers();
//                    break;
//                case R.id.mModule2:
//                    Toast.makeText(ArtGallery.this, "Maps", Toast.LENGTH_SHORT);
//                    Intent activityChangeIntentSmartInvesting = new Intent(ArtGallery.this, Maps.class);
//                    ArtGallery.this.startActivity(activityChangeIntentSmartInvesting);
//                    drawerLayout.closeDrawers();
//                    break;
//                case R.id.mModule3:
//                    Toast.makeText(ArtGallery.this, "EventsDiscounts", Toast.LENGTH_SHORT);
//                    drawerLayout.closeDrawers();
//                    Intent activityChangeIntentFG = new Intent(ArtGallery.this, EventsOffers.class);
//                    ArtGallery.this.startActivity(activityChangeIntentFG);
//                    break;
//                case R.id.mProfile:
//                    Toast.makeText(ArtGallery.this, "Profile", Toast.LENGTH_SHORT);
//                    drawerLayout.closeDrawers();
//                    Intent activityChangeIntentP = new Intent(ArtGallery.this, Profile.class);
//                    ArtGallery.this.startActivity(activityChangeIntentP);
//                    break;
//                case R.id.mShare:
//                    String shareMessage = "Join, it's fun and eductaional.";
//                    Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
//                    mSharingIntent.setType("Text/Plain");
//                    mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "MYFinance HighScore");
//                    mSharingIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
//                    startActivity(Intent.createChooser(mSharingIntent,"Share Score Via"));
//                    break;
////                case R.id.mLogout:
////                    FirebaseAuth.getInstance().signOut();
////                    Toast.makeText(BadgesPage.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
////                    Intent activityChangeIntent2 = new Intent(BadgesPage.this, MainActivity.class);
////                    BadgesPage.this.startActivity(activityChangeIntent2);
////                    drawerLayout.closeDrawers();
////                    break;
//            }
//
//            return false;
//        }
//    });
//}
//
//    // Returning whether menu selected true or false
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (toggle.onOptionsItemSelected(item)){
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void launchSubPage (String message) {
//        Intent intent = new Intent(this, Detail.class);
//        startActivity(intent);
//    }
//}
