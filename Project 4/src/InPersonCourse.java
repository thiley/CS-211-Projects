import java.util.Collection;
import java.util.Set;
/**
 * This is a concrete class that inherits from LectureCourse
 * This class represents an in-person course
 * @author thiley
 *
 */
public class InPersonCourse extends LectureCourse{
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
	public InPersonCourse(String crn, String title, Set<String> levels, String instructor, int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException{
		super(crn, title, levels, instructor, credit, meetDays, gtas);
	}
	/**
	 * getType() is an override method that returns the type of an in-person course
	 */
	@Override
	public String getType() {
		return "In-Person";
	}
	
}
