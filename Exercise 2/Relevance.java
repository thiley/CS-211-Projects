public class Relevance {
    // initialize fields
    private Evidence evidence;
    private Hypothesis subHypothesis;
    private byte level;
    private byte inferentialForce;

    // constructors for Relevance class
    public Relevance (Evidence evidence, byte level){
        this.evidence = evidence;
        this.level = level;
        setInferentialForce();
    }
    public Relevance (Hypothesis subHypothesis, byte level){
        this.subHypothesis = subHypothesis;
        this.level = level;
        setInferentialForce();
    }

    // getters
    public Evidence getEvidence(){
        return this.evidence;
    }
    public Hypothesis getSubHypothesis(){
        return this.subHypothesis;
    }
    public byte getLevel(){
        return this.level;
    }
    public byte getInferentialForce(){
        return this.inferentialForce;
    }
    
    // setters
    public void setEvidence(Evidence evidence){
        this.evidence = evidence;
        this.subHypothesis = null;
        setInferentialForce();
    }
    public void setSubHypothesis(Hypothesis subHypothesis){
        this.subHypothesis = subHypothesis;
        this.evidence = null;
        setInferentialForce();
    }
    public void setLevel(byte level){
        if (level >= 0 && level <= 5){
            this.level = level;
        }
        else if (level < 0){
            this.level = 0;
        }
        else if (level > 5){
            this.level = 5;
        }
        setInferentialForce();
    }
    public void setInferentialForce(){
        if (evidence != null){
            inferentialForce = (byte)(Math.min(evidence.getProbability(), this.level));
        }
        else if (subHypothesis != null){
            inferentialForce = (byte)(Math.min(subHypothesis.getProbability(), this.level));
        }
    }

    // methods for Relevance class
    public byte computeInferentialForce(){
        setInferentialForce();
        return inferentialForce;
    }
    public String toString(){
        String description = "";
        if (evidence != null){
            description = evidence.getDescription();
        }
        else if (subHypothesis != null){
            description = subHypothesis.getDescription();
        }
        return "Relevance:\n** of: " + description + "\n** relevance level: " + level + " -> " + Evidence.probability2String(level).toLowerCase() + "\n** inferential force: " + inferentialForce + " -> " + Evidence.probability2String(inferentialForce).toLowerCase();
    }
}
