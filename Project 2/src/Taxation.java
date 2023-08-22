import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Taxation class contains the information needed to calculate tax
 * Taxation class includes the social security rate and income limit, medicare rate, median income per capita, and adult and child base exemption
 * Taxation class also holds the information on the income brackets and tax rates
 * @author Thi Ley
 */
public class Taxation {
    // protected attributes
    private static float socialSecurityRate = (float)(12.4);
    private static float socialSecurityIncomeLimit = (float)(137700.0);
    private static float medicareRate = (float)(2.9);
    private static float adultBaseExemption = (float)(3000.0);
    private static float childBaseExemption = (float)(2000.0);
    private static float medianIncomePerCapita = (float)(31099.0);

    // private tables
    
    private static float[][] incomeBracket = {
            // single - filing status 1
            {10000, 40000, 80000, 160000},
            // married jointly - filing status 2
            {20000, 70000, 160000, 310000},
            // married separately - filing status 3
            {12000, 440000, 880000, 170000}
        };
    
    private static float[][] taxRate = {
            // single
            {0.1f, 0.12f, 0.22f, 0.24f, 0.32f},
            // married jointly
            {0.1f, 0.12f, 0.23f, 0.25f, 0.33f},
            // married separately
            {0.1f, 0.12f, 0.24f, 0.26f, 0.35f}
        };
    
    // getters
    public static byte getNumTaxBrackets(){
        return (byte)taxRate[0].length;
    }
    public static float getMedicareRate() {
    	return medicareRate;
    }
    public static float getMedianIncomePerCapita() {
    	return medianIncomePerCapita;
    }
    public static float getSocialSecurityIncomeLimit() {
    	return socialSecurityIncomeLimit;
    }
    public static float getAdultBaseExemption() {
    	return adultBaseExemption;
    }
    public static float getChildBaseExemption() {
    	return childBaseExemption;
    }
    public static float getSocialSecurityRate() {
    	return socialSecurityRate;
    }
    
    // other methods
    /**
     * Reads a file and stores the values in it's corresponding variable
     * @param filename is the file with the values for social security rate and income limit, medicare rate, median income per capita, and adult and child base exemption
     * @throws FileNotFoundException
     */
    public static void loadParameters(String filename) throws FileNotFoundException{
        Scanner scnr = new Scanner(new File(filename));
        String words = "";
        while (scnr.hasNextLine()){
            words = scnr.nextLine() + "\n";
            int spaceIndex = words.indexOf(" ");
            if (words.substring(0, spaceIndex).contentEquals("medicareRate")){
                medicareRate = Float.parseFloat(words.substring(spaceIndex + 1));
            }
            else if (words.substring(0, spaceIndex).contentEquals("medianIncomePerCapita")){
                medianIncomePerCapita = Float.parseFloat(words.substring(spaceIndex + 1));
            }
            else if (words.substring(0, spaceIndex).contentEquals("socialSecurityIncomeLimit")){
                socialSecurityIncomeLimit = Float.parseFloat(words.substring(spaceIndex + 1));
            }
            else if (words.substring(0, spaceIndex).contentEquals("adultBaseExemption")){
                adultBaseExemption = Float.parseFloat(words.substring(spaceIndex + 1));
            }
            else if (words.substring(0, spaceIndex).contentEquals("childBaseExemption")){
                childBaseExemption = Float.parseFloat(words.substring(spaceIndex + 1));
            }
            else if (words.substring(0, spaceIndex).contentEquals("socialSecurityRate")){
                socialSecurityRate = Float.parseFloat(words.substring(spaceIndex + 1));
            }
        }
        scnr.close();
    }

    /**
     * Finds the bracket that the family's taxable income belongs in
     * @param family is the Family object that holds all of the family members
     * @return the maximum tax bracket that the family's income is in
     */
    public static byte maxIncomeTaxBracket(Family family){
    	int bracket = 0;
    	int fs = family.getFilingStatus() - 1;
    	//if (family.getFilingStatus() == 1) {
    		for (int i = 0; i < incomeBracket[fs].length; i++) {
    			if (family.getTaxableIncome() <= incomeBracket[fs][i]) {
    				bracket = i + 1;
    				break;
    			}
    		}
    		if (bracket == 0) {
    			bracket = 5;
    		}
    	return (byte)bracket;
    }
    
    /**
     * Calculates the amount of a family's taxable income that is within the given bracket
     * @param family is the Family object that holds all of the family members
     * @param b the bracket number that corresponds with the income bracket data table
     * @return the portion of a family's taxable income that falls within bracket b
     */
    public static float bracketIncome(Family family, byte b) {
    	float result = 0;
    	float min = 0;
    	float max = 0;
    	int fs = family.getFilingStatus() - 1;
    	if (b == 1) {
    		if (family.getTaxableIncome() > incomeBracket[fs][0]) {
    			result = incomeBracket[fs][0];
    		}
    		else {
    			result = family.getTaxableIncome();
    		}
    	}
    	else if (b == 2 || b == 3 || b == 4) {
    		//for (int i = 1; i < incomeBrackets[fs].length - 1; i++) {
    			min = incomeBracket[fs][b-2];
    			max = incomeBracket[fs][b-1];
    			if (min < family.getTaxableIncome() && family.getTaxableIncome() <= max) {
    				result = family.getTaxableIncome() - min;
    				//break;
    			}
    			else if (family.getTaxableIncome() > max) {
    				result = max - min;
    				//break;
    			}
    		//}
    	}
    	else if (b == 5) {
    		if (family.getTaxableIncome() > incomeBracket[fs][incomeBracket[fs].length - 1]) {
    			result = family.getTaxableIncome() - incomeBracket[fs][incomeBracket[fs].length - 1];
    		}
    	}
    	return result;
    }
    
    /**
     * Finds the tax rate amount that corresponds with the given filing status and bracket number
     * @param b is the bracket number
     * @param f is the filing status
     * @return the tax rate that corresponds to bracket b and filing status f
     */
    public static float bracketTaxRate(byte b, byte f) {
    	float tr = 0.0f;
    	tr = taxRate[f-1][b-1];
    	return tr;
    }
}
