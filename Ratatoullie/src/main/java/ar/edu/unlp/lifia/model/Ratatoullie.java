package ar.edu.unlp.lifia.model;

import java.util.List;
import java.util.Map;

public class Ratatoullie {
	private static final Ratatoullie ratatoullie= new Ratatoullie();
		
	private Ratatoullie() {
	}	
	private static Ratatoullie getRatatoullie() {
		return ratatoullie;
	}
	public Ratatoullie getInstance(){		
		return getRatatoullie();
	}

//	+ search(Location)
//	+ search(Vote,quantity)
//	+ search(Recommendation)
//	+ topComments(initialDate,finalDate)
//	+topUsersComments()
//	+quantityUsers(Raking)
//	+nearest(Location)
//	+benefit(Restaurant)
	/**
	 * Lista {@link Restaurant} a determinada distancia de una localizacion
	 * @param location
	 * @return
	 */
	public List<Restaurant> search(Location location, double distance) {
		return null;
	}
	/**
	 * igual al anterior????
	 * @param location
	 * @return
	 */
	public List<Restaurant> nearest(Location location){
		return null;
	}
	
	/**
	 * Lista los restaurane con una derteminada cantidad de {@link Vote}
	 * @param vote
	 * @param quantity
	 * @return
	 */
	public List<Restaurant> search(Vote vote, int quantity) {
		return null;
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
	 * Listar los restaurants que tuvieron más comentarios en un determinado rango de fechas
	 * @param initialDate
	 * @param finalDate
	 * @return
	 */
	public List<Restaurant> topComments(long initialDate,long finalDate){
		return null;
	}
	/**
	 * Usuarios q tienen as comentarios
	 * @return
	 */
	public List<User> topUsersComments(int quantity){
		return null;
	}
	public Map<Ranking, Integer> quantityUsers(){
		return null;
	}
	
	
	
}
