package com.Game.Game.handlers;

import android.content.res.Resources;

import com.Game.Game.functions.FindEntityInfo;
import com.Game.Game.MainActivity;
import com.Game.Game.R;
import com.Game.Game.modelsDB.Bonus;
import com.Game.Game.modelsDB.NPC;
import com.Game.Game.modelsDB.Object;
import com.Game.Game.modelsDB.User;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MarkersHandler extends MainActivity {

//============================================================================//
    //DISPLAYING MARKERS

    //CALLED ON ON_CONNECTED AND ON_CLICK
    public Marker setUserOnMap(GoogleMap map, LatLng location, Marker user){

        if (user != null) {
            user.remove();
        }

        user = map.addMarker(new MarkerOptions()
                .position(location)
                .title("user")
                .snippet("This is Me...")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );
        user.showInfoWindow();

        return user;
    }

    //CALLED ONCONNECTED
    public void setMarkersOnMap(GoogleMap map){

        ArrayList<Object> objs = new ArrayList<>(); //have to retrieve the objects in this arraylist
        ArrayList<NPC> npcs = new ArrayList<>(); //have to retrieve the npcs in this arraylist
        ArrayList<Bonus> bonus = new ArrayList<>(); //have to retrieve the bonus in this arraylist
        Marker marker;
        LatLng latLng;

        //objects
        for (int i=0; i<5; i++) {
            latLng = new LatLng(objs.get(i).getLat(), objs.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(objs.get(i).getObjName())
                    .visible(false)
                    .alpha(1.0f)
            );
            //MarkersData.setMarker(marker, "object");
        }

        //npcs
        for (int i=0; i<5; i++) {
            latLng = new LatLng(npcs.get(i).getLat(), npcs.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(npcs.get(i).getNPCName())
                    .visible(false)
                    .alpha(1.0f)
            );
            //MarkersData.setMarker(marker, "npc");
        }

        //bonus
        for (int i=0; i<5; i++) {
            latLng = new LatLng(bonus.get(i).getLat(), bonus.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(bonus.get(i).getName())
                    .visible(true)
                    .alpha(0.4f)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
            );
            //MarkersData.setMarker(marker, "bonus");
        }

    }

    public void showAllMarkers () {
        ArrayList<Marker> objMarkers = new ArrayList<>(); //retrieve object markers
        ArrayList<Marker> npcMarkers = new ArrayList<>(); //retrieve npc markers
        Marker marker;

        for (int i=0; i<5; i++) {
            marker = objMarkers.get(i);
            setVisible(marker);
            marker = npcMarkers.get(i);
            setVisible(marker);
        }
    }

    public void hideMarkers (int userCount, Marker currentMarker, Marker user) {
        ArrayList<Marker> objMarkers = new ArrayList<>(); //retrieve object markers
        ArrayList<Marker> npcMarkers = new ArrayList<>(); //retrieve npc markers
        Marker marker;

        for (int i=0; i<5; i++) {
            marker = objMarkers.get(i);
            setInvisible(marker);
            marker = npcMarkers.get(i);
            setInvisible(marker);
        }
    }

    public void displayNextEntity (GoogleMap map, int userCount) {
        ArrayList<Marker> objMarkers = new ArrayList<>(); //retrieve object markers
        ArrayList<Marker> npcMarkers = new ArrayList<>(); //retrieve npc markers

        ArrayList<Integer> objCounters = new ArrayList<>(); //retrieve object counters
        ArrayList<Integer> npcCounters = new ArrayList<>(); //retrieve npc counters

        Marker nextMarker;
        int id;

        switch (userCount) {
            case 0:
                id = 0;
                nextMarker = npcMarkers.get(id);
                break;

            case 1:
                id = 0;
                nextMarker = objMarkers.get(id);
                break;

            case 2:
                id = 1;
                nextMarker = npcMarkers.get(id);
                break;

            case 3:
                id = 1;
                nextMarker = objMarkers.get(id);
                break;

            case 4:
                id = 2;
                nextMarker = npcMarkers.get(id);
                break;

            case 5:
                id = 2;
                nextMarker = objMarkers.get(id);
                break;

            case 6:
                id = 3;
                nextMarker = npcMarkers.get(id);
                break;

            case 7:
                id = 3;
                nextMarker = objMarkers.get(id);
                break;

            case 8:
                id = 4;
                nextMarker = npcMarkers.get(id);
                break;

            case 9:
                id = 4;
                nextMarker = objMarkers.get(id);
                break;

            default:
                //on default go to first
                id = 0;
                nextMarker = npcMarkers.get(id);
                break;
        }

        //setting next marker on map
        nextMarker = map.addMarker(new MarkerOptions()
                .position(nextMarker.getPosition())
                .title(nextMarker.getTitle())
                .snippet("This is Next Location...")
        );
        nextMarker.showInfoWindow();
    }

//============================================================================//

    public void highlightMarker(Marker marker, Integer tag){
        if (tag != null) {
            marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE));
        }
    }

    public void setOpacity(Marker marker){
        marker.setAlpha(0.4f);
    }

    public void removeMarker(Marker marker){
        marker.remove();
    }

    public void setVisible(Marker marker) {
        marker.setVisible(true);
    }

    public void setInvisible(Marker marker) {
        marker.setVisible(false);
    }

}
