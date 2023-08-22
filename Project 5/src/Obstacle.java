/**
 * A class that represents a single cell of the field that is an obstacle
 * @author thiley
 *
 */
public class Obstacle extends Block{
	private String label;
	
	/**
	 * A constructor for the Obstacle class
	 * @param label represents the label of the Obstacle object
	 */
	public Obstacle(String label) {
		this.label = label;
	}
	
	/**
	 * Method that returns the label of the object as a string
	 * @return label
	 */
	public String toString() {
		return label;
	}
	
	/**
	 * Method assigns the object with 0 points because it is impossible to go through an obstacle
	 * @return 0
	 */
	public int getValue() {
		return 0;
	}
}
