public class Hypothesis {
    // initialize fields
    private String description;
    private Relevance[] supportingItems;
    private byte probability;

    // constructors for Hypothesis class
    public Hypothesis (String description, Relevance[] supportingItems){
        this.description = description;
        this.supportingItems = supportingItems;
    }
    public Hypothesis (String description){
        this.description = description;
        this.probability = 0;
        this.supportingItems = new Relevance[0];
    }

    // getters
    public String getDescription(){
        return this.description;
    }
    public Relevance[] getSupportingItems(){
        return this.supportingItems;
    }
    public byte getProbability(){
        return this.probability;
    }

    // setters
    public void setDescription(String description){
        this.description = description;
    }
    public void setSupportingItems(Relevance[] supportingItems){
        this.supportingItems = supportingItems;
    }
    public void setProbability(byte probability){
        if (probability >= 0 && probability <= 5){
            this.probability = probability;
        }
        else if (probability < 0){
            this.probability = 0;
        }
        else if (probability > 5){
            this.probability = 5;
        }
    }
    public void setProbability(){
        probability = 5;
        for (int i = 0; i < supportingItems.length; i++){
            if (supportingItems[i].getInferentialForce() < probability){
                probability = supportingItems[i].getInferentialForce();
            }
        }
    }

    // methods for Hypothesis class
    public void addSupportingItem(Relevance item){
        Relevance[] tempArr = new Relevance[supportingItems.length + 1];
        for (int i = 0; i < supportingItems.length; i++){
            tempArr[i] = supportingItems[i];
        }
        tempArr[tempArr.length - 1] = item;
        supportingItems = tempArr;
        setProbability();
    }
    public byte computeProbability(){
        setProbability(probability);
        return probability;
    }
    public String toString(){
        return "Hypothesis:\n** Description: " + description + "\n** Probability: " + probability + " -> " + Evidence.probability2String(probability).toLowerCase();
    }
}
