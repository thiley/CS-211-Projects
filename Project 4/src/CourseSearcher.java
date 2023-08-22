import java.util.Collection;
/**
 * This is a concrete class that implements the Searchable interface
 * This class represents a search with multiple terms
 * Includes a field called searchTerms that is a collection of strings to search for in each available course 
 * @author thiley
 *
 */
public class CourseSearcher implements Searchable{
	// fields
	private Collection<String> searchTerms;
	
	/**
	 * The constructor for the CourseSearcher class
	 * Takes a collection of strings and sets searchTerms
	 * @param searchTerms
	 */
	public CourseSearcher(Collection<String> searchTerms) {
		this.searchTerms = searchTerms;
	}
	
	/**
	 * @return true if the available course contains any of the search terms
	 */
	public boolean matches(AvailableCourse<String, Course> availCourse) {
		 String courseToSearch = availCourse.getValue().toString();
		 for (String searchTerms : searchTerms) {
			 if (courseToSearch.contains(searchTerms)) {
				 return true;
			 }
		 }
		 return false;
	}
}
