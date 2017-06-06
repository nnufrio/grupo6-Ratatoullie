package ar.edu.unlp.lifia.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
	private String name;
	private Location location;
	private List<Comment> myComments;
	private Ranking ranking;
	private Set<User> followings;
	private Set<User> followers;
	private List<Recommendation> recommendations;
	public User() {
	}
	public User(String name, Location location){
		setFollowers(new HashSet<User>());
		setFollowings(new HashSet<User>());
		setLocation(location);
		setMyComments(new ArrayList<Comment>());
		setName(name);
		setRanking(new Visitor());
		setRecommendations(new ArrayList<Recommendation>());		
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}	
	public List<Comment> getMyComments() {
		return myComments;
	}
	public void setMyComments(List<Comment> myComments) {
		this.myComments = myComments;
	}
	public int myCommentsSize(){
		return getMyComments().size();
	}
	public Ranking getRanking() {
		return ranking;
	}
	public void setRanking(Ranking ranking) {
		this.ranking = ranking;
	}
	public void updateRating() {
		getRanking().update(this);
	}
	public void comment(Comment comment){
		if(!getMyComments().contains(comment)){
			comment.getCommented().comment(comment);
			getMyComments().add(comment);
			updateRating();
		}		
	}
	/**
	 * {@link User} seguidos
	 * @return
	 */
	public Set<User> getFollowings() {
		return followings;
	}
	public void setFollowings(Set<User> followings) {
		this.followings = followings;
	}
	/**
	 * {@link User} que me siguen
	 * @return
	 */
	public Set<User> getFollowers() {
		return followers;
	}
	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}
	/**
	 * Seguir a un {@link User}
	 * @param user
	 */
	public void follow(User user){
		if(!getFollowings().contains(user)){
			getFollowings().add(user);
			user.followMe(this);
		}
	}
	/**
	 * Me sigue un {@link User}
	 * @param user
	 */
	private void followMe(User user) {
		if(!getFollowers().contains(user)){
			getFollowers().add(user);
		}		
	}
	/**
	 * Dejar de seguir a un {@link User}
	 * @param user
	 */
	public void stopFollowing(User user){
		if(getFollowings().contains(user)){
			getFollowings().remove(user);
			user.stopFollowMe(this);
		}		
	}
	/**
	 * Me deja de seguir un{@link User}
	 * @param user
	 */
	private void stopFollowMe(User user) {
		getFollowers().remove(user);
	}
	/**
	 * Recomienda un {@link Menu} a un {@link User}
	 * @param menu
	 * @param user
	 * @param text
	 * @param date
	 */
	public void recommend(Menu menu, User user, String text, long date){
		Recommendation recommendation = new Recommendation(this,user,menu,date,text);
		sendRecommend(recommendation);
	}
	/**
	 * Envia una {@link Recommendation}
	 * @param recommendation
	 */
	private void sendRecommend(Recommendation recommendation) {
		recommendation.getRecommended().addRecommendation(recommendation);
	}
	private void addRecommendation(Recommendation recommendation) {
		if(!getRecommendations().contains(recommendation)){
			getRecommendations().add(recommendation);
		}				
	}
	public List<Recommendation> getRecommendations() {
		return recommendations;
	}
	public void setRecommendations(List<Recommendation> recommendations) {
		this.recommendations = recommendations;
	}
	@Override
	public boolean equals(Object obj) {
		return this.getName().compareTo(((User)obj).getName())==0;
	}
	@Override
	public int hashCode() {
		return getName().hashCode();
	}
}