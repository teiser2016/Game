package com.Game.Game.dataStorage;

import com.Game.Game.modelsDB.NPC;

import java.util.ArrayList;

public class NPCsData {

    private static ArrayList<NPC> npcs = new ArrayList<>();

    public static void setNpcs () {
        //get npcs from database and add them in the npcs arraylist above
        //npcs.add(new NPC());
    }

    public static ArrayList<NPC> getNPCs () {
        return npcs;
    }

    public static NPC getNPC (int pos) {
        return npcs.get(pos);
    }

}
