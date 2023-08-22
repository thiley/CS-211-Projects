//import java.io.FileNotFoundException;

class Tester
{
	public static void main(String[] args) throws Exception{
		System.out.println("-----PERSON TEST-----");
		Person person = new Person();
		person.setName("Justin Vu");
		person.setBirthday("2004/01/19");
		person.setSSN("123-45-7890");
		person.setGrossIncome((float)120000.00);
		person.getGrossIncome();
		System.out.println("Person toString: " + person.toString());
		System.out.println("Person getId: " + person.getId());
		
		System.out.println();
		
		System.out.println("-----ADULT TEST-----");
		Adult adult = new Adult("James Horng", "2004/05/27", "696-96-9696", (float)200000.0, "Bon-Chon");
		//adult.Adult("James Horng", "2004/05/27", "696-96-9696", (float)120.0, "Bon-Chon");
		System.out.println("Adult getId: " + adult.getId());
		System.out.println("Adult toString: " + adult.toString());
		System.out.println("Adult getGrossIncome: " + adult.getGrossIncome());
		System.out.println("Adult getEmployer: " + adult.getEmployer());
		System.out.println("Adult adjustedIncome: " + adult.adjustedIncome());
		System.out.println("Adult taxWithheld: " + adult.taxWithheld());
		
		System.out.println();
		
		System.out.println("-----CHILD TEST-----");
		Child child = new Child("Sivalee Intachit", "2004/11/03", "420-69-9110", (float)29000.0, "John Lewis High School", (float)17000.0);
		//child.Child("Sivalee Intachit", "2004/11/03", "420-69-9110", (float)9.0, "John Lewis High School", (float)17000.0);
		System.out.println("Child getId: " + child.getId());
		System.out.println("Child toString: " + child.toString());
		System.out.println("Child getGrossIncome: " + child.getGrossIncome());
		System.out.println("Child getSchool: " + child.getSchool());
		
		System.out.println("Child getTuition: " + child.getTuition());
		
		System.out.println();
		
		System.out.println("-----UNIQUE ID TEST-----");
		System.out.println("Person getId: " + person.getId());
		System.out.println("Adult getId: " + adult.getId());
		System.out.println("Child getId: " + child.getId());
		
		System.out.println();
		
		System.out.println("-----FAMILY TEST-----");
		//Person[] members = {adult, child};
		//Family family = new Family(members, 1);
		Family family = new Family((byte)2,(byte)1);
		family.addMember(adult);
		family.addMember(child);
		System.out.println("Family getNumAdults: " + family.getNumAdults());
		System.out.println("Family getNumChildren: " + family.getNumChildren());
		/*
		for (int i = 0; i < family.getMembers().length; i++) {
			System.out.println("Family getMembers: " + family.getMembers()[i]);
		}
		*/
		System.out.println("Adult deduction: " + adult.deduction(family));
		System.out.println("Child deduction: " + child.deduction(family));
		System.out.println("Family getTaxableIncome: " + family.getTaxableIncome());
		System.out.println("Family taxCredit: " + family.taxCredit());
		
		System.out.println();
		
		System.out.println("-----ADD FAMILY MEMBERS TEST-----");
		Adult adult2 = new Adult("Thi Ley", "2004/01/30", "420-69-1212", (float)113678, "Small Business Owner");
		family.addMember(adult2);
		Child child2 = new Child("Remi Pepelko", "2004/69/69", "420-69-5555", (float)32000, "Ashburn High School", (float)24000);
		family.addMember(child2);
		/*
		for (int i = 0; i < family.getMembers().length; i++) {
			System.out.println("Family getMembers: " + family.getMembers()[i]);
			System.out.println("Family getName: " + family.getMembers()[i].getName());
			System.out.println("Family getBirthday: " + family.getMembers()[i].getBirthday());
			System.out.println("Family getSSN: " + family.getMembers()[i].getSSN());
			System.out.println("Family getGrossIncome: " + family.getMembers()[i].getGrossIncome());
			System.out.println("Family getId: " + family.getMembers()[i].getId());
			
			if (family.getMembers()[i] instanceof Adult) {
				Adult adu = (Adult)family.getMembers()[i];
				System.out.println("Family getEmployer: " + adu.getEmployer());
			}
			else if (family.getMembers()[i] instanceof Child) {
				Child chi = (Child)family.getMembers()[i];
				System.out.println("Family getSchool: " + chi.getSchool());
			}
			
		}
		*/
		System.out.println("Family getNumAdults: " + family.getNumAdults());
		System.out.println("Family getNumChildren: " + family.getNumChildren());
		System.out.println("Family getTaxableIncome: " + family.getTaxableIncome());
		
		System.out.println();
		
		System.out.println("-----LOAD PARAMETERS TEST-----");
		//Taxation taxation1 = new Taxation();
		Taxation.loadParameters("test.txt");
		
		System.out.println();
		
		System.out.println("-----MAX INCOME BRACKET-----");
		Adult man1 = new Adult("Khoi Le", "2004/01/14", "123-12-2366", 30000.0F, "GMU");
        Adult man2 = new Adult("Samuel Kwak", "2004/12/31","345-56-7896", 20000.0F,"Infinity");
        Child kid1 = new Child("Enzo Fernandez","2010/04/01","245-45-2344",0.0F, "John Champe High School",15000.0F);
        Child kid2 = new Child("Sivalee Intachit", "2010/11/03", "420-69-9110", 0.0F, "John Lewis High School", 17000.0F);
        //Child kid3 = new Child("Allysa Gonzales","2003/12/16","352-34-5322",0.0F,"Maury High School",15000.0F);
        //Taxation taxation = new Taxation();

        //Person[] group = new Person[]{};
        Family family3 = new Family((byte)4,(byte)2);
        family3.addMember(man1);
        family3.addMember(man2);
        family3.addMember(kid1);
        family3.addMember(kid2);
        //family.addMember(kid3);
        System.out.println("deduction: "+ man1.deduction(family3));
        System.out.println("number of adults: " + family3.getNumAdults());
        System.out.println("number of children: " + family3.getNumChildren());
        System.out.println("filling status: "+ family3.getFilingStatus());
        System.out.println("adjusted income: " +man1.adjustedIncome());
        System.out.println("adjusted income: " +man2.adjustedIncome());
        System.out.println("Taxable Income: " + family3.getTaxableIncome());
        System.out.println("Tax Credit: " + family3.taxCredit());
//        System.out.println("Tax before withheld and tax credits: " + family.initialTax());
//        System.out.println("calculate tax: " + family.calculateTax());
        System.out.println("Adult witheld: " + man1.taxWithheld());
        System.out.println("Adult witheld: " + man2.taxWithheld());
        System.out.println("Max Income bracket " + Taxation.maxIncomeTaxBracket(family3));
		System.out.println("Bracket tax rate: " + Taxation.bracketTaxRate((byte)5, (byte)2));
        System.out.println("bracket income: " + Taxation.bracketIncome(family3, (byte)2));
		
		System.out.println();
//		
//		System.out.println("-----OTHERS-----");
//		
//		System.out.println("Calculate tax: " + family3.calcTax123());
//		System.out.println("Calculate tax: " + family3.calculateTax());
		
	}
}