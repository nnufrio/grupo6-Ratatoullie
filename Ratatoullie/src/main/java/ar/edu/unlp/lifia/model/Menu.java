package ar.edu.unlp.lifia.model;

import java.util.ArrayList;
import java.util.List;

public class Menu implements Commenting{
	private Restaurant restaurant;
	private String text;
	private long startDate;
	private long endDate;
	private List<Comment> comments;
	private List<Recommendation> recommendations;
	public Menu() {
	}
	public Menu(Restaurant restaurant, String text, long startDate) {
		setComments(new ArrayList<Comment>());
		setEndDate(0);
		setRecommendations(new ArrayList<Recommendation>());
		setRestaurant(restaurant);
		setStartDate(startDate);
		setText(text);
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getStartDate() {
		return startDate;
	}
	public void setStartDate(long startDate) {
		this.startDate = startDate;
	}
	public long getEndDate() {
		return endDate;
	}
	public void setEndDate(long endDate) {
		this.endDate = endDate;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	@Override
	public void comment(Comment comment) {
		getComments().add(comment);
	}
	@Override
	public Location getLocation() {
		return getRestaurant().getLocation();
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Recommendation> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}
	public void addRecommendation(Recommendation recommendation){
		getRecommendations().add(recommendation);
	}
}
