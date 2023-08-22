/**
 * Analytics class calculates average incomes, maximum incomes, ranks, and poverty levels of all families filed for tax returns 
 * @author Thi Ley
 */
public class Analytics {
	private static float povertyThreshold = 27750;
	private TaxYear taxyear;
	
	/**
	 * Constructor for Analytics class
	 * @param taxyear is a TaxYear object
	 */
	public Analytics(TaxYear taxyear) {
		//this.povertyThreshold = povertyThreshold;
		this.taxyear = taxyear;
	}
	
	// setter
	public void setPovertyThreshold (float pov) {
		povertyThreshold = pov;
	}
	
	/**
	 * Calculates the average family income using the taxable income of every family filed
	 * @return the average income of a family
	 */
	public float averageFamilyIncome() {
		float totalTaxInc = 0.0f;
		float avgFamInc = 0.0f;
		Family[] totFams = taxyear.getTotalFams();
		int numFams = totFams.length;
		for (int i = 0; i < totFams.length; i++) {
			totalTaxInc += totFams[i].getTaxableIncome();
		}
		avgFamInc = totalTaxInc / numFams;
		return avgFamInc;
	}
	
	/**
	 * Calculates the average income of an individual using the taxable income of every person within families filed
	 * @return the average income of a person
	 */
	public float averagePersonIncome() {
		float totalTaxInc = 0.0f;
		float avgPplInc = 0.0f;
		Family[] totFams = taxyear.getTotalFams();
		int numPpl = taxyear.numberOfPersonsFiled();
		for (int i = 0; i < totFams.length; i++) {
			totalTaxInc += totFams[i].getTaxableIncome();
		}
		avgPplInc = totalTaxInc / numPpl;
		return avgPplInc;
	}
	
	/**
	 * Finds the greatest family taxable income of every family filed
	 * @return the greatest family taxable income
	 */
	public float maxFamilyIncome() {
		float maxInc = 0.0f;
		Family[] totFams = taxyear.getTotalFams();
		for (int i = 0; i < totFams.length; i++) {
			if (totFams[i].getTaxableIncome() > maxInc) {
				maxInc = totFams[i].getTaxableIncome();
			}
		}
		return maxInc;
	}
	
	/**
	 * Finds the greatest taxable income a person within every family filed
	 * @return the greatest taxable income a person
	 */
	public float maxPersonIncome() {
		Family[] totFams = taxyear.getTotalFams();
		float maxPplInc = 0;
    	for (int i = 0; i < totFams.length; i++) {
    		for (int j = 0; j < totFams[i].getMembers().length; j++) {
    			float taxableIncome = 0;
    			// if member is an adult
        		if (totFams[i].getMembers()[j] instanceof Adult) {
        			taxableIncome += ((Adult)totFams[i].getMembers()[j]).adjustedIncome();
        			taxableIncome -= ((Adult)totFams[i].getMembers()[j]).deduction(totFams[i]);
        		}
        		// if member is a child
        		else if (totFams[i].getMembers()[j] instanceof Child) {
        			taxableIncome += ((Child)totFams[i].getMembers()[j]).getGrossIncome();
        			taxableIncome -= ((Child)totFams[i].getMembers()[j]).deduction(totFams[i]);
        		}
        		// checks if max
        		if (taxableIncome > maxPplInc) {
        			maxPplInc = taxableIncome;
        		}
    		}
    	}
    	return maxPplInc;
	}
	
	/**
	 * Calculates the number of families that have a taxable income below the poverty threshold
	 * @return number of families below the poverty threshold
	 */
	public int familiesBelowPovertyLimit() {
		Family[] totFams = taxyear.getTotalFams();
		float currFamInc = 0;
		int numFams = 0;
		for (int i = 0; i < taxyear.numberOfReturnsFiled(); i++) {
			currFamInc = totFams[i].getTaxableIncome();
			if (currFamInc < povertyThreshold) {
				numFams++;
			}
		}
		return numFams;
	}
	
	/**
	 * Calculates the rank of the given family by taxable income, 1 being the rank of the family with the highest income
	 * @param family is the Family object that holds all of the family members
	 * @return the family's rank
	 */
	public int familyRank(Family family) {
		int rank = 1;
		Family[] totFams = taxyear.getTotalFams();
		for (int i = 0; i < totFams.length; i++) {
			if (family.getTaxableIncome() < totFams[i].getTaxableIncome()) {
				rank++;
			}
		}
		return rank;
	}
	
}