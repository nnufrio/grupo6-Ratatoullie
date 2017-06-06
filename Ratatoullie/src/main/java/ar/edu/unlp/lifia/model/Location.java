package ar.edu.unlp.lifia.model;
/**
 * Ubicacion en un mapa
 * @author NATA
 *
 */
public class Location {
	private double latitude;
	private double longitude;
	public Location() {	
	}
	public Location(double latitude,double longitude) {
		setLatitude(latitude);
		setLongitude(longitude);
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
	/**
	 * Calcula la distancia en metros a la {@link Location} pasada como paramtro
	 * @param location
	 * @return
	 */
	public double getDistance(Location location){
		 //double radioTierra = 3958.75;//en millas  
        double earthRadio = 6371;//en kilómetros  
        double latitude = Math.toRadians(location.getLatitude() - getLatitude());  
        double longitude = Math.toRadians(location.getLongitude() - getLongitude());  
        double sindLatitude = Math.sin(latitude / 2);  
        double sindLongitude = Math.sin(longitude / 2);  
        double va1 = Math.pow(sindLatitude, 2) + Math.pow(sindLongitude, 2)  
                * Math.cos(Math.toRadians(getLatitude())) * Math.cos(Math.toRadians(location.getLatitude()));  
        double va2 = 2 * Math.atan2(Math.sqrt(va1), Math.sqrt(1 - va1));  
        double distance = earthRadio * va2;  
   
        return distance;  		
		
	}
}