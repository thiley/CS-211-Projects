/**
 * This class is an interface with the method matches
 * @author thiley
 *
 */
public interface Searchable {
	/**
	 * This method will be called by the course catalog when searching
	 * @param availableCourse represents an object of AvailableCourse
	 * @return items that are true will be included, items that are false will no be included
	 */
	public boolean matches(AvailableCourse<String, Course> availableCourse);
}
