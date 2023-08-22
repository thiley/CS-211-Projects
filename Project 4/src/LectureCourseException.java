/**
 * This is an exception that inherits from Exception
 * @author thiley
 *
 */
public class LectureCourseException extends Exception {
	// fields
	private String fieldName;
	
	// getter
	public String getFieldName(){
		return fieldName;
	}
	
	/**
	 * The constructor for this exception
	 * Sets the private field and calls the parent class constructor
	 * @param fieldName a string that stores the name of the null or illegal argument
	 */
	public LectureCourseException(String fieldName) {
		super("an argument has null or illegal value");
		this.fieldName = fieldName;
	}
}
