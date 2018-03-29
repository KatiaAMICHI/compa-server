package main.compa;


public class Location {
    private double latitude, longitude;

    public Location(double lat, double lon){
        this.latitude = lat;
        this.longitude = lon;
    }

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
}
