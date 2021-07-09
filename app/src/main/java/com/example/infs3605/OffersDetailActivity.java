package com.example.infs3605;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


//import com.squareup.picasso.Picasso;

import java.util.ArrayList;



public class OffersDetailActivity extends AppCompatActivity {
    // 1. declaring string to be used to pull the attraction code in order to populate the page.
    public static final String INTENT_MESSAGE = "au.edu.unsw.infs3634.tourismguide.intent_message";
    // 2. declaring variables to be correlated with XML UI features
    public Context context;
    private TextView mLocation;
    private TextView mRatings;
    private ImageView mImage;
    private ImageView mImage2;
    private ImageView mImage3;
    private TextView mEmail;
    private TextView mPhone;
    private TextView mDescription;
    private TextView mTitle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String value = getIntent().getStringExtra("Data");
        setContentView(R.layout.activity_offers_detail);

        // 3. attaching declared variables with XML UI features
        mLocation = findViewById(R.id.tvPriceGuide);
        mRatings = findViewById(R.id.tvRating);
        mImage = findViewById(R.id.ivAttraction);
        mImage2 = findViewById(R.id.ivAttraction2);
        mImage3 = findViewById(R.id.ivAttraction3);
        context = mImage.getContext();
        mEmail = findViewById((R.id.tvEmail));
        mPhone = findViewById((R.id.tvPhone));
        mDescription = findViewById((R.id.tvDescription));
        mTitle = findViewById((R.id.tvTitle));


        // 4. using a getter intent to retrieve the Attractions code
        Intent intent = getIntent();
        String AttractionCode = intent.getStringExtra(INTENT_MESSAGE);

        //5. pulling Array List from attractions class
        ArrayList<Offers> Offer = Offers.getAttractions();

        //6. if selected attraction matched the attratcion from the array list, changing XML UI details accordingly
        for (final Offers offers : Offer) {

            if (offers.getAttractionCode().equals(AttractionCode)) {
                setTitle(offers.getAttraction());
                mLocation.setText(offers.getLocation());
                mRatings.setText(String.valueOf(offers.getRating()));
                mEmail.setText(offers.getEmail());
                mPhone.setText(offers.getPhoneNumber());
                mDescription.setText(offers.getDescription());
                mTitle.setText(offers.getAttraction());
//                Picasso.with(context).load(Attractions.getImageUrl()).resize(125, 145).into(mImage);
//                Picasso.with(context).load(Attractions.getImageUrl2()).resize(125, 145).into(mImage2);
//                Picasso.with(context).load(Attractions.getImageUrl3()).resize(125, 145).into(mImage3);




                // 7. calling methods to redirect to google maps and more information respectively. Aswell as assigning them to relevant UI elements
                mLocation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchLocation(offers.getLocation());
                    }
                });

                findViewById((R.id.tvFurtherInfo)).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        searchAttraction(offers.getAttraction());
                    }
                });




            }
        }
    }

    // 8. Methods for the intent to change activity to the relevant weblinks (google and maps).
    private void searchAttraction(String Attraction) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + Attraction + " Sydney"));
        startActivity(intent);
    }



    private void searchLocation(String Location) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com.au/maps/place/" + Location));
        startActivity(intent);
    }

}