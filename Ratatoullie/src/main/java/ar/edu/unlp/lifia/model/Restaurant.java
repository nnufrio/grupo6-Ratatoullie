package ar.edu.unlp.lifia.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Restaurant implements Commenting{
	private String name;
	private long openingDate;
	private Location location;
	private Set<Benefice> benefices;
	private Category category;
	private List<Comment> comments; 
	private List<Menu> menus;
	private UserResponsible owner;
	public Restaurant() {
	}
	public Restaurant(String name, long openigDate, Location location, Category category, UserResponsible userResponsible) {
		setBenefices(new HashSet<Benefice>());
		setCategory(category);
		setComments(new ArrayList<Comment>());
		setLocation(location);
		setMenus(new ArrayList<Menu>());
		setName(name);
		setOpeningDate(openigDate);
		setOwner(userResponsible);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getOpeningDate() {
		return openingDate;
	}
	public void setOpeningDate(long openingDate) {
		this.openingDate = openingDate;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public Set<Benefice> getBenefices() {
		return benefices;
	}
	public void setBenefices(Set<Benefice> benefices) {
		this.benefices = benefices;
	}
	public void addBenefice(Benefice benefice){
		getBenefices().add(benefice);
	}
	public void removeBenefice(Benefice benefice){
		getBenefices().remove(benefice);
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	@Override
	public void comment(Comment comment) {
		getComments().add(comment);
		getOwner().notify(comment);
	}
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Menu> getMenus() {
		return menus;
	}
	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}
	public Menu getCourentMenu(){
		return getMenus().get(getMenus().size()-1);
	}
	/**
	 * Agrega un {@link Menu} y lo establece como el actual
	 * @param menu
	 */
	public void addMenu(Menu menu){
		getCourentMenu().setEndDate(new Date().getTime());
		getMenus().add(menu);
	}
	public UserResponsible getOwner() {
		return owner;
	}
	public void setOwner(UserResponsible owner) {
		this.owner = owner;
	}	
}