package com.example.infs3605;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import com.google.android.material.navigation.NavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    // imports nav view id written at bottom of pages XML file
    navigationView = findViewById(R.id.nav_View);
    // Identifying the Page ID set in the xml (first few lines)
    drawerLayout = findViewById(R.id.MainLayout);

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
                case R.id.mProfile:
                    Toast.makeText(MainActivity.this, "Profile page", Toast.LENGTH_SHORT);
                    Intent activityChangeIntent = new Intent(MainActivity.this, MainActivity.class);
                    MainActivity.this.startActivity(activityChangeIntent);
                    drawerLayout.closeDrawers();
                    break;
                case R.id.mShare:
                    String shareMessage = "Join MyFinance, it's fun and eductaional.";
                    Intent mSharingIntent = new Intent(Intent.ACTION_SEND);
                    mSharingIntent.setType("Text/Plain");
                    mSharingIntent.putExtra(Intent.EXTRA_SUBJECT, "MYFinance HighScore");
                    mSharingIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                    startActivity(Intent.createChooser(mSharingIntent,"Share Score Via"));
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

    // Returning whether menu selected true or false
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
