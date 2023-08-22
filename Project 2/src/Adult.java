/**
 * Adult class inherits from the Person class
 * Adult class represents an adult person with the attributes from the Person class and employer
 * @author Thi Ley
 */
public class Adult extends Person{
    // private attributes
    private String employer;
    
    /**
     * Constructor for the Adult class creating a new Adult object
     * @param name is the name of the adult
     * @param birthday is the birthday of the adult
     * @param ssn is the social security number of the adult
     * @param grossIncome is the gross income of the adult
     * @param employer is the employer of the adult
     */
    public Adult(String name, String birthday, String ssn, float grossIncome, String employer){
        super.setName(name);
        super.setBirthday(birthday);
        super.setSSN(ssn);
        super.setGrossIncome(grossIncome);
        this.employer = employer;
    }

    // getter
    public String getEmployer(){
        return employer;
    }

    /**
     * Overrides parent method
     * String output includes the name, masked social security number, masked birthday, and gross income
     * The SSN only shows last 4 digits with all other digits being masked by an "x"
     * The birthday only shows the year with all other digits being masked by an "*"
     * @return a string representation of the object
     */
    @Override
    public String toString(){
        String maskedSSN = super.getSSN().substring(7, 11);
        String maskedYear = super.getBirthday().substring(0, 4);
        return getName() + " xxx-xx" + maskedSSN + " " + maskedYear + "/**/** " + getGrossIncome();
    }
    
    /**
     * Overrides parent method
     * Calculates the adult's deduction based on their filing status and adjusted income
     * If the adult is a single parent, the base exemption is doubled
     * If the adjusted income is over $100,000, then the exemption is reduced by 0.5% per whole thousand dollars of adjusted income about 100k
     * The reduction percentage cannot exceed 30% and the exemption cannot exceed adjusted income
     * @param family is the family used to get the adult
     * @return the amount of the adult's taxes that are exempted
     */
    @Override
    public float deduction(Family family){
    	
    	float abe = Taxation.getAdultBaseExemption();
    	float adjusteded = adjustedIncome() - 100000; // adjusted income above 100k
    	float reduction = 0.0f;
    	float finalABE;
    	// if single-parent
        if (family.getFilingStatus() == 1) {
        	abe *= 2;
        }
        // if adjusted income is over 100k
        if (adjustedIncome() > 100000) {
        	while (adjusteded > 1000 && reduction <= 0.3f) {
        		reduction += 0.005;
        		adjusteded -= 1000;
        	}
        	if (reduction > 0.3f) {
        		reduction = 0.3f;
        	}
        	abe = abe - (abe * reduction);
        }
        if (abe > adjustedIncome()) {
        	finalABE = adjustedIncome();
        }
        else {
        	finalABE = abe;
        }
        return finalABE;
    }

    // other methods
    /**
     * Calculates the adult's adjusted income by subtracting the social security income and medicare tax rates from their gross income
     * If the adult is employed, the taxes are split equally between the employer and employee
     * @return the adjusted income of the adult after subtracting these taxes
     */
    public float adjustedIncome(){
    	float socialSecurityTax = (float)(0.0);
    	float medicareTax = (float)(0.0);
    	if (getEmployer() != null) {
    		if (super.getGrossIncome() > Taxation.getSocialSecurityIncomeLimit()) {
            	socialSecurityTax = Taxation.getSocialSecurityIncomeLimit() * (Taxation.getSocialSecurityRate() / 100.0f);
            	medicareTax = super.getGrossIncome() * (Taxation.getMedicareRate() / 100.0f);
            }
            else {
            	socialSecurityTax = super.getGrossIncome() * (Taxation.getSocialSecurityRate() / 100.0f);
            	medicareTax = super.getGrossIncome() * (Taxation.getMedicareRate() / 100.0f);
            }
    	}
        return super.getGrossIncome() - ((socialSecurityTax / 2.0f) + (medicareTax / 2.0f));
    }
    
    /**
     * Amount of tax withheld calculated at a progressive rate: 10% on the first $50k, 15% on the next $100k, and 20% thereafter
     * @return total amount of tax that is withheld from the adult's paycheck
     */
    public float taxWithheld(){
        float taxWithheld = 0.0f;
        float remainingGI = 0.0f;
        float finalGI = 0.0f;
        if (getGrossIncome() <= 50000.0){
            taxWithheld = getGrossIncome() * 0.10f;
        }
        else if (getGrossIncome() <= 150000.0){
        	remainingGI = getGrossIncome() - 50000.0f; // takes first 50k out of gross income
            finalGI = remainingGI * 0.15f; // 15% of remaining gross income
            taxWithheld = 5000.0f + finalGI;
        }
        else{
        	remainingGI = getGrossIncome() - 150000.0f; // takes first 150k out of gross income
        	finalGI = remainingGI * 0.2f; // 20% of remaining gross income
            taxWithheld = 5000.0f + 15000.0f + finalGI;
        }
        return taxWithheld;
    }
}
