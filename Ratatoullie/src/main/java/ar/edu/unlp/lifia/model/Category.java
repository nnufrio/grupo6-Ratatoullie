package ar.edu.unlp.lifia.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Categoria de un {@link Restaurant}
 * @author NATA
 *
 */
public abstract class Category {
	private List<Benefice> benefices= new ArrayList<Benefice>();
	/**
	 * Actualiza la {@link Category} de un {@link Restaurant} segun un determinado criterio
	 * @param restaurant
	 */
	public abstract void update(Restaurant restaurant);
	public List<Benefice> getBenefices() {
		return benefices;
	}
	public void setBenefices(List<Benefice> benefices) {
		this.benefices = benefices;
	}
	public void addBenefice(Benefice benefice){
		getBenefices().add(benefice);
	}
}