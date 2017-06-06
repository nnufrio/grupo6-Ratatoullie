package ar.edu.unlp.lifia.model;
/**
 * {@link Ranking} Commensal
 * @author NATA
 *
 */
public class Commensal extends Ranking {
	public static final String name= "COMMENSAL";
	@Override
	public void update(User user) {
		int size=user.myCommentsSize();
		if(size<20){
			user.setRanking(new Visitor());
			user.updateRating();
		}else{
			if (size>40) {
				user.setRanking(new Gourmet());
				user.updateRating();
			}			
		}
		
	}
	@Override
	public String getName(){
		return name;
	}
}