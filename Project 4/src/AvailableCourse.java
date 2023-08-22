/**
 * This is a generic class that represents a mapping between keys and values
 * This class implements Comparable 
 * @author thiley
 *
 * @param <K> represents a key, can be any type
 * @param <V> represents a value, implements the Comparable interface and can be comparable to other instances of the same type
 */
public class AvailableCourse <K, V extends Comparable<V>> implements Comparable<AvailableCourse<K, V>> {
	// fields
	private K key;
	private V value;
	
	// getters
	public final K getKey() {
		return key;
	}
	public final V getValue() {
		return value;
	}
	
	/**
	 * This is the AvailableCourse constructor that sets the private fields
	 * @param key a reference of the first generic type
	 * @param value a reference of the second generic type
	 */
	public AvailableCourse(K key, V value) {
		this.key = key;
		this.value = value;
	}
	
	/**
	 * equals is an override method
	 * @return true is the other object is also an AvailableCourse and has the same value
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof AvailableCourse) {
			AvailableCourse<K, V> availCourse = (AvailableCourse<K, V>)obj;
			if (value.compareTo((availCourse).getValue()) == 0) {
				return true;
			}
		}
		return false;
	}
	/**
	 * compareTo is an override method
	 * @return the result of comparing the value field
	 */
	@Override
	public int compareTo(AvailableCourse<K, V> argument) {
		return value.compareTo(argument.value);
	}
}
