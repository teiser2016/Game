package Model.Items;

import Model.Map.CurrentLocation;
import java.io.Serializable;
import static java.lang.System.out;


public class Knife implements IItem, Serializable {
    private String itemName;
    private String itemDescription;
    
    public Knife(String name, String description){
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
        if (currentLocation.getCurrentLocation().getLocationName().equals("Basement")){
            out.print("Use this knife to kill the kidnapper\n");
        }
        else{
            out.print("You can't use this item here yet\n");
        }
    }
    
}
    
