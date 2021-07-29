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
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class EventsDetailActivity extends AppCompatActivity {

    public static final String EVENT_MESSAGE = "EventMessage";
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;
    private TextView eventDateByMonth;
    private TextView eventTitle;
    private ImageView eventImage;
    private TextView detailsText;
    private TextView eventFullDate;
    private TextView eventPhysicalLocation;
    private TextView eventDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_events_detail);

        eventDateByMonth = findViewById(R.id.monthDateTv);
        eventTitle = findViewById(R.id.eventTitleTv);
        eventImage = findViewById(R.id.eventImageIv);
        detailsText = findViewById(R.id.detailsTextTv);
        eventFullDate = findViewById(R.id.actualDateTv);
        eventPhysicalLocation = findViewById(R.id.eventLocationTv);
        eventDetails = findViewById(R.id.eventDescriptionTv);

        Intent intent = getIntent();
        String eventName = intent.getStringExtra(EVENT_MESSAGE);

        Event event = Event.getEvent(eventName);
        if(event !=null) {
            setTitle(event.getEventName());
            eventDateByMonth.setText(event.getEventMonthDate());
            eventTitle.setText(event.getEventName());
            detailsText.setText("Details");
            eventImage.setImageResource(event.getEventImageId());
            eventFullDate.setText(event.getEventDate());
            eventPhysicalLocation.setText(event.getEventLocation());
            eventDetails.setText(event.getEventDescription());

            findViewById(R.id.eventLocationTv).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showEventLocation(event.getGoogleMapUrl());
                }
            });
        }


    // imports nav view id written at bottom of pages XML file
    navigationView = findViewById(R.id.nav_View);
    // Identifying the Page ID set in the xml (first few lines)
    drawerLayout = findViewById(R.id.EventsDetail);

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
                    Toast.makeText(EventsDetailActivity.this, "Profile page", Toast.LENGTH_SHORT);
                    Intent activityChangeIntent = new Intent(EventsDetailActivity.this, MainActivity.class);
                    EventsDetailActivity.this.startActivity(activityChangeIntent);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule1:
                    Toast.makeText(EventsDetailActivity.this, "ArtGallery", Toast.LENGTH_SHORT);
                    Intent activityChangeIntentCalculator = new Intent(EventsDetailActivity.this, ArtGallery.class);
                    EventsDetailActivity.this.startActivity(activityChangeIntentCalculator);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule2:
                    Toast.makeText(EventsDetailActivity.this, "Maps", Toast.LENGTH_SHORT);
                    Intent activityChangeIntentSmartInvesting = new Intent(EventsDetailActivity.this, GoogleMaps.class);
                    EventsDetailActivity.this.startActivity(activityChangeIntentSmartInvesting);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mModule3:
                    Toast.makeText(EventsDetailActivity.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentFG = new Intent(EventsDetailActivity.this, EventsOffers.class);
                    EventsDetailActivity.this.startActivity(activityChangeIntentFG);
                    break;
                case R.id.mModule4:
                    Toast.makeText(EventsDetailActivity.this, "EventsDiscounts", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentS = new Intent(EventsDetailActivity.this, StoriesMain.class);
                    EventsDetailActivity.this.startActivity(activityChangeIntentS);
                    break;
                case R.id.mProfile:
                    Toast.makeText(EventsDetailActivity.this, "Profile", Toast.LENGTH_SHORT);
                    drawerLayout.closeDrawers();
                    Intent activityChangeIntentP = new Intent(EventsDetailActivity.this, Profile.class);
                    EventsDetailActivity.this.startActivity(activityChangeIntentP);
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
                    Toast.makeText(EventsDetailActivity.this, "You are Logged Out", Toast.LENGTH_SHORT).show();
                    Intent logout = new Intent(EventsDetailActivity.this, Welcome.class);
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

    private void showEventLocation(String googleMapsUrl) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(googleMapsUrl));
        startActivity(intent);
    }
}
