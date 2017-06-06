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
	/**
	 * Lista todos los {@link Comment} de un {@link Restaurant} incluyendo los de sus {@link Menu}
	 * @return
	 */
	public List<Comment> getAllComments(){
		ArrayList<Comment> comments= (ArrayList<Comment>) getComments();
		for (Menu menu:getMenus()) {
			comments.addAll(menu.getComments());
		}
		return comments;
	}
	/**
	 * Actualiza la {@link Category} del {@link Restaurant}
	 */
	public void updateCategory() {
		getCategory().update(this);
		
	}
	/**
	 * Lista todos los {@link Comment} de un {@link Restaurant} incluyendo los de sus {@link Menu} en un rango de fechas
	 * @return
	 */
	public List<Comment> getAllComments(long initialDate,long finalDate){
		ArrayList<Comment> comments= new ArrayList<Comment>();
		for (Comment comment : getAllComments()) {
			if(comment.getDate()>=initialDate && comment.getDate()<=finalDate){
				comments.add(comment);
			}
		}
		return comments;
	}
	
}