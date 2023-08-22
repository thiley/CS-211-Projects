
public class ReturningItems extends Request{
	// fields
	private String[] itemsToReturn;
	
	// getters and setters 
	public String[] getItemsToReturn() {
		return itemsToReturn;
	}
	public void setItemsToReturn(String[] itemsToReturn) {
		this.itemsToReturn = itemsToReturn;
	}
	
	// constructors
	public ReturningItems(String description, int priority, int difficulty, String[] itemsToReturn) {
		super.setDescription(description);
		super.setPriority(priority);
		super.setDifficulty(difficulty);
		this.itemsToReturn = itemsToReturn;
		super.setFactor(3);
		super.setStatus(Status.NEW);
	}
	
	// other methods
	public int calculateProcessingTime() {
		int processingTime = super.getDifficulty() * super.getFactor() * itemsToReturn.length;
		return processingTime;
	}
}
