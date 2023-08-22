
public class BuyingProducts extends Request{
	// fields
	private String[] itemsToBuy;

	// getters and setters
	public String[] getItemsToBuy() {
		return itemsToBuy;
	}
	public void setItemsToBuy(String[] itemsToBuy) {
		this.itemsToBuy = itemsToBuy;
	}
	
	// constructors
	public BuyingProducts(String description, int priority, int difficulty, String[] itemsToBuy) {
		super.setDescription(description);
		super.setPriority(priority);
		super.setDifficulty(difficulty);
		this.itemsToBuy = itemsToBuy;
		super.setFactor(2);
		super.setStatus(Status.NEW);
	}
	
	public int calculateProcessingTime() {
		int processingTime = super.getDifficulty() * super.getFactor() * itemsToBuy.length;
		return processingTime;
	}
}
