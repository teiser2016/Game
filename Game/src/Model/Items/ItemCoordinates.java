public abstract class Item implements Serializable{
    protected Integer id;
    protected String name;
    protected String description;
	protected double longtitude;
	protected double latitude;
   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) { 
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public double getLongtitude() {
        return longtitude;
    }
    
    public double getLatitude() {
        return latitude;
    }
    
    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }
    
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
