class GivenTester
{
	public static void main(String[] args) {
		Adult a1 = new Adult("name1", "1232/02/22", "987-65-4320", 0.00f, "GMU");
		Adult a2 = new Adult("name2", "1332/02/22", "987-65-4321", 1234.56f, "GMU");
		Adult a3 = new Adult("name3", "1432/02/22", "987-65-4322", 13456.78f, "GMU");
		Adult a4 = new Adult("name4", "1572/02/22", "987-65-4323", 23979.54f, "GMU");
		Adult a5 = new Adult("name5", "1632/02/22", "987-65-4324", 67890.12f, "GMU");
		Adult a6 = new Adult("name6", "1732/02/22", "987-65-4325", 123456.78f, "GMU");
		Adult a7 = new Adult("name7", "1876/05/01", "789-56-1236", 145000.98f, "Mason");
		Adult a8 = new Adult("name8", "1932/02/22", "987-65-4327", 267890.12f, "GMU");
		Adult a9 = new Adult("name9", "2032/02/22", "987-65-4328", 312346.78f, "GMU");
		Child c1 = new Child("kid1", "1200/01/01", "999-65-1110", 0.0f, "FHS", 3300.0f);
		Child c2 = new Child("kid2", "1300/01/01", "999-65-1111", 100.0f, "FHS", 0.0f);
		Child c3 = new Child("kid3", "1400/01/01", "999-65-1112", 300.0f, "FHS", 0.0f);
		Child c4 = new Child("kid4", "1500/01/01", "999-65-1113", 900.0f, "FHS", 900.0f);
		Child c5 = new Child("kid5", "1600/01/01", "999-65-1114", 1600.0f, "FHS", 1234.0f);
		Child c6 = new Child("kid6", "1700/01/01", "999-65-1115", 7300.0f, "FHS", 6650.0f);
		Child c7 = new Child("kid7", "1800/01/01", "999-65-1116", 12000.0f, "FHS", 11999.0f);
		Child c8 = new Child("kid8", "1900/01/01", "999-65-1117", 27000.0f, "FHS", 100.0f);
		Child c9 = new Child("kid9", "2000/01/01", "999-65-1118", 41560.0f, "FHS", 8765.0f);
		
		//System.out.println("-----FAMILY 1-----");
		Family f1 = new Family((byte)2, (byte)3);
		f1.addMember(a1);
		f1.addMember(c1);
		
		//System.out.println("f1 taxableIncome: " + f1.getTaxableIncome());
		//System.out.println("f1 calculateTax: " + f1.calculateTax());
		
		//System.out.println("-----FAMILY 2-----");
		Family f2 = new Family((byte)4, (byte)2);
		f2.addMember(a2);
		f2.addMember(a3);
		f2.addMember(c2);
		f2.addMember(c3);		
		//System.out.println("-----FAMILY 3-----");
		Family f3 = new Family((byte)3, (byte)2);
		f3.addMember(a4);
		f3.addMember(a5);
		f3.addMember(c4);		
		//System.out.println("-----FAMILY 4-----");
		Family f4 = new Family((byte)6, (byte)2);
		f4.addMember(a6);
		f4.addMember(a7);
		f4.addMember(c5);
		f4.addMember(c6);
		f4.addMember(c7);
		f4.addMember(c8);		
		//System.out.println("-----FAMILY 5-----");
		Family f5 = new Family((byte)2, (byte)2);
		f5.addMember(a8);
		f5.addMember(a9);		
		//System.out.println("-----FAMILY 6-----");
		Family f6 = new Family((byte)1, (byte)1);
		f6.addMember(c9);
		
		//Taxation taxation = new Taxation();
		//taxation.loadParameters("parameters.txt");
		
		TaxYear y = new TaxYear(100);
		y.taxFiling(f1); // returns true
		y.taxFiling(f2); // returns true
		y.taxFiling(f3); // returns true
		y.taxFiling(f4); // returns true
		y.taxFiling(f5); // returns true
		y.taxFiling(f6); // returns false
		//Taxation Taxation = new Taxation();
		
		System.out.println("-----FAMILIES TEST-----");
		for (int i = 0; i < y.numberOfReturnsFiled(); i++) {
			System.out.println("-------------------FAMILY " + (i+1) + "-------------------");
			for (int j = 0; j < y.getTotalFams()[i].getNumMembers(); j++) {
				if (y.getTotalFams()[i].getMembers()[j] instanceof Adult) {
					System.out.println("Adult toString: " + ((Adult)y.getTotalFams()[i].getMembers()[j]).toString());
					System.out.println("Adjusted Income:             " + ((Adult)y.getTotalFams()[i].getMembers()[j]).adjustedIncome());
					System.out.println("Tax Withheld:                " + ((Adult)y.getTotalFams()[i].getMembers()[j]).taxWithheld());
					System.out.println("Deductions:                  " + ((Adult)y.getTotalFams()[i].getMembers()[j]).deduction(y.getTotalFams()[i]));
				}
				else {
					System.out.println("Child toString: " + ((Child)y.getTotalFams()[i].getMembers()[j]).toString());
					System.out.println("Deductions:                  " + ((Child)y.getTotalFams()[i].getMembers()[j]).deduction(y.getTotalFams()[i]));
				}
				System.out.println("ID: " + y.getTotalFams()[i].getMembers()[j].getId());
				System.out.println();
			}
			//System.out.println();
			System.out.println("Filing Status:               " + y.getTotalFams()[i].getFilingStatus());
			System.out.println("Taxable Income:              " + y.getTotalFams()[i].getTaxableIncome());
			System.out.println("Max incomeBracket:           " + Taxation.maxIncomeTaxBracket(y.getTotalFams()[i]));
			System.out.println("Tax Credit:                  " + y.getTotalFams()[i].taxCredit());
			System.out.println("Calculate Tax:               " + y.getTotalFams()[i].calculateTax());
			System.out.println();
		}
		
		System.out.println();
		
		System.out.println("------------------TAX FILING------------------");
		System.out.println("Number of returns filed:         " + y.numberOfReturnsFiled()); // returns 5
		System.out.println("Number of persons filed:         " + y.numberOfPersonsFiled()); // returns 17
		System.out.println("Tax withheld:                    " + y.taxWithheld()); // returns 142866.65
		System.out.println("Tax owed:                        " + y.taxOwed()); // returns 216255.72
		System.out.println("Tax due:                         " + y.taxDue()); // returns 73119.06
		System.out.println("Tax credits:                     " + y.taxCredits()); // returns 270.0
		
		System.out.println();
		
		System.out.println("-----ANALYTICS-----");
		Analytics a = new Analytics(y);
		System.out.println("Average Family Income:           " + a.averageFamilyIncome());
		System.out.println("Average Person Income:           " + a.averagePersonIncome());
		
		System.out.println("Max Family Income:               " + a.maxFamilyIncome());
		System.out.println("Max Person Income:               " + a.maxPersonIncome());
		System.out.println("Families Below Poverty Limit:    " + a.familiesBelowPovertyLimit());
		System.out.println("Family 1 rank:                    " + a.familyRank(f1));
		System.out.println("Family 2 rank:                    " + a.familyRank(f2));
		System.out.println("Family 3 rank:                    " + a.familyRank(f3));
		System.out.println("Family 4 rank:                    " + a.familyRank(f4));
		System.out.println("Family 5 rank:                    " + a.familyRank(f5));
		
	}
}