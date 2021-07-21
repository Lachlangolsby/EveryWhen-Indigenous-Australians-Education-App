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

import java.util.List;

public class GoogleMaps extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    SupportMapFragment mapFrag;
    LocationRequest mLocationRequest;
    Location mLastLocation;
    Marker mCurrLocationMarker;
    FusedLocationProviderClient mFusedLocationClient;

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

        addMuseumsToMap();
        addTrailsToMap();
        addOutdoorsToMap();
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

    private void addMuseumsToMap()
    {
        Drawable drawable=ContextCompat.getDrawable(getApplicationContext(),R.drawable.museum);

        MarkerOptions marker1 = new MarkerOptions();
        marker1.position(COOEE1)
                .title("Cooee Art Gallery")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker1);

        MarkerOptions marker2 = new MarkerOptions();
        marker2.position(COOEE2)
                .title("Cooee Art Gallery")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker2);

        MarkerOptions marker3 = new MarkerOptions();
        marker3.position(WENTWORTH)
                .title("Wentworth Gallery")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker3);

        MarkerOptions marker4 = new MarkerOptions();
        marker4.position(ABORIGINALCONTEMPORARY)
                .title("Aboriginal Contemporary")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker4);

        MarkerOptions marker5 = new MarkerOptions();
        marker5.position(SPIRIT)
                .title("Spirit Gallery")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker5);

        MarkerOptions marker6 = new MarkerOptions();
        marker6.position(KARLANGU)
                .title("Karlangu Aboriginal Art Centre")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker6);

        MarkerOptions marker7 = new MarkerOptions();
        marker7.position(NSW)
                .title("Art Gallery of New South Wales")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker7);

        MarkerOptions marker8 = new MarkerOptions();
        marker8.position(MCA)
                .title("Museum of Contemporary Art")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker8);

        MarkerOptions marker9 = new MarkerOptions();
        marker9.position(BURRUNJU)
                .title("Burrunju Art Gallery")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker9);

        MarkerOptions marker10 = new MarkerOptions();
        marker10.position(NGA)
                .title("National Gallery of Australia")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker10);

        MarkerOptions marker11 = new MarkerOptions();
        marker11.position(DREAMINGS)
                .title("Aboriginal Dreamings Gallery")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker11);

        MarkerOptions marker12 = new MarkerOptions();
        marker12.position(BIRRUNGA)
                .title("Birrunga Gallery & Dining")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker12);

        MarkerOptions marker13 = new MarkerOptions();
        marker13.position(REDSAND)
                .title("Red Sand Art Gallery")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker13);

        MarkerOptions marker14 = new MarkerOptions();
        marker14.position(BOOMERANG)
                .title("Boomerang Art Aboriginal Art Gallery")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker14);

        MarkerOptions marker15 = new MarkerOptions();
        marker15.position(WOOLLOONGABBA)
                .title("Woolloongabba Art Gallery")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker15);
    }

    private void addTrailsToMap()
    {
        Drawable drawable=ContextCompat.getDrawable(getApplicationContext(),R.drawable.trail);

        MarkerOptions marker1 = new MarkerOptions();
        marker1.position(GREATNORTH)
                .title("Great North Walk")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker1);

        MarkerOptions marker2 = new MarkerOptions();
        marker2.position(FINCHLEY)
                .title("Finchley Track")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker2);

        MarkerOptions marker3 = new MarkerOptions();
        marker3.position(SYDS)
                .title("Syd's Rapids & Aboriginal Heritage Trail")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker3);

        MarkerOptions marker4 = new MarkerOptions();
        marker4.position(UBIRR)
                .title("Ubirr Aboriginal Art Walk")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker4);

        MarkerOptions marker5 = new MarkerOptions();
        marker5.position(KARIONG)
                .title("Kariong to Bulgandry Aboriginal Art Site")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker5);

        MarkerOptions marker6 = new MarkerOptions();
        marker6.position(HERITAGE)
                .title("Aboriginal Heritage Walk")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker6);

        MarkerOptions marker7 = new MarkerOptions();
        marker7.position(MURRAMARANG)
                .title("Murramarang Aboriginal Area Track")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker7);

        MarkerOptions marker8 = new MarkerOptions();
        marker8.position(BUNDIAN)
                .title("Bundian Way")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker8);

        MarkerOptions marker9 = new MarkerOptions();
        marker9.position(YAPPA)
                .title("Mulgowan (Yappa) Aboriginal Art Site Walking Track")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker9);

        MarkerOptions marker10 = new MarkerOptions();
        marker10.position(NOURLANGIE)
                .title("Nourlangie Trail")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker10);

    }

    private void addOutdoorsToMap() {
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.outdoor);

        MarkerOptions marker1 = new MarkerOptions();
        marker1.position(REDFERN)
                .title("Welcome to Redfern")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker1);

        MarkerOptions marker2 = new MarkerOptions();
        marker2.position(JENNYMUNRO)
                .title("Portrait of Jenny Munro")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker2);

        MarkerOptions marker3 = new MarkerOptions();
        marker3.position(BANDB)
                .title("Bibles and Bullets")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker3);

        MarkerOptions marker4 = new MarkerOptions();
        marker4.position(YININMADYEMI)
                .title("Yininmadyemi Memorial")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker4);

        MarkerOptions marker5 = new MarkerOptions();
        marker5.position(MANGROVE)
                .title("Mangrove Cap")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker5);

        MarkerOptions marker6 = new MarkerOptions();
        marker6.position(WTS)
                .title("Witnessing to Silence")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker6);

        MarkerOptions marker7 = new MarkerOptions();
        marker7.position(BARA)
                .title("Bara")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker7);

        MarkerOptions marker8 = new MarkerOptions();
        marker8.position(WARDANDI)
                .title("Wardandi Boodja")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker8);

        MarkerOptions marker9 = new MarkerOptions();
        marker9.position(COLLYMONGLE)
                .title("Collymongle Carved Trees")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker9);

        MarkerOptions marker10 = new MarkerOptions();
        marker10.position(WHALE)
                .title("Whale Carving")
                .draggable(true)
                .icon(convertDrawableToBitmap(drawable));
        mMap.addMarker(marker10);
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