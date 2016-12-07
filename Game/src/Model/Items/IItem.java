package Model.Items;

import Model.Map.CurrentLocation;

public interface IItem {
	public String getItemName();
        public String getItemDescription();
        public void setItemDescription(String desrc);
	public void setItemName(String name);
        public void itemAction (CurrentLocation currentLocation, String word);

}
