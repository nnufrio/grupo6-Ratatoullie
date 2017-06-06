package ar.edu.unlp.lifia.model;

/**
 * {@link Ranking} Visitor
 * @author NATA
 *
 */
public class Visitor extends Ranking {
	public static final String name= "VISITOR";
	@Override
	public void update(User user) {
		if(user.myCommentsSize()>=20){
			user.setRanking(new Commensal());
			user.updateRating();
		}
	}	
	@Override
	public String getName(){
		return name;
	}
}
