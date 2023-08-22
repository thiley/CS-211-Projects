
public class Queue{
	// fields
	private String serverName;
	private int queueSize;
	private Client clientBeingServed;
	private Request requestInProgress;
	private int processingStartTime;
	private Client[] clientsHistory;
	private Client[] clientsInQueue;
	
	// getters and setters
	public String getServerName() {
		return serverName;
	}
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	public int getQueueSize() {
		return queueSize;
	}
	public void setQueueSize(int queueSize) {
		this.queueSize = queueSize;
	}
	public Client getClientBeingServed() {
		return clientBeingServed;
	}
	public void setClientBeingServed(Client clientBeingServed) {
		this.clientBeingServed = clientBeingServed;
	}
	public Request getRequestInProgress() {
		return requestInProgress;
	}
	public void setRequestInProgress(Request requestInProgress) {
		this.requestInProgress = requestInProgress;
	}
	public int getProcessingStartTime() {
		return processingStartTime;
	}
	public void setProcessingStartTime(int processingStartTime) {
		this.processingStartTime = processingStartTime;
	}
	public Client[] getClientsHistory() {
		return clientsHistory;
	}
	public void setClientsHistory(Client[] clientsHistory) {
		this.clientsHistory = clientsHistory;
	}
	public Client[] getClientsInQueue() {
		return clientsInQueue;
	}
	public void setClientsInQueue(Client[] clientsInQueue) {
		this.clientsInQueue = clientsInQueue;
	}
	
	// constructors 
	public Queue(String serverName, int queueSize) {
		this.serverName = serverName;
		this.queueSize = queueSize;
	}
	
	// other methods
	private int queueNum() {
		int queueNum = 0;
		for (int i = 0; i < QueueSystem.getQueues().length; i++) {
			if (QueueSystem.getQueues()[i] == null) {
				break;
			}
			else if(QueueSystem.getQueues()[i].getClientBeingServed() == clientBeingServed) {
				queueNum++;
			}
		}
		return queueNum;
	}
	public int getQueueNum() {
		return queueNum();
	}
	public String toString() {
		String result = "[Queue:" + getQueueNum() + "][";
		if (clientBeingServed == null) {
			result += " ]";
		}
		else if (clientBeingServed.getId() < 10){
			result += "0" + clientBeingServed.getId() + "]";
		}
		else if (clientBeingServed.getId() >= 10) {
			result += clientBeingServed.getId() + "]";
		}
		result += "-----";
		for (int i = 0; i < clientsInQueue.length; i++) {
			if (clientsInQueue[i] == null) {
				result += "[ ]";
			}
			else if (clientsInQueue[i].getId() < 10){
				result += "0" + clientsInQueue[i].getId() + "]";
			}
			else if (clientsInQueue[i].getId() >= 10) {
				result += clientsInQueue[i].getId() + "]";
			}
		}
		return result;
	}
	public String toString(boolean showID) {
		String result = "[Queue:" + getQueueNum() + "][";
//		int timeLeft = 0;
//		if (clientBeingServed == null) {
//			clientBeingServed.setServiceTime(0);
//			timeLeft = clientBeingServed.getServiceTime() - QueueSystem.getClock() - processingStartTime;
//		}
//		else {
//			timeLeft = clientBeingServed.getServiceTime() - QueueSystem.getClock() - processingStartTime;
//		}
		int timeLeft = clientBeingServed.getServiceTime() - QueueSystem.getClock() - processingStartTime;
		if (showID == false) {
			if (clientBeingServed == null) {
				result += " ]";
			}
			else if (clientBeingServed.getId() < 10){
				result += "0" + timeLeft + "]-----";
			}
			else if (clientBeingServed.getId() >= 10) {
				result += timeLeft + "]-----\"";
			}
			for (int i = 0; i < clientsInQueue.length; i++) {
				if (clientsInQueue[i] == null) {
					result += "[ ]";
				}
				else if (clientsInQueue[i].getId() < 10){
					result += "0" + clientsInQueue[i].getServiceTime() + "]-----\"";
				}
				else if (clientsInQueue[i].getId() >= 10) {
					result += clientsInQueue[i].getServiceTime() + "]-----\"";
				}
			}
		}
		else if(showID == true) {
			result += toString();
		}
		return result;
	}
}
