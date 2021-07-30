package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Profile extends AppCompatActivity {

    private FirebaseUser user;
    private FirebaseAuth fAuth;
    private DatabaseReference databaseReference;
    private String userUID;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    private ImageView avatar;
    private TextView userName;
    private TextView userEmail;
    private Button changePersonalDetails;
    private Button changePassword;
    private Button changeAvatar;

    private String fName;
    private String lName;
    private String email;
    private int avatar_code;

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

        avatar = findViewById(R.id.avatar);
        userName = findViewById(R.id.userName);
        userEmail = findViewById(R.id.userEmail);
        changePersonalDetails = findViewById(R.id.changeDetails);
        changePassword = findViewById(R.id.changePassword);
        changeAvatar = findViewById(R.id.changeAvatar);

        //Set Button OnClickListeners
        changePersonalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent personalDetails = new Intent(Profile.this, PersonalDetails.class);
                startActivity(personalDetails);
            }
        });

        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent verifyUser = new Intent(Profile.this, VerifyUser.class);
                startActivity(verifyUser);
            }
        });

        changeAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newAvatar();
            }
        });

        user = FirebaseAuth.getInstance().getCurrentUser();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        userUID = user.getUid();

        databaseReference.child(userUID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                //Get User Details
                User profile = snapshot.getValue(User.class);
                fName = profile.firstName;
                lName = profile.lastName;
                email = profile.email;
                avatar_code = profile.avatar;

                if(profile != null){
                    //Set avatar as the user's selected avatar
                    avatar.setImageResource(avatar_code);

                    //Direct User to Change Avatar Page if they Click on the Image
                    avatar.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            newAvatar();
                        }
                    });

                    //Show user's name and email
                    String userDetails = fName.substring(0, 1).toUpperCase() + fName.substring(1)
                            + " " + lName.substring(0, 1).toUpperCase() + lName.substring(1);
                    userName.setText(userDetails);

                    userEmail.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        //action when navigation menu open and close
        toggle = new ActionBarDrawerToggle(this, drawerLayout,R.string.open,R.string.close);
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
                switch (item.getItemId()){
                    case R.id.mHome:
                        Toast.makeText(Profile.this, "Profile page", Toast.LENGTH_SHORT);
                        Intent activityChangeIntent = new Intent(Profile.this, MainActivity.class);
                        Profile.this.startActivity(activityChangeIntent);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule1:
                        Toast.makeText(Profile.this, "Art Gallery", Toast.LENGTH_SHORT);
                        Intent activityArtGallery = new Intent(Profile.this, ArtGallery.class);
                        Profile.this.startActivity(activityArtGallery);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule2:
                        Toast.makeText(Profile.this, "Maps", Toast.LENGTH_SHORT);
                        Intent activityMaps = new Intent(Profile.this, GoogleMaps.class);
                        Profile.this.startActivity(activityMaps);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule3:
                        Toast.makeText(Profile.this, "Events/Offers", Toast.LENGTH_SHORT);
                        Intent activityEventsOffers = new Intent(Profile.this, EventsOffers.class);
                        Profile.this.startActivity(activityEventsOffers);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mModule4:
                        Toast.makeText(Profile.this, "Stories", Toast.LENGTH_SHORT);
                        Intent activityStories = new Intent(Profile.this, StoriesMain.class);
                        Profile.this.startActivity(activityStories);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mProfile:
                        Toast.makeText(Profile.this, "Profile", Toast.LENGTH_SHORT);
                        Intent activityProfile = new Intent(Profile.this, Profile.class);
                        Profile.this.startActivity(activityProfile);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.mShare:
                        String shareMessage = "Join, it's fun and educational.";
                        Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
                        mSharingIntent.setType("Text/Plain");
                        mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Everywhen");
                        mSharingIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                        startActivity(Intent.createChooser(mSharingIntent,"Everywhen"));
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

    private void newAvatar(){
        Intent newAvatar = new Intent(Profile.this, Avatar.class);
        startActivity(newAvatar);
    }
}