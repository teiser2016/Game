package com.Game.Game.modelsDB;

public class Character {

    private int char_id;
    private String char_name;
    private String char_lastname;
    private String profession;
    private int age;

    public Character(){
        char_id = -1;
        char_name = "";
        char_lastname = "";
        profession = "";
        age = -1;
    }

    public Character(int id1, String name1, String lastname1, String profession1, int age1){
        char_id = id1;
        char_name = name1;
        char_lastname = lastname1;
        profession = profession1;
        age = age1;
    }

    public int getCharId() { return char_id; }
    public String getCharName() { return char_name; }
    public String getCharLastname() { return char_lastname; }
    public String getProfession() { return profession; }
    public int getAge() { return age; }

    public void setCharId(int id1) { char_id = id1; }
    public void setCharName(String name1) { char_name = name1; }
    public void setCharLastname(String lastname1) { char_lastname = lastname1; }
    public void setProfession(String profession1) { profession = profession1; }
    public void setAge(int age1) { age = age1; }

}