/**
 * A class that represents a single cell of the field that is a passage
 * @author thiley
 *
 */
public class Passage extends Block{
	private int value;
	
	/**
	 * A constructor for the Passage class
	 * @param value represents the number of points assigned to the object
	 */
	public Passage(int value) {
		this.value = value;
	}
	
	/**
	 * Method returns the label of the object which is the value number
	 * @return value
	 */
	public String toString() {
		return Integer.toString(value);
	}
	
	/**
	 * Method returns the number of points assigned to the object
	 * @return value
	 */
	public int getValue() {
		return value;
	}
}
