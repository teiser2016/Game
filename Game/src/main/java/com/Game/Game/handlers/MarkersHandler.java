package com.Game.Game.handlers;

import android.content.res.Resources;

import com.Game.Game.FindEntityInfo;
import com.Game.Game.MainActivity;
import com.Game.Game.R;
import com.Game.Game.modelsDB.NPC;
import com.Game.Game.modelsDB.Object;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MarkersHandler extends MainActivity {

    public Marker setUserOnMap(GoogleMap map, LatLng location){

        Marker marker = map.addMarker(new MarkerOptions()
                .position(location)
                .title("user")
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
        );

        return marker;
    }

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
