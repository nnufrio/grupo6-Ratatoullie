package ar.edu.unlp.lifia.model;

public class Comment {
	private User user;
	private String text;
	private long date;
	private Commenting commented; 
	private Vote vote;
	public Comment() {
	}
	public Comment(User user, String text, long date, Commenting commented, Vote vote) {
		setCommented(commented);
		setDate(date);
		setText(text);
		setUser(user);
		setVote(vote);
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public Commenting getCommented() {
		return commented;
	}
	public void setCommented(Commenting commented) {
		this.commented = commented;
	}
	public Vote getVote() {
		return vote;
	}
	public void setVote(Vote vote) {
		this.vote = vote;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Ranking getRanking(){
		return getUser().getRanking();
	}
}