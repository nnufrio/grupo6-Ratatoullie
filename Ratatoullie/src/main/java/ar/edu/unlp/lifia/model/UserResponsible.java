package ar.edu.unlp.lifia.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Usuario responsable de restaurantes
 * @author NATA
 *
 */
public class UserResponsible extends User {
	private List<Restaurant> restaurants;
	private List<Comment> commentsRestaurant;
	private Set<Ranking> blockedRanking; 
	public UserResponsible() {
	}
	public UserResponsible(String name, Location location) {
		super(name,location);
		setBlockedRanking(new HashSet<Ranking>());
		setCommentsRestaurant(new ArrayList<Comment>());
		setRestaurants(new ArrayList<Restaurant>());		
	}
	/**
	 * Agrega un {@link Restaurant} al sistema y
	 * establece a la intancia actual de {@link UserResponsible} como su propietario
	 * @param name no debe existir otro {@link Restaurant} con el mismo nombre en el sistema 
	 * @param openigDate
	 * @param location
	 * @return si fue posible agregar el {@link Restaurant}
	 */
	public boolean addRestaurant(String name, long openigDate, Location location){
		Ratatoullie ratatoullie = Ratatoullie.getInstance();
		if(ratatoullie.getRestaurant(name)==null){
			Restaurant restaurant = new Restaurant(name, openigDate, location,this);
			getRestaurants().add(restaurant);
			ratatoullie.addRestaurant(restaurant);
		}
				
		return false;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	public void removeRestaurant(Restaurant restaurant){
		getRestaurants().remove(restaurant);
	}	
	public List<Comment> getCommentsRestaurant() {
		return commentsRestaurant;
	}
	public void setCommentsRestaurant(List<Comment> commentsRestaurant) {
		this.commentsRestaurant = commentsRestaurant;
	}
	/**
	 * Realiza el {@link Comment} de un {@link UserResponsible}
	 */
	public void comment(Comment comment){
		//TODO REALIZAR COMENTARIOS
		Location locationComment=comment.getCommented().getLocation();		
		ArrayList<Location> locations= myRestauratsLocations();
		if(!locations.contains(locationComment)){
			Set<Restaurant> restaurantsNearest= Ratatoullie.getInstance().search(locations, 1);
			for (Restaurant restaurant : restaurantsNearest) {
				if(restaurant.getLocation().equals(locationComment)){
					return;
				}
			}
		}
		comment.getCommented().comment(comment);
		updateRating();		
	}
	/**
	 * Lista todas las {@link Location} de mis {@link Restaurant}
	 * @return
	 */
	private ArrayList<Location> myRestauratsLocations() {
		ArrayList<Location> locations =new ArrayList<Location>();
		for (Restaurant restaurant : getRestaurants()) {
			locations.add(restaurant.getLocation());
		}
		return locations;
	}
	/**
	 * Notifica el comentario de un {@link Restaurant} del cual es propietario, 
	 * siempre q el {@link Ranking} de quien comento no este blokeado (getBlockedRanking())
	 * @param comment
	 */
	public void notify(Comment comment){
		if(!getBlockedRanking().contains(comment.getRanking())){
			getCommentsRestaurant().add(comment);
		}		
	}
	/**
	 * {@link Ranking} bloqueados para la reccepcion de notificaciones de {@link Comment}
	 * @return
	 */
	public Set<Ranking> getBlockedRanking() {
		return blockedRanking;
	}
	public void setBlockedRanking(Set<Ranking> blockedRanking) {
		this.blockedRanking = blockedRanking;
	}
	/**
	 * Agraga un {@link Ranking} para que sea blodeado en la recepcion de mensajes
	 * @param ranking
	 */
	public void addBlockedRanking(Ranking ranking){
		getBlockedRanking().add(ranking);
	}
}