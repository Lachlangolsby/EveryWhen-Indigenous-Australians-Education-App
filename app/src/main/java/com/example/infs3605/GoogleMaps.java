package com.example.infs3605;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.widget.CheckBox;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class GoogleMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFrag;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    FusedLocationProviderClient mFusedLocationClient;
    CheckBox museums, publicArt, trails;

    //Define location list for each category
    List<Marker> museumsList = new ArrayList<>();
    List<Marker> trailsList = new ArrayList<>();
    List<Marker> publicArtList = new ArrayList<>();

    private static final LatLng COOEE1 = new LatLng(-33.890933, 151.270582);
    private static final LatLng COOEE2 = new LatLng(-33.894292, 151.214739);
    private static final LatLng WENTWORTH = new LatLng(-33.867540, 151.208320);
    private static final LatLng ABORIGINALCONTEMPORARY = new LatLng(-33.900678, 151.253835);
    private static final LatLng SPIRIT = new LatLng(-33.858349, 151.208723);
    private static final LatLng KARLANGU = new LatLng(-33.866861, 151.205809);
    private static final LatLng NSW = new LatLng(-33.868403, 151.216749);
    private static final LatLng MCA = new LatLng(-33.859885, 151.208724);
    private static final LatLng BURRUNJU = new LatLng(-35.288029, 149.083314);
    private static final LatLng NGA = new LatLng(-35.300075, 149.136204);
    private static final LatLng DREAMINGS = new LatLng(-35.191287, 149.084485);
    private static final LatLng REDSAND = new LatLng(-27.462726, 153.006210);
    private static final LatLng BIRRUNGA = new LatLng(-27.465441, 153.028917);
    private static final LatLng BOOMERANG = new LatLng(-26.527945, 153.089503);
    private static final LatLng WOOLLOONGABBA = new LatLng(-27.485627, 153.029538);

    private static final LatLng GREATNORTH = new LatLng(-33.47172, 151.2881);
    private static final LatLng FINCHLEY = new LatLng(-32.93853,151.14059);
    private static final LatLng SYDS = new LatLng(-31.73664,116.07069);
    private static final LatLng UBIRR = new LatLng(-12.41193,132.95793);
    private static final LatLng KARIONG = new LatLng(-33.44568,151.28491);
    private static final LatLng HERITAGE = new LatLng(-33.577967, 151.300208);
    private static final LatLng MURRAMARANG = new LatLng(-35.53015, 150.39279);
    private static final LatLng BUNDIAN = new LatLng(-36.980722, 148.860959);
    private static final LatLng YAPPA = new LatLng(-30.640346, 145.768007);
    private static final LatLng NOURLANGIE = new LatLng(-12.866921, 132.811765);

    private static final LatLng REDFERN = new LatLng(-33.890774, 151.197723);
    private static final LatLng JENNYMUNRO = new LatLng(-33.877300, 151.203105);
    private static final LatLng BANDB = new LatLng(-33.894905, 151.205927);
    private static final LatLng YININMADYEMI = new LatLng(-33.875344, 151.209981);
    private static final LatLng MANGROVE = new LatLng(-21.142175, 149.200571);
    private static final LatLng BARA = new LatLng(-33.859061, 151.214098);
    private static final LatLng WTS = new LatLng(-27.467610, 153.022034);
    private static final LatLng WARDANDI = new LatLng(-33.320350, 115.646415);
    private static final LatLng COLLYMONGLE = new LatLng(-29.462113, 148.739310);
    private static final LatLng WHALE = new LatLng(-33.988918, 151.231964);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFrag.getMapAsync(this);

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onPause() {
        super.onPause();

        //stop location updates when Activity is no longer active
        if (mFusedLocationClient != null) {
            mFusedLocationClient.removeLocationUpdates(mLocationCallback);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(120000); // two minute interval
        mLocationRequest.setFastestInterval(120000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            //Location Permission already granted
            mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback,
                    Looper.myLooper());
            mMap.setMyLocationEnabled(true);
        } else {
            //Request Location Permission
            checkLocationPermission();
        }

        mMap.getUiSettings().setZoomControlsEnabled(true);
        addMarkersToMap();

        museums = (CheckBox) findViewById(R.id.cMuseums);
        publicArt = (CheckBox) findViewById(R.id.cPublicArt);
        trails = (CheckBox) findViewById(R.id.cTrails);
        museums.setChecked(true);
        publicArt.setChecked(true);
        trails.setChecked(true);

        //check museum check box
        museums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (museums.isChecked()) {
                    for (Marker marker : museumsList) {
                        marker.setVisible(true);
                    }
                } else {
                    for (Marker marker : museumsList) {
                        marker.setVisible(false);
                    }
                }
            }
        });

        //check publicArt check box
        publicArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (publicArt.isChecked()) {
                    for (Marker marker : publicArtList) {
                        marker.setVisible(true);
                    }
                } else {
                    for (Marker marker : publicArtList) {
                        marker.setVisible(false);
                    }
                }
            }
        });

        //check trails check box
        trails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (trails.isChecked()) {
                    for (Marker marker : trailsList) {
                        marker.setVisible(true);
                    }
                } else {
                    for (Marker marker : trailsList) {
                        marker.setVisible(false);
                    }
                }
            }
        });

    }

    LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            List<Location> locationList = locationResult.getLocations();
            if (locationList.size() > 0) {
                //The last location in the list is the newest
                Location location = locationList.get(locationList.size() - 1);
                mLastLocation = location;
                if (mCurrLocationMarker != null) {
                    mCurrLocationMarker.remove();
                }

                //move map camera
                LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
                CameraPosition cameraPosition = new CameraPosition.Builder().target(new LatLng(latLng.latitude, latLng.longitude)).zoom(12).build();
                mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
            }
        }
    };

    private BitmapDescriptor convertDrawableToBitmap(Drawable drawable)
    {
        Canvas canvas = new Canvas();
        Bitmap bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        canvas.setBitmap(bitmap);
        drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        drawable.draw(canvas);
        return BitmapDescriptorFactory.fromBitmap(bitmap);
    }

    private void addMarkersToMap() {

        //Add museum pins
        Drawable museumPin = ContextCompat.getDrawable(getApplicationContext(), R.drawable.museum);
        museumsList.add(mMap.addMarker(new MarkerOptions().position(COOEE1).title("Cooee Art Gallery").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(COOEE2).title("Cooee Art Gallery").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(WENTWORTH).title("Wentworth Gallery").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(ABORIGINALCONTEMPORARY).title("Aboriginal Contemporary").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(SPIRIT).title("Spirit Gallery").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(KARLANGU).title("Karlangu Aboriginal Art Centre").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(NSW).title("Art Gallery of New South Wales").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(MCA).title("Museum of Contemporary Art").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(BURRUNJU).title("Burrunju Art Gallery").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(NGA).title("National Gallery of Australia").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(DREAMINGS).title("Aboriginal Dreamings Gallery").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(BIRRUNGA).title("Birrunga Gallery & Dining").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(REDSAND).title("Red Sand Art Gallery").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(BOOMERANG).title("Boomerang Art Aboriginal Art Gallery").icon(convertDrawableToBitmap(museumPin))));
        museumsList.add(mMap.addMarker(new MarkerOptions().position(WOOLLOONGABBA).title("Woolloongabba Art Gallery").icon(convertDrawableToBitmap(museumPin))));

        //Add trail pins
        Drawable trailPin = ContextCompat.getDrawable(getApplicationContext(), R.drawable.trail);
        trailsList.add(mMap.addMarker(new MarkerOptions().position(GREATNORTH).title("Great North Walk").icon(convertDrawableToBitmap(trailPin))));
        trailsList.add(mMap.addMarker(new MarkerOptions().position(FINCHLEY).title("Finchley Track").icon(convertDrawableToBitmap(trailPin))));
        trailsList.add(mMap.addMarker(new MarkerOptions().position(SYDS).title("Syd's Rapids & Aboriginal Heritage Trail").icon(convertDrawableToBitmap(trailPin))));
        trailsList.add(mMap.addMarker(new MarkerOptions().position(UBIRR).title("Ubirr Aboriginal Art Walk").icon(convertDrawableToBitmap(trailPin))));
        trailsList.add(mMap.addMarker(new MarkerOptions().position(KARIONG).title("Kariong to Bulgandry Aboriginal Art Site").icon(convertDrawableToBitmap(trailPin))));
        trailsList.add(mMap.addMarker(new MarkerOptions().position(HERITAGE).title("Aboriginal Heritage Walk").icon(convertDrawableToBitmap(trailPin))));
        trailsList.add(mMap.addMarker(new MarkerOptions().position(MURRAMARANG).title("Murramarang Aboriginal Area Track").icon(convertDrawableToBitmap(trailPin))));
        trailsList.add(mMap.addMarker(new MarkerOptions().position(BUNDIAN).title("Bundian Way").icon(convertDrawableToBitmap(trailPin))));
        trailsList.add(mMap.addMarker(new MarkerOptions().position(YAPPA).title("Mulgowan (Yappa) Aboriginal Art Site Walking Track").icon(convertDrawableToBitmap(trailPin))));
        trailsList.add(mMap.addMarker(new MarkerOptions().position(NOURLANGIE).title("Nourlangie Trail").icon(convertDrawableToBitmap(trailPin))));

        //Add public art pins
        Drawable publicArtPin = ContextCompat.getDrawable(getApplicationContext(), R.drawable.outdoor);
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(REDFERN).title("Welcome to Redfern").icon(convertDrawableToBitmap(publicArtPin))));
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(JENNYMUNRO).title("Portrait of Jenny Munro").icon(convertDrawableToBitmap(publicArtPin))));
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(BANDB).title("Bibles and Bullets").icon(convertDrawableToBitmap(publicArtPin))));
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(YININMADYEMI).title("Yininmadyemi Memorial").icon(convertDrawableToBitmap(publicArtPin))));
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(MANGROVE).title("Mangrove Cap").icon(convertDrawableToBitmap(publicArtPin))));
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(BARA).title("Bara").icon(convertDrawableToBitmap(publicArtPin))));
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(WARDANDI).title("Wardandi Boodja").icon(convertDrawableToBitmap(publicArtPin))));
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(COLLYMONGLE).title("Collymongle Carved Trees").icon(convertDrawableToBitmap(publicArtPin))));;
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(WTS).title("Witnessing to Silence").icon(convertDrawableToBitmap(publicArtPin))));
        publicArtList.add(mMap.addMarker(new MarkerOptions().position(WHALE).title("Whale Carving").icon(convertDrawableToBitmap(publicArtPin))));

    }

    public static final int MY_PERMISSIONS_REQUEST_LOCATION = 99;
    private void checkLocationPermission() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.ACCESS_FINE_LOCATION)) {

                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
                new AlertDialog.Builder(this)
                        .setTitle("Location Permission Needed")
                        .setMessage("This app needs the Location permission, please accept to use location functionality")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //Prompt the user once explanation has been shown
                                ActivityCompat.requestPermissions(GoogleMaps.this,
                                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                                        MY_PERMISSIONS_REQUEST_LOCATION );
                            }
                        })
                        .create()
                        .show();


            } else {
                // No explanation needed, we can request the permission.
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION},
                        MY_PERMISSIONS_REQUEST_LOCATION );
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_LOCATION: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // location-related task you need to do.
                    if (ContextCompat.checkSelfPermission(this,
                            Manifest.permission.ACCESS_FINE_LOCATION)
                            == PackageManager.PERMISSION_GRANTED) {

                        mFusedLocationClient.requestLocationUpdates(mLocationRequest,
                                mLocationCallback, Looper.myLooper());
                        mMap.setMyLocationEnabled(true);
                    }

                } else {
                    // if not allow a permission, the application will exit
                    Intent toHome = new Intent(GoogleMaps.this, MainActivity.class);
                    startActivity(toHome);
                }
            }
        }
    }
}