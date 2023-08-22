/**
 * Family class represents a family including adults and children
 * Family class contains information on the number of members and the filing status of the adults
 * @author Thi Ley
 */
public class Family {
    private byte numMembers;
    private byte filingStatus;
    private Person[] members;
    
    //getters 
    public byte getNumMembers() {
    	return numMembers;
    }
    
    public byte getFilingStatus() {
    	return filingStatus;
    }
    public Person[] getMembers() {
    	return members;
    }
    
    /**
     * Constructor for the Family class
     * Initializes an array of Person with the length being the number of people in the family
     * @param numMembers the number of people in the family
     * @param filingStatus how the adults are filing their taxes
     */
    public Family(byte numMembers, byte filingStatus) {
    	this.numMembers = numMembers;
    	this.filingStatus = filingStatus;
    	members = new Person[numMembers];
    }
    
    // methods
    /**
     * Adds a person to the family array and extends the length of the array for additional family member
     * @param person a Person object that needs to get added into the family
     */
    public void addMember(Person person) {
    	if (members[members.length - 1] != null) {
    		Person[] tempArr = new Person[members.length+1];
    		for (int i = 0; i < members.length; i++) {
    			tempArr[i] = members[i];
    		}
    		tempArr[tempArr.length - 1] = person;
    		members = tempArr;
    		numMembers++;
    	}
    	else {
    		for (int i = 0; i < members.length; i++) {
        		// fills in first empty member slot
        		if (members[i] == null) {
        			members[i] = person;
        			break; // to only add one person at a time
        		}
        	}
    	}
    }
    
    public byte getNumAdults() {
    	int numAdults = 0;
    	for (int i = 0; i < members.length; i++) {
    		if (members[i] instanceof Adult) {
        		numAdults++;
        	}
    	}
    	return (byte)numAdults;
    }
    
    public byte getNumChildren() {
    	int numChild = 0;
    	for (int i = 0; i < members.length; i++) {
    		if (members[i] instanceof Child) {
        		numChild++;
        	}
    	}
    	return (byte)numChild;
    }
    
    /**
     * Calculates the taxable income of a family by adding the adjusted income of adults, adding the gross income of children,
     * and subtracting respective deductions
     * @return the family's total taxable income
     */
    public float getTaxableIncome() {
    	Family family = new Family(numMembers, filingStatus);
    	// populate family
    	for (int i = 0; i < members.length; i++) {
    		family.members[i] = members[i];
    	}
    	float taxableIncome = 0.0f;
    	for (int i = 0; i < members.length; i++) {
    		// if member is an adult
    		if (members[i] instanceof Adult) {
    			taxableIncome += ((Adult)members[i]).adjustedIncome();
    			taxableIncome -= ((Adult)members[i]).deduction(family);
    		}
    		// if member is a child
    		else if (members[i] instanceof Child) {
    			taxableIncome += ((Child)members[i]).getGrossIncome();
    			taxableIncome -= ((Child)members[i]).deduction(family);
    		}
    	}
    	return taxableIncome;
    }
    
    /**
     * Calculates tax credit if a family's taxable income is less than or equal to half of the median income per capita
     * Adds $30 for every whole thousand of taxable income
     * If the member is a child, add either 2000 or tuition, whichever is lower
     * Tax credit cannot exceed 2000 or the amount of pre-credit tax, whichever is lower
     * @return the amount of tax credit that a family is eligible to receive
     */
    public float taxCredit() {
    	float credit = 0;
    	float taxInc = getTaxableIncome();
    	float maxCred = 0;
    	if (getTaxableIncome() <= Taxation.getMedianIncomePerCapita() / 2) {
    		while(taxInc > 1000) {
    			credit += 30;
    			taxInc -= 1000;
    		}
    		for (int i = 0; i < members.length; i++) {
        		if (members[i] instanceof Child) {
        			if (((Child)members[i]).getTuition() < 1000) {
        				credit += ((Child)members[i]).getTuition();
        			}
        			else {
        				credit += 1000;
        			}
        		}
        	}
    	}
    	// set max credit
    	if (getTaxableIncome() < 2000) {
    		maxCred = getTaxableIncome();
    	}
    	else {
    		maxCred = 2000;
    	}
    	// if credit is within max credit
    	if (credit > maxCred) {
    		credit = maxCred;
    	}
    	// if filing separately
    	if (getFilingStatus() == 3) {
    		credit /= 2;
    	}
    	return credit;
    }
    
    /**
     * Sums the amounts of tax that correspond to each tax bracket up to the maximum tax bracket
     * @return the total calculated tax 
     */
    public float calcTax123() {
    	Family family = new Family(numMembers, filingStatus);
    	// populate family with members
    	for (int i = 0; i < members.length; i++) {
    		family.members[i] = members[i];
    	}
    	float totalCalcTax = 0.0f;
    	// point 2
    	int maxTaxBrac = Taxation.maxIncomeTaxBracket(family);
    	// point 3
    	for (int i = 1; i <= maxTaxBrac; i++) {
    		totalCalcTax += (Taxation.bracketIncome(family, (byte)i) * Taxation.bracketTaxRate((byte)i, (byte)getFilingStatus()));
    	}
    	return totalCalcTax;
    }
    
    /**
     * Subtracts tax credit and taxes that were withheld from the total calculated tax
     * @return final calculated amount of tax
     */
    public float calculateTax() {
    	float calculateTax = calcTax123();
    	// point 4
    	calculateTax -= taxCredit();
    	// point 5
    	for (int i = 0; i < members.length; i++) {
    		if (members[i] instanceof Adult) {
    			calculateTax -= ((Adult)(members[i])).taxWithheld();
    		}
    	}
    	return calculateTax;
    }
    
}
