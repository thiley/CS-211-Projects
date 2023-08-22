/**
 * Person class is the parent class for the Adult and Child class
 * Person class represents a person with the attributes ID, name, birthday, Social Security Number, and gross income
 * @author Thi Ley
 */
public class Person {
    // private attributes
    private int id = 1;
    private static int uniqueID = 1;
    private String name;
    private String birthday;
    private String ssn;
    private float grossIncome;

    /**
     * Constructor for the Person class
     * Assigns a unique ID to the Person object
     */
    public Person(){
        id = uniqueID;
        uniqueID += 1;
    }

    // getters
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getBirthday(){
        return birthday;
    }
    public String getSSN(){
        return ssn;
    }
    public float getGrossIncome(){
        return grossIncome;
    }

    /**
     * Sets the name of the Person object if the input is valid
     * @param name represents the name of a person
     * @return true if the name only contains letters and spaces, false otherwise
     */
    public boolean setName(String name){
        boolean validName = true;
        for (int i = 0; i < name.length(); i++){
            if (Character.isLetter(name.charAt(i)) || name.charAt(i) == ' '){
                validName = true;
            }
            else{
                validName = false;
                break;
            }
        }
        if (validName == true){
        	this.name = name;
        }
        return validName;
    }
    /**
     * Sets the birthday of the Person object if the input is valid
     * @param birthday represents the birth date of a person
     * @return true if the input is in the format YYYY/MM/DD, false otherwise
     */
    public boolean setBirthday(String birthday){
        boolean validBday = true;
        for (int i = 0; i < birthday.length(); i++){
            if (i == 4 || i == 7){
                if (birthday.charAt(i) == '/'){
                    validBday = true;
                }
                else{
                    validBday = false;
                    break;
                }
            }
            else{
                // checks if characters in btwn '/' are digits
                if (Character.isDigit(birthday.charAt(i))){
                    validBday = true;
                }
                else{
                    validBday = false;
                    break;
                }
            }
            if (validBday == true){
            	this.birthday = birthday;
            }
        }
        return validBday;
    }
    /**
     * Sets the Social Security Number of the Person Object if the input is valid
     * @param ssn represents the SSN of a person
     * @return true if the input is in the format XXX-XX-XXXX, false otherwise
     */
    public boolean setSSN(String ssn){
        boolean validSSN = true;
        for (int i = 0; i < ssn.length(); i++){
            if (i == 3 || i == 6){
                if (ssn.charAt(i) == '-'){
                    validSSN = true;
                }
                else{
                    validSSN = false;
                    break;
                }
            }
            else{
                // checks if characters in btwn '-' are digits
                if (Character.isDigit(ssn.charAt(i))){
                    validSSN = true;
                }
                else{
                    validSSN = false;
                    break;
                }
            }
            if (validSSN == true){
            	this.ssn = ssn;
            }
        }
        return validSSN;
    }
    /**
     * Sets the gross income of the Person object if the input is valid
     * @param grossIncome represents the gross income of a person
     * @return true if the input is not less than 0, false otherwise
     */
    public boolean setGrossIncome(float grossIncome){
        boolean validGI = true;
        if (grossIncome < 0){
            validGI = false;
        }
        if (validGI == true){
        	this.grossIncome = grossIncome;
        }
        return validGI;
    }

    /**
     * String output includes the name, masked social security number, and masked birthday
     * The SSN only shows last 4 digits with all other digits being masked by an "x"
     * The birthday only shows the year with all other digits being masked by an "*"
     * @return a string representation of the object
     */
    public String toString(){
        String maskedSSN = this.ssn.substring(7, 11);
        String maskedYear = this.birthday.substring(0, 4);
        return this.name + " xxx-xx" + maskedSSN + " " + maskedYear + "/**/**";
    }
    /**
     * Calculates the deduction for the family
     * @param family represents the family that the deduction is calculated for
     * @return the deduction for the given family
     */
    public float deduction(Family family){
        return 0.0f;
    }
}
