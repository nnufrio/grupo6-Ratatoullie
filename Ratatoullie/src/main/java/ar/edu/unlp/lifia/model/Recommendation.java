package ar.edu.unlp.lifia.model;
/**
 * Recomendacion de un {@link Menu}
 * @author NATA
 *
 */
public class Recommendation {
	private User adviser;
	private User recommended;
	private Menu menu;
	private long date;
	private String text;
	public Recommendation() {

	}
	public Recommendation(User adviser, User recommended, Menu menu, long date, String text) {
		setAdviser(adviser);
		setDate(date);
		setMenu(menu);
		setRecommended(recommended);
		setText(text);
	}
	public User getAdviser() {
		return adviser;
	}
	public void setAdviser(User adviser) {
		this.adviser = adviser;
	}
	public User getRecommended() {
		return recommended;
	}
	public void setRecommended(User recommended) {
		this.recommended = recommended;
	}
	public Menu getMenu() {
		return menu;
	}
	public void setMenu(Menu menu) {
		this.menu = menu;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}