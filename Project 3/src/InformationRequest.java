
public class InformationRequest extends Request{
	// fields
	private String[] questions;
	
	// getters and setters
	public String[] getQuestions() {
		return questions;
	}
	public void setQuestions(String[] questions) {
		this.questions = questions;
	}

	// constructors
	public InformationRequest(String description, int priority, int difficulty, String[] questions) {
		super.setDescription(description);
		super.setPriority(priority);
		super.setDifficulty(difficulty);
		this.questions = questions;
		super.setFactor(1);
		super.setStatus(Status.NEW);
	}
	
	// other methods
	public int calculateProcessingTime() {
		int processingTime = super.getDifficulty() * super.getFactor() * questions.length;
		return processingTime;
	}
}
