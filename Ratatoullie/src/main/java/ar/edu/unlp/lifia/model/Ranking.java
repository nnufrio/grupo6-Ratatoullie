package ar.edu.unlp.lifia.model;

public abstract class Ranking {
	public abstract void update(User user);
	
	@Override
	public boolean equals(Object obj) {		
		return obj.getClass().equals(getClass());
	}
	public abstract String getName();
}