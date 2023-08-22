
public class Client {
//	private QueueSystem queueSystem = new QueueSystem();
//	private Queue queue = new Queue();
	
	// fields
	private int id = 1;
    private static int uniqueID = 1;
	private String firstName;
	private String lastName;
	private int yearOfBirth;
	private Gender gender;
	private Request[] requests;
	private int arrivalTime;
	private int waitingTime;
	private int timeInQueue;
	private int serviceTime;
	private int departureTime;
	private int patience;
	
	// getters and setters
	public int getId() {
		return id;
	}
	public void setId() {
		id = uniqueID;
        uniqueID += 1;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getYearOfBirth() {
		return yearOfBirth;
	}
	public void setYearOfBirth(int yearOfBirth) {
		this.yearOfBirth = yearOfBirth;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(String gender) {
		if (gender.equals("MALE")) {
			this.gender = Gender.MALE;
		}
		else if (gender.equals("FEMALE")) {
			this.gender = Gender.FEMALE;
		}
	}
	public Request[] getRequests() {
		return requests;
	}
	public void setRequests(Request[] requests) {
		this.requests = requests;
	}
	public int getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(int arrivalTime) {
		if (arrivalTime <= 0) {
			this.arrivalTime = QueueSystem.getClock();
		}
		else {
			this.arrivalTime = arrivalTime;
		}
	}
	public int getWaitingTime() {
		return waitingTime;
	}
	public void setWaitingTime(int waitingTime) {
		if (waitingTime < 0) {
			this.waitingTime = 0;
		}
		else {
			this.waitingTime = waitingTime;
		}
	}
	public int getTimeInQueue() {
		return timeInQueue;
	}
	public void setTimeInQueue(int timeInQueue) {
		if (timeInQueue < 0) {
			this.timeInQueue = 0;
		}
		else {
			this.timeInQueue = timeInQueue;
		}
	}
	public int getServiceTime() {
		return serviceTime;
	}
	public void setServiceTime(int serviceTime) {
		this.serviceTime = serviceTime;
	}
	public int getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(int departureTime) {
		int dt = arrivalTime + waitingTime + timeInQueue;
		if (dt >= patience) {
			this.departureTime = QueueSystem.getClock();
		}
		else {
			this.departureTime = departureTime;
		}
	}
	public int getPatience() {
		return patience;
	}
	public void setPatience(int patience) {
		int age = 2023 - yearOfBirth;
		if (QueueSystem.getTvInWaitingArea() == true) {
			patience += 20;
		}
		if (age >= 18) {
			if (QueueSystem.getCoffeeInWaitingArea() == true) {
				patience += 15;
			}
		}
		this.patience = patience;
	}
	
	// constructors
	public Client(String firstName, String lastName, int yearOfBirth, String gender, int arrivalTime, int patience, Request[] requests) {
		this.setId();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setYearOfBirth(yearOfBirth);
		this.setGender(gender);
		this.setArrivalTime(arrivalTime);
		this.setPatience(patience);
		this.setRequests(requests);
        this.waitingTime = 0;
        this.timeInQueue = 0;
        this.serviceTime = 0;
        this.departureTime = 0;
	}
	public Client(String firstName, String lastName, int yearOfBirth, String gender, int patience, Request[] requests) {
		this.setId();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setYearOfBirth(yearOfBirth);
		this.setGender(gender);
		this.setPatience(patience);
		this.setRequests(requests);
		this.arrivalTime = QueueSystem.getClock();
        this.waitingTime = 0;
        this.timeInQueue = 0;
        this.serviceTime = 0;
        this.departureTime = 0;
	}
	public Client (String firstName, String lastName, int yearOfBirth, String gender, int patience) {
		this.setId();
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setYearOfBirth(yearOfBirth);
		this.setGender(gender);
		this.setPatience(patience);
		this.arrivalTime = QueueSystem.getClock();
        this.waitingTime = 0;
        this.timeInQueue = 0;
        this.serviceTime = 0;
        this.departureTime = 0;
	}
	
	// other methods
	public int serviceTime() {
		int st = 0;
		if (requests != null) {
			for (int i = 0; i < requests.length; i++) {
				st += requests[i].calculateProcessingTime();
			}
		}
		serviceTime = st;
		return st;
	}
	public int estimateServiceLevel() {
		// check if client in system
		int serviceLvl = 10;
		if (departureTime == 0) {
			//serviceLvl = -1;
			if (QueueSystem.getClientsWorld() == null) {
				serviceLvl = -1;
			}
			else {
				for (int i = 0; i < QueueSystem.getClientsWorld().length; i++) {
					if (QueueSystem.getClientsWorld()[i].getId() == id) {
						serviceLvl = 10;
						break;
					}
				}
			}
		}
		if (serviceLvl != -1) {
			if (waitingTime > 4)
				serviceLvl--;
			if (waitingTime > 6)
				serviceLvl--;
			if (waitingTime > 8)
				serviceLvl--;
			if (waitingTime > 10)
				serviceLvl--;
			if (waitingTime > 12)
				serviceLvl--;
			
			if (timeInQueue > 4)
				serviceLvl--;
			if (timeInQueue > 6)
				serviceLvl--;
			if (timeInQueue > 8)
				serviceLvl--;
			if (timeInQueue > 10)
				serviceLvl--;
			if (timeInQueue > 12)
				serviceLvl--;
		}
		return serviceLvl;
	}
	public String getServerName() {
		String serverName = "";
		for (int i = 0; i < QueueSystem.getQueues().length; i++) {
			Queue queue = QueueSystem.getQueues()[i];
			// gets server name if not null and is the right client
			if (queue.getClientBeingServed() != null && queue.getClientBeingServed().getId() == id) {
				serverName = queue.getServerName();
			}
		}
		// if client not in queue, checks if client is in client history
		if (serverName == "") {
			for (int i = 0; i < QueueSystem.getQueues().length; i++) {
				Queue queue = QueueSystem.getQueues()[i];
				for (int j = 0; j < queue.getClientsHistory().length; j++) {
					if (queue.getClientsHistory()[j] != null && queue.getClientsHistory()[j].getId() == id) {
						serverName = queue.getServerName();
					}
				}
			}
		}
		return serverName;
	}
	public String toString() {
		return "Client: " + lastName + ", " + firstName + "\n" + 
				"** Arrival Time    :" + arrivalTime + "\n" +
				"** Waiting Time    :" + waitingTime + "\n" +
				"** Time In Queue   :" + timeInQueue + "\n" +
				"** Service Time    :" + serviceTime + "\n" +
				"** Departure Time  :" + departureTime + "\n" +
				"** Served By Server:" + getServerName() + "\n" +
				"** Service Level   :" + estimateServiceLevel();
	}
}
