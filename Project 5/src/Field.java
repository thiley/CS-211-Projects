import java.util.Iterator;
/**
 * A generic class that represents a field
 * @author thiley
 *
 * @param <T> a generic type
 */
public class Field<T> implements FlexibleIterable<T>{
	// fields
	private T[][] matrix;
	private int height;
	private int width;
	
	/**
	 * A constructor for the field class which allocates memory for the matrix
	 * @param height
	 * @param width
	 */
	public Field(int height, int width) {
		this.height = height;
		this.width = width;
		matrix = (T[][]) new Object[height][width];
	}
	
	public T getElement(int row, int col) {
		return matrix[row][col];
	}
	
	public void setElement(int row, int col, T el) {
		matrix[row][col] = el;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getWidth() {
		return width;
	}
	
	/**
	 * A method which returns a string representation of the elements in the matrix
	 */
	public String toString() {
		String result = "";
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				result += matrix[i][j] + " ";
			}
			result += "\n";
		}
		return result;
	}
	
	/**
	 * This is the default iterator and implements an anonymous inner class
	 * The inner class implements hasNext, next, and remove 
	 * hasNext() checks to see if there is a next element in the matrix
	 * next() returns the current element and moves the cursor to the next element
	 * remove() throws an UnsupportedOperationException exception
	 */
	public Iterator<T> iterator(){
		Iterator<T> iterator = new Iterator<T>() {
			private int currRow = 0;
			private int currCol = 0;
			@Override
			public boolean hasNext() {
				return (currRow < getHeight()) && (currCol < getWidth());
			}
			
			@Override
			public T next() {
				T elem = matrix[currRow][currCol];
				if (currCol++ >= width - 1) {
					currCol = 0;
					currRow++;
				}
				return elem;
			}
			
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}
		};
		return iterator;
	}
	
	/**
	 * This is the overloaded iterator method that returns a FieldIterator object
	 */
	public Iterator<T> iterator(String iterableObjectName){
		return new FieldIterator<T>(iterableObjectName, this);
	}
}
