package com.Game.Game.dataStorage;

import java.util.ArrayList;

public class ObjectsData {

    private static ArrayList<Object> objects = new ArrayList<>();

    public static void setObjects () {
        //get objects from database and add them in the objects arraylist above
        //objects.add(new Object());
    }

    public static ArrayList<Object> getObjects () {
        return objects;
    }

    public static Object getObject (int pos) { return objects.get(pos); }

}
