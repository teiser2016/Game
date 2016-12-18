package com.Game.Game.dataStorage;

import java.util.ArrayList;

public class CountersData {

    private static ArrayList<Integer> objCounters = new ArrayList<>();
    private static ArrayList<Integer> npcCounters = new ArrayList<>();
    private static ArrayList<Integer> bonusCounters = new ArrayList<>();

    public static void setCounters() {
        for (int i = 0; i < 5; i++) {
            objCounters.add(0);
        }
        for (int i = 0; i < 5; i++) {
            npcCounters.add(0);
        }
        for (int i = 0; i < 5; i++) {
            bonusCounters.add(0);
        }
    }

    public static ArrayList<Integer> getCounters(String type) {

        switch (type) {
            case "object":
                return objCounters;
            case "npc":
                return npcCounters;
            case "bonus":
                return bonusCounters;
            default:
                return null;
        }
    }

    public static void setCounter(String type, int pos, int value) {

        switch (type) {
            case "object":
                objCounters.set(pos, value);
                break;
            case "npc":
                npcCounters.set(pos, value);
                break;
            case "bonus":
                bonusCounters.set(pos, value);
                break;
            default:
                break;
        }
    }

    public static int getCounter(String type, int pos) {

        switch (type) {
            case "object":
                return objCounters.get(pos);
            case "npc":
                return npcCounters.get(pos);
            case "bonus":
                return bonusCounters.get(pos);
            default:
                return -1;
        }
    }

    public static void incrementCounter(String type, int pos) {
        int count;

        switch (type) {
            case "object":
                count = objCounters.get(pos);
                count++;
                objCounters.set(pos, count);
                break;
            case "npc":
                count = npcCounters.get(pos);
                count++;
                npcCounters.set(pos, count);
                break;
            case "bonus":
                count = bonusCounters.get(pos);
                count++;
                bonusCounters.set(pos, count);
                break;
            default:
                break;
        }
    }

    public static void decrementObjCounter(String type, int pos) {
        int count;

        switch (type) {
            case "object":
                count = objCounters.get(pos);
                count--;
                objCounters.set(pos, count);
                break;
            case "npc":
                count = npcCounters.get(pos);
                count--;
                npcCounters.set(pos, count);
                break;
            case "bonus":
                count = bonusCounters.get(pos);
                count--;
                bonusCounters.set(pos, count);
                break;
            default:
                break;
        }
    }
}
