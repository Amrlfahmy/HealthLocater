package com.example.maps_apps;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.example.maps_apps.databinding.ActivityMapsBinding;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private static final int MY_LOCATION_REQUEST_CODE = 123;
    Toolbar mapsToolbar;
    private FirebaseAuth authProfile;
    private GoogleMap mMap;

    private ImageButton nearbyButton;

    MarkerOptions marker;
    LatLng centerlocation;

    Vector<MarkerOptions> markerOptions;
    private ActivityMapsBinding binding;
    private FusedLocationProviderClient fusedLocationClient;
    private static final int NEARBY_PLACES_RADIUS = 5000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_maps);
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        binding = ActivityMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        nearbyButton = findViewById(R.id.nearby_button);

        mapsToolbar = findViewById(R.id.maps_toolbar);
        setSupportActionBar(mapsToolbar);  // Set the support action bar

        getSupportActionBar().setTitle(R.string.app_name);

        authProfile = FirebaseAuth.getInstance();

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


        centerlocation = new LatLng(6.445018177159034, 100.27441054955123);

        markerOptions = new Vector<>();

        markerOptions.add(new MarkerOptions().title("Chenang Clinic Cawangan Kangar")
                .position(new LatLng(6.433399928887737, 100.19600582911538))
                .snippet("Open everyday: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Klinik & Surgeri Sedhu Ram")
                .position(new LatLng(6.435785251071963, 100.30065216902815))
                .snippet("Open everyday: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Klinik Remedic Kangar")
                .position(new LatLng(6.436160662606408, 100.1883514448676))
                .snippet("Open everyday: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Poliklinik Perubatan Dr. Suraya")
                .position(new LatLng(6.452468590304441, 100.20599775547694))
                .snippet("Open everyday: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Klinik Faizah (Kangar)")
                .position(new LatLng(6.439386847298593, 100.19609052028285))
                .snippet("Open everyday: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Arau Health Clinic")
                .position(new LatLng(6.432413329640264, 100.27053740430509))
                .snippet("Open everyday: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("UniMAP Health Center")
                .position(new LatLng(6.461314264050639, 100.35084778834317))
                .snippet("Open everyday: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Pauh Health Clinic")
                .position(new LatLng(6.436987597095188, 100.303011834085))
                .snippet("Open everyday: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("Tuanku Fauziah Hospital, Kangar")
                .position(new LatLng(6.440891761117198, 100.1913690695284))
                .snippet("Open everyday: 24 hours")
        );

        markerOptions.add(new MarkerOptions().title("KPJ PERLIS SPECIALIST HOSPITAL (HOSPITAL PAKAR KPJ PERLIS)")
                .position(new LatLng(6.43321382729048, 100.18648139154843))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Hospital Sultanah Bahiyah")
                .position(new LatLng(6.1488325003758915, 100.40637215894405))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Metro Specialist Hospital")
                .position(new LatLng(5.629276919038214, 100.51013103919885))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Batu Gajah Hospital")
                .position(new LatLng(4.481157725068006, 101.03530755612174))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Poliklinik Dr. Azhar Dan Rakan-Rakan Batu Gajah")
                .position(new LatLng(4.48694708589723, 101.03218519515481))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Klinik Redza24Jam Cawangan Batu Gajah")
                .position(new LatLng(4.48780276172964, 101.03124105763042))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Batu Gajah Women and Children Health Clinic")
                .position(new LatLng(4.478518625559223, 101.03943788800802))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Poliklinik Permai")
                .position(new LatLng(4.474668027548704, 101.04042494111557))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Poliklinik dan Surgeri Batu Gajah")
                .position(new LatLng(4.473619805672158, 101.04250633525274))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Ong Polyclinic Batu Gajah")
                .position(new LatLng(4.473020821090607, 101.04056441604881))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Perak Medical Centre (Cawangan Batu Gajah)")
                .position(new LatLng(4.4727641132358915, 101.04229175860756))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Ali Klinik")
                .position(new LatLng(4.469277156279587, 101.0428603869459))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Klinik Teoh & Chan")
                .position(new LatLng(4.469277156279587, 101.0428603869459))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Poliklinik An-Nuur")
                .position(new LatLng(4.474759175011462, 101.04941975004817))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Sungai Buloh Hospital")
                .position(new LatLng(3.219733678510762, 101.58329031222473))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Sungai Buloh Health Clinic")
                .position(new LatLng(3.2194443976146068, 101.5784808042488))
                .snippet("Open everyday: 24 hours")
        );
        markerOptions.add(new MarkerOptions().title("Tengku Ampuan Rahimah Hospital, Klang")
                .position(new LatLng(3.0220549191614814, 101.44134169319416))
                .snippet("Open everyday: 24 hours")
        );


        // ImageButton onClickListener
        nearbyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getCurrentLocationAndShowNearbyPlaces();
            }
        });
    }

    private void getCurrentLocationAndShowNearbyPlaces() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            // Get the last known location
            fusedLocationClient.getLastLocation()
                    .addOnSuccessListener(this, location -> {
                        if (location != null) {
                            LatLng currentLatLng = new LatLng(location.getLatitude(), location.getLongitude());
                            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 14)); // Zoom level can be adjusted

                            // Show nearby places
                            showNearbyPlaces(currentLatLng);
                        } else {
                            Toast.makeText(this, "Unable to get current location", Toast.LENGTH_SHORT).show();
                        }
                    });
        } else {
            // Request location permission
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            ActivityCompat.requestPermissions(this, perms, MY_LOCATION_REQUEST_CODE);
        }
    }

    private void showNearbyPlaces(LatLng currentLatLng) {
        mMap.clear(); // Clear existing markers

        for (MarkerOptions mark : markerOptions) {
            mMap.addMarker(mark);
        }

        // Add nearby places markers
        for (MarkerOptions placeMarker : getNearbyPlaces(currentLatLng)) {
            mMap.addMarker(placeMarker);
        }
    }

    private List<MarkerOptions> getNearbyPlaces(LatLng currentLatLng) {
        // Your logic to retrieve nearby hospitals or clinics based on the current location
        // For example, you can use Google Places API or a custom method
        // Here, we'll add a sample marker for demonstration purposes

        List<MarkerOptions> nearbyPlaces = new ArrayList<>();

        // Sample nearby place
        LatLng samplePlace = new LatLng(currentLatLng.latitude + 0.01, currentLatLng.longitude + 0.01);
        MarkerOptions sampleMarker = new MarkerOptions()
                .position(samplePlace)
                .title("Sample Nearby Place")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)); // Change marker color
        nearbyPlaces.add(sampleMarker);

        return nearbyPlaces;
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
    public void onMapReady(GoogleMap googleMap) {

        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);
        //mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        for (MarkerOptions mark: markerOptions) {
            mMap.addMarker(mark);
        }

        enableMyLocation();

        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(centerlocation,15));
    }

    /**
     * Enables the My Location layer if the fine location permission has been granted.
     */
    private void enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            if (mMap != null) {
                mMap.setMyLocationEnabled(true);
            }
        } else {
            String perms[] = {"android.permission.ACCESS_FINE_LOCATION"};
            //Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(this, perms, MY_LOCATION_REQUEST_CODE);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_LOCATION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                // Location permission granted, enable location
                enableMyLocation();
            } else {
                // Location permission denied, handle accordingly
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }



    //Creating ActionBar Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate menu items
        getMenuInflater().inflate(R.menu.common_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.item_share) {
            Intent shareIntent = new Intent(Intent.ACTION_SEND);
            shareIntent.setType("text/plain");
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Please use my application - https://github.com/nurul2208");
            startActivity(Intent.createChooser(shareIntent, null));
            return true;
        } else if (id == R.id.item_about) {
            Intent aboutIntent = new Intent(MapsActivity.this, AboutActivity.class);
            startActivity(aboutIntent);
            return true;
        } else if (id == R.id.item_profile) {
            Intent profileIntent = new Intent(MapsActivity.this, UserProfileActivity.class);
            startActivity(profileIntent);
            return true;
        } else if (id == R.id.item_logout) {
            authProfile.signOut();
            Intent logIntent = new Intent(MapsActivity.this, MainActivity.class);
            logIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(logIntent);
            finish();
            return true;

        }
        return super.onOptionsItemSelected(item);
    }


}