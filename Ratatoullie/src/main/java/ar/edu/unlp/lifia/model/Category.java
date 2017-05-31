package ar.edu.unlp.lifia.model;
/**
 * Categoria de un {@link Restaurant}
 * @author NATA
 *
 */
public abstract class Category {
	private String name;
	
	
	public Category(String name) {
		setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}