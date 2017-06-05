package ar.edu.unlp.lifia.model;

import java.util.List;

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
	
	public List<Restaurant> search(Location location) {
		return null;
	}
	public List<Restaurant> search(Vote vote, int quantity) {
		return null;
	}
	public List<Restaurant> search(Recommendation recommendation) {
		return null;
	}
	public List<User> topComments(long initialDate,long finalDate){
		return null;
	}
	public List<User> topUsersComments(){
		return null;
	}
	public List<User> quantityUsers(Ranking ranking){
		return null;
	}
	public List<Restaurant> nearest(Location location){
		return null;
	}
	
	
}
