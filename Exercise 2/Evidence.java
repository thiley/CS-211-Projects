public class Evidence {
    // intialize fields
    private String description;
    private byte type;
    private byte unambiguity;
    private byte credibility;
    private byte completeness;
    private byte conclusiveness;
    private byte probability;

    // constructors for Evidence class
    public Evidence (String description, byte type, byte unambiguity, byte credibility, byte completeness, byte conclusiveness){
        this.description = description;
        this.type = type;
        this.unambiguity = unambiguity;
        this.credibility = credibility;
        this.completeness = completeness;
        this.conclusiveness = conclusiveness;
        this.probability = computeProbability();
    }
    public Evidence (String description, byte unambiguity, byte credibility, byte completeness, byte conclusiveness){
        this.type = 5;
        this.description = description;
        this.unambiguity = unambiguity;
        this.credibility = credibility;
        this.completeness = completeness;
        this.conclusiveness = conclusiveness;
        this.probability = computeProbability();
    }
    // public getters
    public String getDescription(){
        return this.description;
    }
    public byte getType(){
        return this.type;
    }
    public byte getUnambiguity(){
        return this.unambiguity;
    }
    public byte getCredibility(){
        return this.credibility;
    }
    public byte getCompleteness(){
        return this.completeness;
    }
    public byte getConclusiveness(){
        return this.conclusiveness;
    }
    public byte getProbability(){
        return this.probability;
    }

    // setters
    public void setDescription(String description){
        this.description = description;
    }
    public void setType(byte type){
        if (type >= 1 && type <= 5){
            this.type = type;
        }
        else{
            this.type = 5;
        }
    }
    public void setUnambiguity(byte unambiguity){
        if (unambiguity >= 0 && unambiguity <= 5){
            this.unambiguity = unambiguity;
        }
        else if (unambiguity < 0){
            this.unambiguity = 0;
        }
        else if (unambiguity > 5){
            this.unambiguity = 5;
        }
    }
    public void setCredibility(byte credibility){
        if (credibility >= 0 && credibility <= 5){
            this.credibility = credibility;
        }
        else if (credibility < 0){
            this.credibility = 0;
        }
        else if (credibility > 5){
            this.credibility = 5;
        }
    }
    public void setCompleteness(byte completeness){
        if (completeness >= 0 && completeness <= 5){
            this.completeness = completeness;
        }
        else if (completeness < 0){
            this.completeness = 0;
        }
        else if (completeness > 5){
            this.completeness = 5;
        }
    }
    public void setConclusiveness(byte conclusiveness){
        if (conclusiveness >= 0 && conclusiveness <= 5){
            this.conclusiveness = conclusiveness;
        }
        else if (conclusiveness < 0){
            this.conclusiveness = 0;
        }
        else if (conclusiveness > 5){
            this.conclusiveness = 5;
        }
    }

    // methods for Evidence class
    public byte computeProbability(){
        if (type == 1){
            probability = (byte)(0.4 * unambiguity + 0.3 * credibility + 0.2 * completeness + 0.1 * conclusiveness);
        }
        else if (type == 2){
            probability = (byte)(0.2 * unambiguity + 0.4 * credibility + 0.2 * completeness + 0.2 * conclusiveness);
        }
        else if (type == 3){
            probability = (byte)(0.3 * unambiguity + 0.2 * credibility + 0.4 * completeness + 0.1 * conclusiveness);
        }
        else if (type == 4){
            probability = (byte)(0.2 * unambiguity + 0.6 * credibility + 0.1 * completeness + 0.1 * conclusiveness);
        }
        else if (type == 5){
            probability = (byte)(0.25 * unambiguity + 0.25 * credibility + 0.25 * completeness + 0.24 * conclusiveness);
        }
        return probability;
    }
    public static String probability2String(byte probability){
        String probStr = "";
        if (probability == 0){
            probStr = "Extremely Unlikely";
        }
        else if (probability == 1){
            probStr = "Very Unlikely";
        }
        else if (probability == 2){
            probStr = "Unlikely";
        }
        else if (probability == 3){
            probStr = "Likely";
        }
        else if (probability == 4){
            probStr = "Very Likely";
        }
        else if (probability == 5){
            probStr = "Certain";
        }
        return probStr;
    }
    public String toString(){
        String eviType = "";
        if (type == 1){
            eviType = "Real Evidence";
        }
        else if (type == 2){
            eviType = "Testimonial Statement";
        }
        else if (type == 3){
            eviType = "Demonstrative Evidence";
        }
        else if (type == 4){
            eviType = "Documentary Evidence";
        }
        else if (type == 5){
            eviType = "Not Specified";
        }
        return "Evidence: " + description + "\n** Type of evidence: " + eviType + "\n** Probability: " + probability + " -> " + probability2String(probability).toLowerCase();
    }
    public String printFullDescription(){
        return toString() + "\n** Evaluated based on those characteristics:\n** >> Unambiguity: " + unambiguity + "\n** >> Credibility: " + credibility + "\n** >> Completeness: " + completeness + "\n** >> Conclusiveness: " + conclusiveness;
    }
}