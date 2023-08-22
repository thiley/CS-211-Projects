import java.util.Iterator;
/**
 * A generic functional interface that contains one method to be overloaded
 * @author thiley
 *
 * @param <T> represents a generic type
 */
public interface FlexibleIterable<T> extends Iterable<T> {
	/**
	 * An iterator that will iterate on objects of the parameter and skip everything else
	 * @param iterableObjectName represents a block that is either a passage or an obstacle
	 */
	public Iterator<T> iterator(String iterableObjectName);
		
}
