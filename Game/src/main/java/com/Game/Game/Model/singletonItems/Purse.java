package com.Game.Game.Model.singletonItems;

import java.io.Serializable;
import static java.lang.System.out;


public class Purse extends Item implements Serializable{
    private String itemName;
    private String itemDescription;
    
    public Purse(String name, String description){
        this.itemName = name;
        this.itemDescription = description;
    }

    /*@Override
    public String getItemName(){
        return itemName; 
    }

    @Override
    public String getItemDescription(){
        return itemDescription;
    }

    @Override
    public void setItemDescription(String desrc){
        this.itemDescription = desrc;
    }

    @Override
    public void setItemName(String name){
        this.itemName = name;
    }
    
    @Override
    public void itemAction (CurrentLocation currentLocation, String word){
        
        if (currentLocation.getPlayer().getPlayerInventory().containsKey(word)){
            switch (word) {
                case "purse":
                    Item item1 = new Readable("There's a smartphone inside. Maybe you can use it!");
                    Item item2 = new Readable("Note. It's just a note");
                    Item item3 = new Key ("Usb flash drive.It's a black usb flash drive");
                    out.print(" -You opened the Purse. Inside it you can find a smartphone, usb flash drive and a lipstick.\n");
                    currentLocation.getCurrentLocation().setItemToLocation(item1);
                    currentLocation.getCurrentLocation().setItemToLocation(item2);
                    currentLocation.getCurrentLocation().setItemToLocation(item3);
                    currentLocation.getPlayer().getPlayerInventory().remove(word);
                    out.print(" -Purse has been removed from your inventory.\n");
                    out.print(" -" + item1.getItemName() + ", " +item2.getItemName() + " and " +item3.getItemName() + " are now on the table.\n");
                    break;
                case "Purse":
                    if (currentLocation.getPlayer().getPlayerInventory().containsKey("post note") 
                            && currentLocation.getPlayer().getPlayerInventory().get("post note").getItemDescription().contains("\"PWD")){

                        Item item4 = new Readable ("note","Its a shreded piece of paper, but maybe you can read it.");
                        Item item5 = new Key ("It's a usb flashdrive. Maybe you can use it!");
                        out.print(" -You used the password on the post note you found to unlock the smartphone pattern. \n"
                                + "You use the usb flash drive and find a txt file. Read it! \n"
                                + "On the bottom of the purse you see a lot of money.\n ");
                        currentLocation.getCurrentLocation().setItemToLocation(item4);
                        currentLocation.getCurrentLocation().setItemToLocation(item5);
                        currentLocation.getPlayer().getPlayerInventory().remove(word);
                        out.print("-Purse has been removed from your inventory.\n");
                        out.print(" -" + item4.getItemName() + " and " +item5.getItemName() + " are now on the table.\n");
                        
                    }
                    else{
                        out.print(" -The smartphone is locked with a pattern. You have to find the combination first!.\n");
                    }   break;
            }
        }
        else{
            out.print(" -This briefcase cannot be opened!\n");
        }
    }*/
}
    
