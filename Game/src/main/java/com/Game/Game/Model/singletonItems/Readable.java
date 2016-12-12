package com.Game.Game.Model.singletonItems;

import java.io.Serializable;
import static java.lang.System.out;

public class Readable extends Item implements Serializable{

    private String itemName;
    private String itemDescription;
    
    public Readable(String name, String description){
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
    public void itemAction(CurrentLocation currentLocation, String word) {
        if (currentLocation.getPlayer().getPlayerInventory().containsKey(word)){
            Item item1 = currentLocation.getPlayer().getPlayerInventory().get(word);
            switch (item1.getItemName()) {
                case "post note":
                    Item item3 = currentLocation.getPlayer().getPlayerInventory().get(word);
                    item3.setItemDescription("Its a simple post note. On it is written some strange numbers \"PWD 85879-2937663-9675\"");
                    out.print(" -You unfolded the post note and it shows some drawings. Maybe is' the pattern from her smartphone.\n");
                    break;
                case "usb flash drive":
                    Item item2 = currentLocation.getPlayer().getPlayerInventory().get(word);
                    item2.setItemName("Use usb drive and read txt file");
                    item2.setItemDescription("Its a txt with account transactions. A big ammount of money have moved to an uknown account!\"");
                    out.print(" -You use the usb flash drive to see what's inside!.\n -The txt says!:\n");
                    currentLocation.getPlayer().getPlayerInventory().remove(word);
                    currentLocation.getPlayer().setPlayerInventory(item1);
                    out.print(" -" +item2.getItemDescription());
                    out.print(" -" +item2.getItemName()+ " has been added to your invrntory./n");
                    break;
                default:
                    out.print(" -Its a usb flash drive. Maybe you should use it!...");
                    break;
            }
        }
        
    }*/
    
}
