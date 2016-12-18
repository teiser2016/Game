package com.Game.Game.handlers;

import android.content.res.Resources;

import com.Game.Game.functions.FindEntityInfo;
import com.Game.Game.MainActivity;
import com.Game.Game.R;
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

    //CALLED ONCONNECTED
    public Marker setUserOnMap(GoogleMap map, LatLng location){

        Marker marker = map.addMarker(new MarkerOptions()
                .position(location)
                .title("user")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );
        marker.showInfoWindow();

        return marker;
    }

    //CALLED ONMARKERCLICK (first time click)
    public Marker updateUserMarker(GoogleMap map, Marker user, LatLng newLocation){
        user.remove();
        user = setUserOnMap(map, newLocation);
        setInvisible(user);

        return user;
    }

    //CALLED ONCONNECTED
    public void setMarkersOnMap(GoogleMap map){

        ArrayList<Object> objs = new ArrayList<>(); //have to retrieve the objects in this arraylist
        ArrayList<NPC> npcs = new ArrayList<>(); //have to retrieve the npcs in this arraylist
        Marker marker;
        LatLng latLng;

        //objects
        for (int i=0; i<5; i++) {
            latLng = new LatLng(objs.get(i).getLat(), objs.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(objs.get(i).getObjName())
                    .snippet("You found a " + objs.get(i).getObjName())
                    .visible(true)
                    .alpha(1.0f)
            );
        }

        //npcs
        for (int i=0; i<5; i++) {
            latLng = new LatLng(npcs.get(i).getLat(), npcs.get(i).getLng());
            marker = map.addMarker(new MarkerOptions()
                    .position(latLng)
                    .title(npcs.get(i).getNPCName())
                    .snippet("Hello Detective...\n" + "I am " + npcs.get(i).getNPCName())
                    .visible(true)
                    .alpha(1.0f)
            );
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

        displayNextEntity(userCount, currentMarker, user);
    }

    public void displayNextEntity (int userCount, Marker currentMarker, Marker user) {
        ArrayList<Marker> objMarkers = new ArrayList<>(); //retrieve object markers
        ArrayList<Marker> npcMarkers = new ArrayList<>(); //retrieve npc markers

        ArrayList<Integer> objCounters = new ArrayList<>(); //retrieve object counters
        ArrayList<Integer> npcCounters = new ArrayList<>(); //retrieve npc counters

        Marker nextMarker;
        int id;
        int markerCount = 0;

        switch (userCount) {
            case 0:
                id = 0;
                nextMarker = npcMarkers.get(id);
                setVisible(nextMarker);
                markerCount = npcCounters.get(id);
                break;

            case 1:
                id = 0;
                nextMarker = objMarkers.get(id);
                setVisible(nextMarker);
                markerCount = objCounters.get(id);
                break;

            case 2:
                id = 1;
                nextMarker = npcMarkers.get(id);
                setVisible(nextMarker);
                markerCount = npcCounters.get(id);
                break;

            case 3:
                id = 1;
                nextMarker = objMarkers.get(id);
                setVisible(nextMarker);
                markerCount = objCounters.get(id);
                break;

            case 4:
                id = 2;
                nextMarker = npcMarkers.get(id);
                setVisible(nextMarker);
                markerCount = npcCounters.get(id);
                break;

            case 5:
                id = 2;
                nextMarker = objMarkers.get(id);
                setVisible(nextMarker);
                markerCount = objCounters.get(id);
                break;

            case 6:
                id = 3;
                nextMarker = npcMarkers.get(id);
                setVisible(nextMarker);
                markerCount = npcCounters.get(id);
                break;

            case 7:
                id = 3;
                nextMarker = objMarkers.get(id);
                setVisible(nextMarker);
                markerCount = objCounters.get(id);
                break;

            case 8:
                id = 4;
                nextMarker = npcMarkers.get(id);
                setVisible(nextMarker);
                markerCount = npcCounters.get(id);
                break;

            case 9:
                id = 4;
                nextMarker = objMarkers.get(id);
                setVisible(nextMarker);
                markerCount = objCounters.get(id);
                break;

            default:
                break;
        }

        if (markerCount > 2) {
            setInvisible(currentMarker); //hide current marker
        }

        //setInvisible(currentMarker); //hide current marker
        setVisible(user); //display user on map
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

//============================================================================//
    //INTERACTION

    public void startInteraction (Marker currentMarker, int pos, String type) {

        currentMarker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_ORANGE));
        //incrementCounter(type, pos);
    }

    public void interactionMode (Marker currentMarker, int pos, String type) {
        User user = new User(); //retrieve user data

        int bonusValue = 0; //get bonus value

        int bonusUser = user.getBonus() + bonusValue;
        user.setBonus(bonusUser);

        //incrementCounter(type, pos);
        //incrementUserCount();
    }

    public void terminateInteraction(Marker currentMarker, Marker user, int pos, String type) {
        User userData = new User(); //retrieve user data

        displayNextEntity(userData.getCount(), currentMarker, user);

        //if it is bonus, hide it
        setInvisible(currentMarker);
    }

//============================================================================//
    //RETRIEVING THE CLUE MESSAGE FOR DISPLAY

    public String getSnippetMessage (Marker marker, Resources res, String messageType) {
        String message;

        String title = marker.getTitle();
        String type = FindEntityInfo.findType(title);

        switch (type) {
            case "object":
                message = getObjMessage(title, res, messageType);
                break;
            case "npc":
                message = getNpcMessage(title, res, messageType);
                break;
            default:
                message = "";
                break;
        }

        return message;
    }

    //RETRIEVE OBJECT MESSAGE FROM XML
    public String getObjMessage (String title, Resources res, String messageType) {
        String message;

        switch (messageType) {
            case "greeting":
                message = res.getString(R.string.objectGreeting);
                break;
            case "main":
                String[] clueArray = res.getStringArray(R.array.objects_clues);
                int id = FindEntityInfo.findID(title);
                message = clueArray[id];
                break;
            case "back":
                message = res.getString(R.string.objectBack);
                break;
            default:
                message = "";
                break;
        }

        return message;
    }

    //RETRIEVE NPC MESSAGE FROM XML
    public String getNpcMessage (String title, Resources res, String messageType) {
        String message;

        switch (messageType) {
            case "greeting":
                message = res.getString(R.string.npcGreeting);
                break;
            case "main":
                String[] clueArray = res.getStringArray(R.array.npcs_clues);
                int id = FindEntityInfo.findID(title);
                message = clueArray[id];
                break;
            case "back":
                message = res.getString(R.string.npcBack);
                break;
            default:
                message = "";
                break;
        }

        return message;
    }

}
