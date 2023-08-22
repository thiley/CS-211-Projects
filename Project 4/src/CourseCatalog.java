import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * This class represents the catalog of available courses
 * This class contains a list of courses and provides methods for courses with the CRN it has been registered with
 * This class also returns a subset of items in the catalog given some search terms
 * This class also sorts the courses in the catalog
 * This class includes fields like catalog, which is a list of available courses
 * @author thiley
 *
 */
public class CourseCatalog {
	// fields
	private List<AvailableCourse<String, Course>> catalog;
	
	// getters
	public final List<AvailableCourse<String, Course>> getCatalog() {
		return catalog;
	}
	
	/**
	 * The constructor for the CourseCatalog class that initializes catalog
	 */
	public CourseCatalog() {
		this.catalog = new ArrayList<AvailableCourse<String, Course>>();
	}
	
	/**
	 * The add method is for adding courses to the catalog
	 * This method creates a new AvailableCourse<String, Course> instance
	 * @param crn a string for the CRN number of the course
	 * @param course a course object
	 * @throws CourseCatalogException
	 */
	public void add(String crn, Course course) throws CourseCatalogException {
		AvailableCourse<String, Course> availCourse = new AvailableCourse<String, Course>(crn, course);
		for(AvailableCourse<String, Course> theCourse : catalog) {
			if (theCourse.getKey().compareTo(availCourse.getKey()) == 0) {
				throw new CourseCatalogException(theCourse.getKey(), theCourse.getValue());
			}
		}
		catalog.add(availCourse);
	}
	
	/**
	 * This method creates a new list of available courses
	 * The list contains all available courses from the true catalog items from Searchable's matches method
	 * @param searchable an instance of Searchable
	 * @return the new list of available courses
	 */
	public ArrayList<AvailableCourse<String, Course>> search(Searchable searchable) {
		CourseSearcher courseSearcher = (CourseSearcher)searchable;
		ArrayList<AvailableCourse<String, Course>> newArrList = new ArrayList<AvailableCourse<String, Course>>();
		for(AvailableCourse<String, Course> availCourse : catalog) {
			if (courseSearcher.matches(availCourse)) {
				newArrList.add(availCourse);
			}
		}
		return newArrList;
	}
	
	/**
	 * Sorts the courses in the catalog according to the compareTo() method
	 */
	public void sort() {
		Collections.sort(catalog);
	}
}
