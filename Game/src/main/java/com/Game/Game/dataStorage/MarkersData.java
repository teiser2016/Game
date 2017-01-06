package com.Game.Game.dataStorage;

import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;

public class MarkersData {

    private static ArrayList<Marker> objMarkers = new ArrayList<>();
    private static ArrayList<Marker> npcMarkers = new ArrayList<>();
    private static ArrayList<Marker> bonusMarkers = new ArrayList<>();

    public static void setMarker(Marker marker, String type) {

        switch (type) {
            case "object":
                objMarkers.add(marker);
                break;
            case "npc":
                npcMarkers.add(marker);
                break;
            case "bonus":
                bonusMarkers.add(marker);
                break;
            default:
                break;
        }
    }

    public static void setMarkers (ArrayList<Marker> markers, String type) {

        switch (type) {
            case "object":
                objMarkers = markers;
                break;
            case "npc":
                npcMarkers = markers;
                break;
            case "bonus":
                bonusMarkers = markers;
                break;
            default:
                break;
        }
    }

    public static ArrayList<Marker> getMarkers (String type) {

        switch (type) {
            case "object":
                return objMarkers;
            case "npc":
                return npcMarkers;
            case "bonus":
                return bonusMarkers;
            default:
                return null;
        }
    }

}
