import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/**
 * Course is an abstract class that represents different kinds of courses
 * @author thiley
 */
public abstract class Course implements Comparable<Course>{
	// fields
	private String crn;
	private String title;
	private Set<String> levels;
	
	// getters
	public final String getCrn() {
		return crn;
	}
	public final String getTitle() {
		return title;
	}
	public final Collection<String> getLevels() {
		return levels;
	}
	public abstract String getType();
	
	/**
	 * Constructor for the Course class 
	 * Initializes the private fields
	 * Checks if crn, title, and level are valid
	 * @param crn represents the Course Reference Number of the course
	 * @param title represents the title of the course
	 * @param levels represents the level of the course
	 * @throws LectureCourseException
	 */
	public Course(String crn, String title, Set<String> levels) throws LectureCourseException{
		if (crn == null) {
			throw new LectureCourseException("crn");
		}
		else{
			this.crn = crn;
		}

		// check if title is 15-40 characters long
		if (title != null && (title.length() >= 15 && title.length() <= 40)) {
			this.title = title;
		}
		else {
			throw new LectureCourseException("title");
		}
		
		// checks if all strings are valid in levels
		if (levels == null || levels.contains(null) || levels.size() == 0 || levels.size() > 3) {
			throw new LectureCourseException("levels");
		}
		else {
			for (String level : levels) {
				if (!(level.equals("Graduate") || level.equals("Non-Degree") || level.equals("Undergraduate"))) {
					throw new LectureCourseException("levels");
				}
				else {
					this.levels = new HashSet<>(levels);
				}
			}
		}
	}
	
	/**
	 * Overrides the parent method
	 * @return true is the given object is a course with matching CRNs
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Course) {
			Course course = (Course)obj;
			if (this.crn == course.crn) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * @return a string representation of the course
	 */
	@Override
	public String toString() {
		return "type: " + getType() + ", CRN: " + this.crn + ", title: " + this.title + ", levels: " + Arrays.deepToString(levels.toArray());
	}
	
	@Override
	public abstract int compareTo(Course argument);
}
