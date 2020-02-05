package com.dossmann.appgooglemaps;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

public class MyItem implements ClusterItem {
    private LatLng position;
    private String title;

    public MyItem(double lat,double lng, String title){
        position = new LatLng(lat, lng);
        title = title;
    }

    public MyItem(LatLng _position, String _title){
        position = _position;
        title = _title;
    }

    @Override
    public LatLng getPosition() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public String getSnippet() {
        return null;
    }
}
