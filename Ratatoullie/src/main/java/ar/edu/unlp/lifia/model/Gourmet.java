package ar.edu.unlp.lifia.model;
/**
 * {@link Ranking} Gourmet
 * @author NATA
 *
 */
public class Gourmet extends Ranking {
	public static final String name= "GOURMET";
	@Override
	public void update(User user) {
		if(user.myCommentsSize()<=40){
			user.setRanking(new Commensal());
			user.updateRating();
		}
	}
	@Override
	public String getName(){
		return name;
	}
}