
public class QueueSystem {
	// fields
	private static int clock;
	private static int totalWaitingTime;
	private static Client[] clientsWorld;
	private static int totalClientsInSystem;
	private static int waitingLineSize;
	private static Client[] waitingLine;
	private static boolean tvInWaitingArea;
	private static boolean coffeeInWaitingArea;
	private static Queue[] queues;
	
	// getters and setters
	public static int getClock() {
		return clock;
	}
	public static void setClock(int clock) {
		QueueSystem.clock = clock;
	}
	public static int getTotalWaitingTime() {
		int totWaitTime = 0;
		for (int i = 0; i < queues.length; i++) {
			for (int j = 0; j < queues[i].getClientsInQueue().length; j++) {
				if (queues[i].getClientBeingServed() != null) {
					totWaitTime += queues[i].getClientBeingServed().getWaitingTime();
				}
				if (queues[i].getClientsInQueue()[j] != null) {
					totWaitTime += queues[i].getClientBeingServed().getWaitingTime();
				}
			}
		}
		for (int i = 0; i < waitingLine.length; i++) {
			if (waitingLine[i] != null) {
				totWaitTime += waitingLine[i].getWaitingTime();
			}
		}
		QueueSystem.totalWaitingTime = totWaitTime;
		return totalWaitingTime;
	}
	public static Client[] getClientsWorld() {
		return clientsWorld;
	}
	public static void setClientsWorld(Client[] clientsWorld) {
		QueueSystem.clientsWorld = clientsWorld;
	}
	public static int getTotalClientsInSystem() {
		int totClientSystem = 0;
		for (int i = 0; i < queues.length; i++) {
			for (int j = 0; j < queues[i].getClientsInQueue().length; j++) {
				if (queues[i].getClientBeingServed() != null) {
					totClientSystem++;
				}
				if (queues[i].getClientsInQueue()[j] != null) {
					totClientSystem++;
				}
			}
		}
		for (int i = 0; i < waitingLine.length; i++) {
			if (waitingLine[i] != null) {
				totClientSystem++;
			}
		}
		QueueSystem.totalClientsInSystem = totClientSystem;
		return totalClientsInSystem;
	}
	public static void setTotalClientsInSystem(int totalClientsInSystem) {
		QueueSystem.totalClientsInSystem = totalClientsInSystem;
	}
	public static int getWaitingLineSize() {
		return waitingLineSize;
	}
	public static void setWaitingLineSize(int waitingLineSize) {
		QueueSystem.waitingLineSize = waitingLineSize;
	}
	public static Client[] getWaitingLine() {
		return waitingLine;
	}
	public static void setWaitingLine(Client[] waitingLine) {
		QueueSystem.waitingLine = waitingLine;
	}
	public static boolean getTvInWaitingArea() {
		return tvInWaitingArea;
	}
	public static void setTvInWaitingArea(boolean tvInWaitingArea) {
		QueueSystem.tvInWaitingArea = tvInWaitingArea;
	}
	public static boolean getCoffeeInWaitingArea() {
		return coffeeInWaitingArea;
	}
	public static void setCoffeeInWaitingArea(boolean coffeeInWaitingArea) {
		QueueSystem.coffeeInWaitingArea = coffeeInWaitingArea;
	}
	public static Queue[] getQueues() {
		return queues;
	}
	public static void setQueues(Queue[] queues) {
		QueueSystem.queues = queues;
	}
	
	// constructors
	public QueueSystem(int waitingLineSize, boolean tvInWaitingArea, boolean coffeeInWaitingArea) {
		QueueSystem.waitingLineSize = waitingLineSize;
		QueueSystem.tvInWaitingArea = tvInWaitingArea;
		QueueSystem.coffeeInWaitingArea = coffeeInWaitingArea;
		QueueSystem.clock = 0;
		QueueSystem.waitingLine = new Client[waitingLineSize];
	}
	
	// other methods
	public void increaseTime() {
		// increase the clock
		clock++;
		
		// check if server have processed the requests
		for (int i = 0; i < queues.length; i++) {
			if (queues[i].getClientBeingServed() != null) {
				int processed = 0;
				Request[] request = queues[i].getClientBeingServed().getRequests();
				for (int j = 0; j < request.length; j++) {
					// updates each request status
					// increase count of processed requests if processed
					if (request[j].getStatus() == Status.PROCESSED) {
						processed++;
					}
					// update request to check if it gets processed, increase processed count if it does
					else if(request[j].getStatus() == Status.IN_PROGRESS) {
						if (request[j].calculateProcessingTime() == clock - request[j].getStartTime()) {
							request[j].setEndTime(clock);
							request[j].setStatus(Status.PROCESSED);
							request[j].setCompletionLevel(100);
							processed++;
						}
						else {
							// updates completion level of request if not done being processed
							int completeLvlNum = clock - queues[i].getClientBeingServed().getRequests()[j].getStartTime();
							int completeLvlDen = queues[i].getClientBeingServed().getRequests()[j].calculateProcessingTime();
							request[j].setCompletionLevel(completeLvlNum / completeLvlDen * 100);
						}
					}
					// if previous request has been processed and there are more requests remaining, update next request
					if (processed > 0 && request[j].getStatus() == Status.NEW) {
						request[j].setStartTime(clock);
						request[j].setStatus(Status.IN_PROGRESS);
						request[j].setCompletionLevel(0);
						processed = 0;
						break;
					}
				}
				// move client to history once all their requests have been processed and update queue
				int clientTime = queues[i].getClientBeingServed().serviceTime();
				int clientDone = getClock() - queues[i].getProcessingStartTime();
				if (clientTime - clientDone == 0) {
					// set clients departure time
					queues[i].getClientBeingServed().setDepartureTime(clock);
					// loop through client history to add to temp arr
					Client[] tempClientHist = new Client[queues[i].getClientsHistory().length + 1];
					if (tempClientHist.length == 1) {
						tempClientHist[0] = queues[i].getClientBeingServed();
					}
					else {
						for (int j = 0; j < queues[i].getClientsHistory().length; j++) {
							tempClientHist[j] = queues[i].getClientsHistory()[j];
						}
					}
					// adds client to client history
					tempClientHist[queues[i].getClientsHistory().length] = queues[i].getClientBeingServed();
					// removes client from system, and sets client in queue to null
					queues[i].setClientsHistory(tempClientHist);					
					queues[i].setClientBeingServed(null);
				}
			}
			Client[] clientsInQueue = queues[i].getClientsInQueue();
			// update client queue to start serving the next client
			if (queues[i].getClientBeingServed() == null) {
				// if there is a next client in queue, set client being served to this client
				Client nextClient = clientsInQueue[0];
				if (nextClient != null) {
					queues[i].setClientBeingServed(nextClient);
					queues[i].setProcessingStartTime(clock);
				}
				queues[i].setClientBeingServed(clientsInQueue[0]);
				// move clients up the queue
				for (int j = 0; j < clientsInQueue.length - 1; j++) {
					if (clientsInQueue[j+1] != null) {
						clientsInQueue[j] = clientsInQueue[j+1];
					}
				}
				clientsInQueue[clientsInQueue.length - 1] = null;
				// move waiting line clients up into new empty queue slot
				if (waitingLine[0] != null) {
					clientsInQueue[clientsInQueue.length - 1] = waitingLine[0];
					waitingLine[0] = null;
				}
				// update patience of clients in queue
				for (int j = 0; j < clientsInQueue.length; j++) {
					if (clientsInQueue[j] != null) {
						clientsInQueue[j].setPatience(clientsInQueue[j].getPatience() - 1);
						clientsInQueue[j].setTimeInQueue(clientsInQueue[j].getTimeInQueue() + 1);
					}
				}
				// update waiting line
				for (int j = 0; j < waitingLine.length; j++) {
					if (waitingLine[j+1] != null) {
						waitingLine[j] = waitingLine[j+1];
					}
				}
				waitingLine[waitingLine.length - 1] = null;
				// update patience of clients in waiting line
				for (int j = 0; j < waitingLine.length; j++) {
					if (waitingLine[j] != null) {
						waitingLine[j].setPatience(waitingLine[j].getPatience() - 1);
						waitingLine[j].setTimeInQueue(waitingLine[j].getWaitingTime() + 1);
					}
				}
				// check patience in queue and waiting line
//				for (int j = 0; j <clientsInQueue.length; j++) {
//					
//				}
			}
		}
	}
	public void increaseTime(int time) {
		while(time > 0) {
			increaseTime();
			time--;
		}
	}
	public Client[] getClientsBeingServed() {
		Client[] tempClientsBeingServed = new Client[queues.length];
		for (int i = 0; i < queues.length; i++) {
			tempClientsBeingServed[i] = queues[i].getClientBeingServed();
		}
		int nullCnt = tempClientsBeingServed.length;
		for (int i = 0; i < tempClientsBeingServed.length; i++) {
			if (tempClientsBeingServed[i] == null) {
				nullCnt--;
			}
		}
		Client[] clientsBeingServed = new Client[nullCnt];
		int cbsIndex = 0;
		for (int i = 0; i < tempClientsBeingServed.length; i++) {
			if (tempClientsBeingServed[i] == null) {
				continue;
			}
			else {
				clientsBeingServed[cbsIndex] = tempClientsBeingServed[i];
				cbsIndex++;
			}
		}
		return clientsBeingServed;
	}
	public String toString() {
		String result = "";
		for (int i = 0; i < queues.length; i++) {
			result += queues[i].toString(false) + "\n";
		}
		result += "---\n[Waiting Line]-";
		for (int i = 0; i < waitingLine.length; i++) {
			if (waitingLine[i] == null) {
				result += "[ ]";
			}
			else if (waitingLine[i].serviceTime() < 10){
				result += "0" + waitingLine[i].serviceTime() + "]";
			}
			else if (waitingLine[i].serviceTime() >= 10) {
				result += waitingLine[i].serviceTime() + "]";
			}
		}
		return result;
	}
	public String toString(boolean showID) {
		String result = "";
		if (showID) {
			for (int i = 0; i < queues.length; i++) {
				result += queues[i].toString() + "\n";
			}
		}
		result += "---\n[Waiting Line]-";
		for (int i = 0; i < waitingLine.length; i++) {
			if (waitingLine[i] == null) {
				result += "[ ]";
			}
			else if (waitingLine[i].getId() < 10){
				result += "0" + waitingLine[i].getId() + "]";
			}
			else if (waitingLine[i].getId() >= 10) {
				result += waitingLine[i].getId() + "]";
			}
		}
		return result;
	}
}
