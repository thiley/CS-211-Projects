
public class VIPClient extends Client implements Prioritizable{
//	private Client client = new Client();
//	private Queue queue = new Queue();
	
	// fields
	private int memberSince;
	private int priority;
	
	// getters and setters
	public int getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(int memberSince) {
		this.memberSince = memberSince;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	// constructor
	public VIPClient(String firstName, String lastName, int birthYear, String gender, int arrivalTime, int patience, Request[] requests, int memberSince, int priority) {
		super(firstName, lastName, birthYear, gender, arrivalTime, patience, requests);
		this.memberSince = memberSince;
		this.priority = priority;
	}
	
	// other methods
	public String toString() {
		return (super.toString() + "\n" +
				"** VIP since       :" + memberSince + "\n" +
				"** Priority        :" + priority + "\n");
	}
}
