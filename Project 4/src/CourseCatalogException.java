/**
 * This is an exception that inherits from IllegalStateException
 * @author thiley
 *
 */
public class CourseCatalogException extends IllegalStateException {
	// fields
	private String crn;
	private Course course;
	
	// getters
	public String getCrn() {
		return crn;
	}
	public Course getCourse() {
		return course;
	}
	
	/**
	 * The constructor for this exception
	 * Sets the private field and calls the parent class constructor
	 * @param crn a string that stores the CRN of the duplicate course that was being added
	 * @param course a reference to the duplicate course
	 */
	public CourseCatalogException(String crn, Course course) {
		super("The course's CRN is already in the catalog.");
		this.crn = crn;
		this.course = course;
	}
}
