package ar.edu.unlp.lifia.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ratatoullie {
	private static final Ratatoullie ratatoullie= new Ratatoullie();
	private List<User> users;
	private List<Restaurant> restaurants;
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	public List<Restaurant> getRestaurants() {
		return restaurants;
	}
	public void setRestaurants(List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}
	private Ratatoullie() {
	}	
	private static Ratatoullie getRatatoullie() {
		return ratatoullie;
	}
	public Ratatoullie getInstance(){		
		return getRatatoullie();
	}
	/**
	 * Lista {@link Restaurant} a determinada distancia de una {@link Location}
	 * @param location
	 * @return
	 */
	public List<Restaurant> search(Location location, double distance) {
		ArrayList<Restaurant> restaurants= new ArrayList<Restaurant>();
		for (Restaurant restaurant : getRestaurants()) {
			if(location.getDistance(restaurant.getLocation())<=distance){
				restaurants.add(restaurant);
			}
		}
		return order(restaurants);
	}
	/**
	 * Ordena una lista de {@link Restaurant} de acuerdo al {@link Benefice} TOP
	 * @param restaurants
	 * @return
	 */
	private List<Restaurant> order(ArrayList<Restaurant> restaurants) {
		ArrayList<Restaurant> restaurantsResult = new ArrayList<Restaurant>();
		for (Restaurant restaurant : restaurants) {
			if(restaurant.getBenefices().contains(Benefice.TOP)){
				restaurantsResult.add(restaurant);
			}
		}
		restaurants.removeAll(restaurantsResult);
		restaurantsResult.addAll(restaurants);
		return restaurantsResult;
	}
	/**
	 * Lista los {@link Restaurant} con una cantidad minima de un tipo de {@link Vote}
	 * @param vote
	 * @param quantity
	 * @return
	 */
	public List<Restaurant> search(Vote vote, int quantity) {
		ArrayList<Restaurant> restaurantsResult = new ArrayList<Restaurant>();
		for (Restaurant restaurant : getRestaurants()) {
			int comments=0;
			for (Comment comment : restaurant.getAllComments()) {
				if(comment.getVote().equals(vote)){
					comments++;
				}
			}
			if(comments>=quantity){
				restaurantsResult.add(restaurant);
			}
		}	
		return order(restaurantsResult);
	}
	/**
	 * va?
	 * @param recommendation
	 * @return
	 */
	public List<Restaurant> search(Recommendation recommendation) {
		return null;
	}
	/**
	 * Listar los {@link Restaurant} que tuvieron más comentarios en un determinado rango de fechas
	 * @param initialDate
	 * @param finalDate
	 * @param quantity limita la cantidad de resultados
	 * @return
	 */
	public List<Restaurant> topComments(long initialDate,long finalDate, int quantity){
		ArrayList<Restaurant> restaurantsResult = new ArrayList<Restaurant>();
		restaurantsResult.addAll(getRestaurants());
		Comparator<Restaurant> comparator = new Comparator<Restaurant>(){
		     @Override
		     public int compare(Restaurant restaurant, Restaurant restaurant2)
		     {
		    	 int myCommentsSize= restaurant.getAllComments(initialDate, finalDate).size();
			 		int otherCommentsSize= restaurant2.getAllComments(initialDate, finalDate).size();
			         if (myCommentsSize < otherCommentsSize) {
			             return -1;
			         }
			         if (myCommentsSize > otherCommentsSize) {
			             return 1;
			         }
			         return 0;
		     }             
		};
		restaurantsResult.sort(comparator);
		while (restaurantsResult.size()>quantity) {
			restaurantsResult.remove(restaurantsResult.size()-1);			
		}
		return order(restaurantsResult);
	}
	/**
	 * Lista los {@link User} con mas cantidad de {@link Comment}
	 * @param quantity limita la cantidad de resultados
	 * @return
	 */
	public List<User> topUsersComments(int quantity){
		ArrayList<User> users = new ArrayList<User>();
		for (User user : getUsers()) {
			if(user.getRanking().equals(new Gourmet())){
				users.add(user);
			}
		}
		Comparator<User> comparator = new Comparator<User>(){
		     @Override
		     public int compare(User user, User user2)
		     {
		    	 int myCommentsSize= user.getMyComments().size();
			 		int otherCommentsSize= user2.getMyComments().size();
			         if (myCommentsSize < otherCommentsSize) {
			             return -1;
			         }
			         if (myCommentsSize > otherCommentsSize) {
			             return 1;
			         }
			         return 0;
		     }             
		};
		users.sort(comparator);
		while (users.size()>quantity) {
			users.remove(users.size()-1);			
		}
		return users;
	}
	/**
	 * Cantidad de {@link User} por {@link Ranking}
	 * @return {@link Map} <{@link Ranking}, cantidad de {@link User}>
	 */
	public Map<Ranking, Integer> quantityUsersRank(){
		HashMap<Ranking, Integer> result = new HashMap<Ranking,Integer>();
		int visitor=0,commensal=0,gourmet=0;
		for (User user : getUsers()) {
			switch (user.getRanking().getName()) {
				case Visitor.name:visitor++;				
				break;
				case Commensal.name:commensal++;
				break;
				case Gourmet.name:gourmet++;
				break;
				default:
				break;
			}
		}
		result.put(new Visitor(), visitor);
		result.put(new Commensal(), commensal);
		result.put(new Gourmet(), gourmet);		
		return result;
	}
}