package com.dossmann.appgooglemaps;

import androidx.fragment.app.FragmentActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap googleMap;
    private Context myContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        myContext = this;
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
        this.googleMap =  googleMap;

        UiSettings uiSettings= googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);

        ClusterManager<MyItem> myClusterManager = new ClusterManager<>(myContext, googleMap);
        googleMap.setOnMarkerClickListener(myClusterManager);
        googleMap.setOnCameraIdleListener(myClusterManager);
        ArrayList<MyItem> items = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            //LatLng currentPosition = new LatLng(48 + (i*0.1), 2 +(i*0.1));
            //LatLng currentPosition = new LatLng(48, 2+i);
            items.add(new MyItem(new LatLng(48,2+i), "name of postion "+i ));



        }
        myClusterManager.addItems(items);

/*
        // Add a marker in Sydney and move the camera
        LatLng paris = new LatLng(48, 02);
        this.googleMap.addMarker(new MarkerOptions().position(paris).title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(paris));
        googleMap.setMyLocationEnabled(true);


        mycluster = new MyItem()
        LatLng berstett = new LatLng(48.4048,7.3931);

        this.googleMap.addMarker(new MarkerOptions().position(berstett).title("Home"));

        for (int i = 0; i < 10; i++){
            LatLng currentPosition = new LatLng(48 + (i*0.1), 2 +(i*0.1));
            MarkerOptions marker = new MarkerOptions();
            marker.position(currentPosition);
            marker.title("Marker " + i);
            this.googleMap.addMarker(marker);

        }
        for (int i = 0; i < 15; i++) {
            LatLng currentPosition = new LatLng(47 + (i * 0.1), 3 + (i * 0.1));
            MarkerOptions marker = new MarkerOptions();
            marker.position(currentPosition);
            marker.title("Marker " + i);
            this.googleMap.addMarker(marker);
        }
*/




    }
}
