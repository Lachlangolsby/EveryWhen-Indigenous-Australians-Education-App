package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class OffersDetailActivity extends AppCompatActivity {
    // 1. declaring string to be used to pull the attraction code in order to populate the page.
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.tourismguide.intent_message";
    // 2. declaring variables to be correlated with XML UI features
    public Context context;
    private TextView mLocation;
    private ImageView mImage;
    private TextView mEmail;
    private TextView mPhone;
    private TextView mDescription;
    private TextView mTitle;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String value = getIntent().getStringExtra("Data");
        setContentView(R.layout.activity_offers_detail);

        // 3. attaching declared variables with XML UI features
        mLocation = findViewById(R.id.tvAddress);
        mImage = findViewById(R.id.ivImage);
        context = mImage.getContext();
        mEmail = findViewById((R.id.tvEmail));
        mPhone = findViewById((R.id.tvPhone));
        mDescription = findViewById((R.id.tvDescription));
    //    mTitle = findViewById((R.id.tvTitle));


        // 4. using a getter intent to retrieve the Attractions code
        Intent intent = getIntent();
        String AttractionCode = intent.getStringExtra(INTENT_MESSAGE);

        //5. pulling Array List from attractions class
        ArrayList<Offers> Offer = Offers.getOffers();

        //6. if selected attraction matched the attratcion from the array list, changing XML UI details accordingly
        for (final Offers offers : Offer) {

            if (offers.getAttractionCode().equals(AttractionCode)) {
                setTitle(offers.getOffer());
                mLocation.setText(offers.getSuburb());
                mEmail.setText(offers.getEmail());
                mPhone.setText(offers.getPhoneNumber());
                mDescription.setText(offers.getDescription());
             //   mTitle.setText(offers.getOffer());
              Picasso.with(context).load(offers.getQR()).resize(290, 250).into(mImage);
//                Picasso.with(context).load(Attractions.getImageUrl2()).resize(125, 145).into(mImage2);
//                Picasso.with(context).load(Attractions.getImageUrl3()).resize(125, 145).into(mImage3);




                // 7. calling methods to redirect to google maps and more information respectively. Aswell as assigning them to relevant UI elements
                mLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchLocation(offers.getLocation());
                    }
                });

                findViewById((R.id.tvSearch)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchAttraction(offers.getOffer());
                    }
                });




            }
        }
        // imports nav view id written at bottom of pages XML file
        navigationView = findViewById(R.id.nav_View);
        // Identifying the Page ID set in the xml (first few lines)
        drawerLayout = findViewById(R.id.OffersDetails);

        //action when navigation menu open and close
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Navigation menu logic
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.mHome:
                        Toast.makeText(OffersDetailActivity.this, "Profile page", Toast.LENGTH_SHORT);
                        Intent activityChangeIntent = new Intent(OffersDetailActivity.this, MainActivity.class);
                        OffersDetailActivity.this.startActivity(activityChangeIntent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule1:
                        Toast.makeText(OffersDetailActivity.this, "ArtGallery", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentCalculator = new Intent(OffersDetailActivity.this, ArtGallery.class);
                        OffersDetailActivity.this.startActivity(activityChangeIntentCalculator);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule2:
                        Toast.makeText(OffersDetailActivity.this, "Maps", Toast.LENGTH_SHORT);
                        Intent activityChangeIntentSmartInvesting = new Intent(OffersDetailActivity.this, GoogleMaps.class);
                        OffersDetailActivity.this.startActivity(activityChangeIntentSmartInvesting);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule3:
                        Toast.makeText(OffersDetailActivity.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentFG = new Intent(OffersDetailActivity.this, EventsOffers.class);
                        OffersDetailActivity.this.startActivity(activityChangeIntentFG);
                        break;
                    case R.id.mProfile:
                        Toast.makeText(OffersDetailActivity.this, "Profile", Toast.LENGTH_SHORT);
                        drawerLayout.closeDrawers();
                        Intent activityChangeIntentP = new Intent(OffersDetailActivity.this, Profile.class);
                        OffersDetailActivity.this.startActivity(activityChangeIntentP);
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
                        Toast.makeText(OffersDetailActivity.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                        Intent logout = new Intent(OffersDetailActivity.this, Welcome.class);
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


    // 8. Methods for the intent to change activity to the relevant weblinks (google and maps).
    private void searchAttraction(String Offer) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + Offer ));
        startActivity(intent);
    }



    private void searchLocation(String Location) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.au/maps/place/" + Location));
        startActivity(intent);
    }

}