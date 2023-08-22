import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
/**
 * LectureCourse is an abstract subclass of Course
 * This class represents different types of lecture courses
 * @author thiley
 *
 */
public abstract class LectureCourse extends Course{
	// fields
	private String instructor;
	private int credit;
	private Set<MeetDay> meetDays;
	private Collection<String> gtas;
	
	// getters
	public final String getInstructor() {
		return instructor;
	}
	public final int getCredit() {
		return credit;
	}
	public final Collection<MeetDay> getMeetDays() {
		return meetDays;
	}
	public final Collection<String> getGtas() {
		return gtas;
	}
	
	/**
	 * Constructor for LectureCourse sets the private fields
	 * Also calls the parent constructor
	 * @param crn represents the Course Reference Number of the course
	 * @param title represents the title of the course
	 * @param levels represents the level of the course
	 * @param instructor represents the name of the instructor
	 * @param credit represents the number of credits associated with the course
	 * @param meetDays represents the days the course meets
	 * @param gtas represents the names of the GTAs associated with the course
	 * @throws LectureCourseException
	 */
	public LectureCourse(String crn, String title, Set<String> levels, String instructor, int credit, Set<MeetDay> meetDays, Collection<String> gtas) throws LectureCourseException {
		super(crn, title, levels);
		if (instructor == null) {
			throw new LectureCourseException("instructor");
		}
		else {
			this.instructor = instructor;
		}
		if (credit < 0) {
			throw new LectureCourseException("credit");
		}
		else {
			this.credit = credit;
		}
		if (meetDays == null || meetDays.contains(null) || meetDays.size() < 1 || meetDays.size() > 2) {
			throw new LectureCourseException("meetDays");
		}
		else {
			this.meetDays = new HashSet<>(meetDays);
		}
		if (gtas == null || gtas.contains(null) || gtas.size() < 0) {
			throw new LectureCourseException("gtas");
		}
		else {
			this.gtas = new ArrayList<>(gtas);
		}
	}

	/**
	 * Returns a string representation of this object
	 */
	public String toString() {
		return "instructor: " + this.instructor + ", credit: " + this.credit + ", meetDays: " + Arrays.deepToString(meetDays.toArray()) + ", gtas: " + Arrays.deepToString(gtas.toArray())
				+ ", " + super.toString();
	}
	
	/**
	 * This method compares and sorts the courses by these conditions:
	 * Sorts ascending the field catalog according to the following rules 
	 * 1. In son courses come before Hybrid courses and Hybrid courses come before Online courses. 
	 * 2. InPerson courses are sorted first by credit, then by title. 
	 * 3. Hybrid courses are sorted first by title, then by the number of credits. 
	 * 4. Online courses are sorted first by title, then by the number of meetDays.
	 * @param argument represents another course
	 */
	@Override
	public int compareTo(Course argument) {
		if (this.getType() == "In-Person" && argument.getType() == "In-Person") {
			InPersonCourse otherCourse = (InPersonCourse)argument;
			// sort first by credit
			if (this.getCredit() - otherCourse.getCredit() != 0) { 
				return this.credit - otherCourse.getCredit();
			}
			// if credits are the same, sort by titles
			else if (this.getTitle().compareTo(otherCourse.getTitle()) != 0) {
				return this.getTitle().compareTo(otherCourse.getTitle());
			}
		}
		else if (this.getType() == "Hybrid" && argument.getType() == "Hybrid") {
			HybridCourse otherCourse = (HybridCourse)argument;
			// first sort by title
			if (this.getTitle().compareTo(otherCourse.getTitle()) != 0) {
				return this.getTitle().compareTo(otherCourse.getTitle());
			}
			// if titles are the same, sort by number of credits
			else if (this.getCredit() - otherCourse.getCredit() != 0) { 
				return this.credit - otherCourse.getCredit();
			}
		}
		else if (this.getType() == "Online" && argument.getType() == "Online") {
			OnlineCourse otherCourse = (OnlineCourse)argument;
			// first sort by title
			if (this.getTitle().compareTo(otherCourse.getTitle()) != 0) {
				return this.getTitle().compareTo(otherCourse.getTitle());
			}
			// if titles are the same, sort by number of meetDays
			else if (this.meetDays.size() - otherCourse.getMeetDays().size() != 0) { 
				return this.meetDays.size() - otherCourse.getMeetDays().size();
			}
		}
		else if (this.getType() == "In-Person") {
			return -1;
		}
		else if (argument.getType() == "In-Person") {
			return 1;
		}
		else if (this.getType() == "Hybrid" && argument.getType() == "Online") {
			return -1;
		}
		else if (this.getType() == "Online" &&  argument.getType() == "Hybrid") {
			return 1;
		}
		return 0;

	}
	
}
