package com.Game.Game.handlers;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

public class CameraHandler {

    public void setCamera(GoogleMap map, LatLng position){
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(position)      // Sets the center of the map to position
                .zoom(17)                   // Sets the zoom
                .bearing(0)                // Sets the orientation of the camera
                .tilt(90)                   // Sets the tilt of the camera to 90 degrees
                .build();                   // Creates a CameraPosition from the builder
        map.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

    }

}
