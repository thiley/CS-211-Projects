import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * A generic class that provides an iterator for the Field
 * This class implements the Iterator interface
 * @author thiley
 *
 * @param <T> a generic type
 */
public class FieldIterator<T> implements Iterator<T> {
	private Field<T> field;
	private String iterableObjectName;
	private int currRow = 0;
	private int currCol = 0;
	
	/**
	 * A constructor for the FieldIterator class that is used by Field to create a new FieldIterator object
	 * @param iterableObjectName
	 * @param field
	 */
	public FieldIterator(String iterableObjectName, Field<T> field) {
		this.iterableObjectName = iterableObjectName;
		this.field = field;
	}

	/**
	 * This method returns the next element in the iteration
	 * This method throws the NoSuchElementException exception if the iteration is over but the method is invoked
	 */
	@Override
	public T next() {
		T elem = field.getElement(currRow, currCol);
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		else if (currCol++ >= field.getWidth() - 1) {
			currCol = 0;
			currRow++;
		}
		return elem;
	}
	
	/**
	 * Returns true or false depending on whether of not there exists more element on the Field to iterate on 
	 */
	@Override
	public boolean hasNext() {
		for(int i = currRow; i < field.getHeight(); i++) {
			for(int j = currCol; j < field.getWidth(); j++) {
				if (field.getElement(i, j).getClass().getName().equals(iterableObjectName) ) {
					currRow = i;
					currCol = j;
					return true;
				}
			}
			currCol = 0;
		}
		return false;
	}
	
	@Override 
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
