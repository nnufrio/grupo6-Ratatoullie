package ar.edu.unlp.lifia.model;
/**
 * Ubicacion en un mapa
 * @author NATA
 *
 */
public class Location {
	private String latitude;
	private String longitude;
	public Location() {	
	}
	public Location(String latitude,String longitude) {
		setLatitude(latitude);
		setLongitude(longitude);
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * Calcula la distancia en metros a la {@link Location} pasada como paramtro
	 * @param location
	 * @return
	 */
	public int Distance(Location location){
		//TODO implementar 
		return 0;
		
	}
}