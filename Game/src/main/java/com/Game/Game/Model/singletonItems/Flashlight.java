/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Game.Game.Model.singletonItems;

import java.io.Serializable;
import java.util.Scanner;

import static com.google.android.gms.nearby.Nearby.Messages;

public class Flashlight extends Item implements Serializable{
    private String itemName;
    private String itemDescription;
    private Messages msg = new Messages();
    
    public Flashlight(String name, String description){

        this.itemName = name;
        this.itemDescription = description;
    }

    @Override
    public String getItemName() {
        return itemName;
    }

    @Override
    public String getItemDescription() {
        return itemDescription;
    }

    @Override
    public void setItemDescription(String desrc) {
        this.itemDescription = desrc;
    }

    @Override
    public void setItemName(String name) {
        this.itemName = name;
    }
    
    @Override
    public void itemAction (CurrentLocation currentLocation, String word){
        
        System.out.printf(" -Do you want to use Flashlight: ");
        Scanner cn = new Scanner(System.in);
        String itemName = cn.nextLine();
        Item item2 = currentLocation.getPlayer().getPlayerInventory().get(itemName);
    }
}



