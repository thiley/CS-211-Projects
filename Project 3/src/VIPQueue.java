
public class VIPQueue extends Queue{
	// fields
	private boolean acceptingAnyClients = true;

	// getters and setters
	public boolean isAcceptingAnyClients() {
		return acceptingAnyClients;
	}
	public void setAcceptingAnyClients(boolean acceptingAnyClients) {
		this.acceptingAnyClients = acceptingAnyClients;
	}
	
	// constructors
	public VIPQueue(String serverName, int queueSize, boolean acceptAnyClients) {
		super(serverName, queueSize);
		this.acceptingAnyClients = acceptAnyClients;
	}
	public VIPQueue(String serverName, int queueSize) {
		super(serverName, queueSize);
	}
}
