package com.Game.Game.functions;

import com.Game.Game.modelsDB.NPC;
import com.Game.Game.modelsDB.Object;

import java.util.ArrayList;

public class FindEntityInfo {

    public static int findID (String title) {
        ArrayList<Object> objs = new ArrayList<>(); //have to retrieve the objects in this arraylist
        ArrayList<NPC> npcs = new ArrayList<>(); //have to retrieve the npcs in this arraylist

        int id = -1;

        for (int i =0; i<5; i++) {

            if ( title.equals(objs.get(i).getObjName()) ) {
                id = objs.get(i).getObjId();
            }
            if ( title.equals(npcs.get(i).getNPCName()) ) {
                id = npcs.get(i).getNPCId();
            }
        }

        return id;
    }

    public static String findType (String title) {
        ArrayList<Object> objs = new ArrayList<>(); //have to retrieve the objects in this arraylist
        ArrayList<NPC> npcs = new ArrayList<>(); //have to retrieve the npcs in this arraylist

        for (int i =0; i<5; i++) {

            if ( title.equals(objs.get(i).getObjName()) ) {
                return "object";
            }
            if ( title.equals(npcs.get(i).getNPCName()) ) {
                return "npc";
            }
        }
        return null;
    }

}
