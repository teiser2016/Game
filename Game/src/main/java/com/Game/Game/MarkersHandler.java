package com.Game.Game;

public class MarkersHandler {

    public void setMarkersOnMap(GoogleMap map){

        Marker m1 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086316, 23.547215))
                .title("1")
        );
        m1.setTag(1);
        //markersList.add(m1);

        Marker m2 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086652, 23.546853))
                .title("2")
        );
        m2.setTag(2);
        //markersList.add(m2);

        Marker m3 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086409, 23.546440))
                .title("3")
        );
        m3.setTag(3);
        //markersList.add(m3);

        Marker m4 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086172, 23.546035))
                .title("4")
        );
        m4.setTag(4);
        //markersList.add(m4);

        Marker m5 = map.addMarker(new MarkerOptions()
                .position(new LatLng(41.086586, 23.545613))
                .title("5")
        );
        m5.setTag(5);
        //markersList.add(m5);
    }

    public void highlightMarker(Marker marker, Integer tag){

        if (tag != null) {
            marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        }
    }

}
