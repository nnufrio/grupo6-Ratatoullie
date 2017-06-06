package ar.edu.unlp.lifia.model;

import java.util.ArrayList;
/**
 * Esta {@link Category} pertenece a los {@link Restaurant} que poseen un coeficiente entre -10 y 10 (votos positivos suman y negativos restan)
 * @author NATA
 *
 */
public class Neutral extends Category {

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
		if(value>10){
			restaurant.setCategory(new Popular());
			restaurant.updateCategory();
		}else {
			if (value<-10) {
				restaurant.setCategory(new NotPopular());
				restaurant.updateCategory();
			}
		}
	}
	public Neutral() {
	}
}