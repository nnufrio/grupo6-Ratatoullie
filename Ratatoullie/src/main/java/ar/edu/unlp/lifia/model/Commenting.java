package ar.edu.unlp.lifia.model;

/**
 * Todos aquellos que implementen esta interface podran ser comentados
 * @author NATA
 *
 */
public interface Commenting {
	/**
	 * Agrega un {@link Comment} en su receptor
	 * @param comment
	 */
	public void comment(Comment comment);
	/**
	 * {@link Location} del recptor del {@link Comment}
	 * @return
	 */
	public Location getLocation();
}