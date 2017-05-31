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
	public void addRestaurant(Restaurant restaurant){
		if(!getRestaurants().contains(restaurant)){
			getRestaurants().add(restaurant);
		}		
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
	public void comment(Comment comment){
		//TODO REALIZAR COMENTARIOS
//		ArrayList<Location> locations= myRestauratsLocations();
//		nearest(locations);
//		if(!locations.contains(comment.getCommented().getLocation())){
//			comment.getCommented().comment(comment);
//			updateRating();
//		}
	}
	public void notify(Comment comment){
		if(!getBlockedRanking().contains(comment.getRanking())){
			getCommentsRestaurant().add(comment);
		}		
	}
	public Set<Ranking> getBlockedRanking() {
		return blockedRanking;
	}
	public void setBlockedRanking(Set<Ranking> blockedRanking) {
		this.blockedRanking = blockedRanking;
	}
	public void addBlockedRanking(Ranking ranking){
		getBlockedRanking().add(ranking);
	}
}