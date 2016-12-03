package com.Game.Game.modelsDB;

public class Object {

    private String obj_name;
    private String used;
    private double lat;
    private double lng;
    private String text1;
    private String text2;

    public Object(){
        obj_name = "";
        used = "no";
        lat = 0;
        lng = 0;
        text1 = "";
        text2 = "";
    }

    public Object(String name1, String used1, double lat1, double lng1, String txt1, String txt2){
        obj_name = name1;
        used = used1;
        lat = lat1;
        lng = lng1;
        text1 = txt1;
        text2 = txt2;
    }


    public String getObjName(){
        return obj_name;
    }
    public String getUsed(){
        return used;
    }
    public double getLat(){
        return lat;
    }
    public double getLng(){
        return lng;
    }
    public String getText1(){
        return text1;
    }
    public String getText2(){
        return text2;
    }


    public void setObjName(String name1){
        obj_name = name1;
    }
    public void setUsed(String used1){
        used = used1;
    }
    public void setLat(double lat1){
        lat = lat1;
    }
    public void setLng(double lng1){
        lng = lng1;
    }
    public void setText1(String txt1){
        text1 = txt1;
    }
    public void setText2(String txt2){
        text2 = txt2;
    }

}
