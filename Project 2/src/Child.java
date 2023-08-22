/**
 * Child class inherits from the Person class
 * Child class represents an child person with the attributes from the Person class, school, and tuition
 * @author Thi Ley
 */
public class Child extends Person{
    // private attributes
    private String school;
    private float tuition;

    /**
     * Constructor for the Child class creating a new Child object
     * @param name is the name of the child
     * @param birthday is the birthday of the child
     * @param ssn is the social security number of the child
     * @param grossIncome is the gross income of the child
     * @param school is the name of the school that the child attends
     * @param tuition is the amount of tuition paid per year
     */
    public Child(String name, String birthday, String ssn, float grossIncome, String school, float tuition){
        super.setName(name);
        super.setBirthday(birthday);
        super.setSSN(ssn);
        super.setGrossIncome(grossIncome);
        this.school = school;
        this.tuition = tuition;
    }

    // getter
    public String getSchool(){
        return school;
    }
    
    public float getTuition(){
        return tuition;
    }

    /**
     * Overrides parent method
     * String output includes the name, masked social security number, masked birthday, and school name
     * The SSN only shows last 4 digits with all other digits being masked by an "x"
     * The birthday only shows the year with all other digits being masked by an "*"
     * @return a string representation of the object
     */
    @Override
    public String toString(){
        String maskedSSN = super.getSSN().substring(7, 11);
        String maskedYear = super.getBirthday().substring(0, 4);
        return getName() + " xxx-xx" + maskedSSN + " " + maskedYear + "/**/** " + school;
    }
    
    /**
     * Overrides parent method
     * Calculates the amount of the child's gross income that is exempted from taxation 
     * If there are more than 2 children in family, there is an additional 5% for each addition child
     * The reduction percentage cannot exceed 50% and the exemption cannot exceed gross income
     * @param family is the family used to get the child
     * @return the amount of the child's gross income that are exempted
     */
    @Override
    public float deduction(Family family){
    	float cbe = Taxation.getChildBaseExemption();
    	int numKids = family.getNumChildren();
    	float reduction = 0.05f;
    	float finalCBE;
    	// if family has more than 2 kids
    	if (numKids == 0) {
    		finalCBE = 0;
    	}
    	else if (family.getNumChildren() > 2) {
    		int extraKids = numKids - 2;
    		reduction *= extraKids;
    		if (reduction > 0.5) {
    			reduction = 0.5f;
    		}
    		cbe -= (cbe * reduction);
    	}
    	else {
    		finalCBE = cbe;
    	}
    	if (cbe > super.getGrossIncome()) {
			finalCBE = super.getGrossIncome();
		}
		else {
			finalCBE = cbe;
		}
    	return finalCBE;
    }
}
