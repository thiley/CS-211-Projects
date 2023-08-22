/**
 * TaxYear class holds the filing information for all of the families filing taxes
 * TaxYear class also contains the maximum number of returns that can be filed
 * @author Thi Ley
 */
public class TaxYear {
	private int max;
	private Family[] totalFams;
	
    /**
     * Constructor for TaxYear class creating a new Family array to hold all of the families filing taxes
     * @param max the maximum number of returns that can be filed for this year
     */
	public TaxYear (int max) {
		this.max = max;
		this.totalFams = new Family[0];
	}
	
	// getter
	public Family[] getTotalFams() {
		return totalFams;
	}
	
	// methods
	/**
	 * Validates the family's data, files the family's tax return, and if valid, adds the family to an array of all the families filed
	 * @param family is the Family object that holds all of the family members
	 * @return true if the family's data for the tax return is valid, false otherwise
	 */
	public boolean taxFiling(Family family) {
		boolean validTax = true;
		// cannot add more families than max
		if (numberOfReturnsFiled() >= max) {
			validTax = false;
		}
		// if there are no adults or more than 2
		else if (family.getNumAdults() == 0 || family.getNumAdults() > 2) {
			validTax = false;
		}
		// if filing status is not 1, 2, or 3
		else if (family.getFilingStatus() < 1 || family.getFilingStatus() > 3) {
			validTax = false;
		}
		// if filing status is single or separate, but there isn't only 1 adult
		else if ((family.getFilingStatus() == 1 || family.getFilingStatus() == 3) && family.getNumAdults() != 1) {
			validTax = false;
		}
		// if filing status is joint, but there aren't only 2 adults
		else if (family.getFilingStatus() == 2 && family.getNumAdults() != 2) {
			validTax = false;
		}
		int numFams = totalFams.length;
		if (validTax == true) {
			Family[] tempNewFam = new Family[numFams + 1];
			if (tempNewFam[numFams] == null) {
				tempNewFam[numFams] = family;
			}
			for (int i = 0; i < numFams; i++) {
				if (totalFams[i] != null) {
					tempNewFam[i] = totalFams[i];
				}
			}
			totalFams = tempNewFam;
		}
		return validTax;
	}
	
	/**
	 * Adds up all the tax withheld from each family and all their adult family members
	 * @return total tax that was withheld from all the families
	 */
	public float taxWithheld() {
		float taxWithheld = 0.0f;
		for (int i = 0; i < totalFams.length; i++) {
			for (int j = 0; j < totalFams[i].getMembers().length; j++) {
				if (totalFams[i].getMembers()[j] instanceof Adult) {
					Adult index = (Adult)(totalFams[i].getMembers()[j]);
					taxWithheld += index.taxWithheld();
				}
			}
		}
		return taxWithheld;
	}
	
	/**
	 * Adds up all the total calculated tax amount of every family filed
	 * @return total tax that is owed by all the families
	 */
	public float taxOwed() {
		float taxOwed = 0.0f;
		for (int i = 0; i < totalFams.length; i++) {
			taxOwed += totalFams[i].calcTax123();
		}
		return taxOwed;
	}
	
	/**
	 * Adds up all the final calculated amount of tax of every family filed
	 * @return total tax that was due/returned
	 */
	public float taxDue() {
		float taxDue = 0.0f;
		for (int i = 0; i < totalFams.length; i++) {
			taxDue += totalFams[i].calculateTax();
		}
		return taxDue;
	}
	
	/**
	 * Adds up all the tax credits of every family filed
	 * @return total tax credits that were given to families
	 */
	public float taxCredits() {
		float taxCreds = 0.0f;
		for (int i = 0; i < totalFams.length; i++) {
			taxCreds += totalFams[i].taxCredit();
		}
		return taxCreds;
	}
	
	/**
	 * Calculates the number of tax returns that were filed
	 * @return number of tax returns that were filed
	 */
	public int numberOfReturnsFiled() {
		int numReturns = 0;
		for (int i = 0; i < totalFams.length; i++) {
			numReturns++;
		}
		if (numReturns < max) {
			return numReturns;
		}
		else {
			return max;
		}
	}
	
	/**
	 * Adds up all the number of people in each family that are included in the tax returns
	 * @return total number of people that are included in the tax returns that were filed
	 */
	public int numberOfPersonsFiled() {
		int numPpl = 0;
		for (int i = 0; i < totalFams.length; i++) {
			for (int j = 0; j < totalFams[i].getMembers().length; j++) {
				numPpl++;
			}
		}
		return numPpl;
	}
	
	/**
	 * Finds the family in the local array that corresponds to the given index
	 * @param index the index of the local storage of total families filed
	 * @return the family at the index location
	 */
	public Family getTaxReturn(int index) {
		return totalFams[index];
	}
}
