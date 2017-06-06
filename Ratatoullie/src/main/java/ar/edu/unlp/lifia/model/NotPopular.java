package ar.edu.unlp.lifia.model;

import java.util.ArrayList;

/**
 * Esta {@link Category} pertenece a los {@link Restaurant} que poseen un coeficiente de -10 (votos positivos suman y negativos restan)
 * @author NATA
 *
 */
public class NotPopular extends Category {
	@Override
	public void update(Restaurant restaurant) {
		int value=0;
		ArrayList<Comment> comments= (ArrayList<Comment>) restaurant.getAllComments();
		for (Comment comment : comments) {
			switch (comment.getVote()) {
			case NEGATIVE: value--;
				break;
			case POSITIVE:value++;				
				break;
			default:
				break;
			}
		}
		if(value>=-10){
			restaurant.setCategory(new Neutral());
			restaurant.updateCategory();
		}
	}
	public NotPopular() {
		addBenefice(Benefice.TYPOGRAPHY);
	}
}