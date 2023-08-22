import java.util.Collection;
import java.util.Set;
/**
 * This is a concrete class that inherits from LectureCourse
 * This class represents a hybrid course
 * @author thiley
 *
 */
public class HybridCourse extends LectureCourse{
	/**
	 * This is an override constructor that also calls the parent class constructor
	 * @param crn represents the Course Reference Number of the course
	 * @param title represents the title of the course
	 * @param levels represents the level of the course
	 * @param instructor represents the name of the instructor
	 * @param credit represents the number of credits associated with the course
	 * @param meetDays represents the days the course meets
	 * @param gtas represents the names of the GTAs associated with the course
	 * @throws LectureCourseException
	 */
	public HybridCourse(String crn, String title, Set<String> levels, String instructor, int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException{
		super(crn, title, levels, instructor, credit, meetDays, gtas);
	}
	/**
	 * getType() is an override method that returns the type of a hybrid course
	 */
	@Override
	public String getType() {
		return "Hybrid";
	}
}
