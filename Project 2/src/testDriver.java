//! DO NOT SUBMIT THIS FILE
//*This file is for testing purposes only

public class testDriver {

    public static void main(String[] args) {
        int score = 0;
        int potential = 0;
        try {
            Adult a1;
            Adult a2;
            Adult a3;
            Adult a4;
            Adult a5;

            Child c1;
            Child c2;
            Child c3;
            Child c4;
            Child c5;
            Child c6;
            Child c7;
            Child c8;
            Child c9;
            Child c10;
            Child c11;
            Child c12;

            Family f1;
            Family f2;
            Family f3;

            /*
             * specific temp testing vars
             */
            String a1ToString;
            //String a2ToString;

            // Create 5 adults with random information
            a1 = new Adult("John", "01/01/1990", "123-45-6789", 130000f, "Gogle");
            a2 = new Adult("Jane", "02/02/1992", "333-12-2390", 240000, "Facebook");
            a3 = new Adult("Jack", "03/03/1993", "123-45-6229", 350000, "Apple");
            a4 = new Adult("Jill", "04/04/1994", "123-45-1238", 460000, "Microsoft");
            a5 = new Adult("Ben", "05/05/1995", "123-45-3234", 570000, "Amazon");
            score++;
            potential++;
            // create 12 children with random information
            c1 = new Child("Jenny", "77/20/1995", "203-28-7510", 2300, "Autmnwood High", 2205);
            c2 = new Child("Charlie", "77/20/1995", "203-28-1387", 2150, "River High", 4165);
            c3 = new Child("Sally", "77/20/1995", "203-28-8163", 6069, "Tuscanville High", 7577);
            c4 = new Child("Sue", "77/20/1995", "203-28-6218", 5658, "Fairfax High", 2490);
            c5 = new Child("Sam", "77/20/1995", "203-28-7582", 2814, "Autumnwood High", 727);
            c6 = new Child("Adam", "77/20/1995", "203-28-6011", 313, "Tuscanville High", 1600);
            c7 = new Child("Peter", "77/20/1995", "203-28-2286", 8786, "Fairfax High", 2076);
            c8 = new Child("Jasiah", "77/20/1995", "203-28-4661", 3626, "Autumnwood High", 409);
            c9 = new Child("Lilly", "77/20/1995", "203-28-5977", 6522, "Autmnwood High", 2565);
            c10 = new Child("Samantha", "77/20/1995", "203-28-3786", 573, "River High", 2697);
            c11 = new Child("John", "77/20/1995", "203-28-9343", 4429, "Tuscanville High", 6132);
            c12 = new Child("Michael", "77/20/1995", "203-28-6674", 3359, "Autmnwood High", 7616);
            score++;
            potential++;

            //create two seperate families, one with 12 children, and one with 0 children
            //familiy construtor takes in num members and filingstatus
            f1 = new Family((byte) 14, (byte) 1);
            f2 = new Family((byte) 2, (byte) 2);
            f3 = new Family((byte) 1, (byte) 3);
            score++;
            potential++;

            //add adults and children to family
            f1.addMember(a1);
            f1.addMember(a2);
            f1.addMember(c1);
            f1.addMember(c2);
            f1.addMember(c3);
            f1.addMember(c4);
            f1.addMember(c5);
            f1.addMember(c6);
            f1.addMember(c7);
            f1.addMember(c8);
            f1.addMember(c9);
            f1.addMember(c10);
            f1.addMember(c11);
            f1.addMember(c12);

            f2.addMember(a3);
            f2.addMember(a4);

            f3.addMember(a5);

            //set some properties for adult 1
            a1.setName("Johnathan");
            if (a1.getEmployer().equals("Gogle")) {
                score++;
                potential++;
            }
            a1ToString = a1.toString();
            System.out.println(a1ToString);
            if (a1ToString.equals("Johnathan xxx-xx-5-6789 01/0/**/** $130000.0")) {
                score++;
                potential++;
            }

            score++;
            potential++;
            System.out.println("You got " + score + " out of " + potential + " points.");
        } catch (Exception e) {
            System.out.println("Exception thrown: " + e);
        }
        /*
        * //TODO: some test methods for the driver. these provided by socratedse 
         */
        System.out.println(
                "that was phase one, testing based on personal made cases\nphase 2 are the professor made cases. these are just to see if your code works\n--------------------------------");
        Adult a21 = new Adult("name1", "1232/02/22", "987-65-4320", 0.00f, "GMU");
        Adult a22 = new Adult("name2", "1332/02/22", "987-65-4321", 1234.56f, "GMU");
        Adult a23 = new Adult("name3", "1432/02/22", "987-65-4322", 13456.78f, "GMU");
        Adult a24 = new Adult("name4", "1572/02/22", "987-65-4323", 23979.54f, "GMU");
        Adult a25 = new Adult("name5", "1632/02/22", "987-65-4324", 67890.12f, "GMU");
        Adult a26 = new Adult("name6", "1732/02/22", "987-65-4325", 123456.78f, "GMU");
        Adult a27 = new Adult("name7", "1876/05/01", "789-56-1236", 145000.98f, "Mason");
        Adult a28 = new Adult("name8", "1932/02/22", "987-65-4327", 267890.12f, "GMU");
        Adult a29 = new Adult("name9", "2032/02/22", "987-65-4328", 312346.78f, "GMU");
        Child c21 = new Child("kid1", "1200/01/01", "999-65-1110", 0.0f, "FHS", 3300.0f);
        Child c22 = new Child("kid2", "1300/01/01", "999-65-1111", 100.0f, "FHS", 0.0f);
        Child c23 = new Child("kid3", "1400/01/01", "999-65-1112", 300.0f, "FHS", 0.0f);
        Child c24 = new Child("kid4", "1500/01/01", "999-65-1113", 900.0f, "FHS", 900.0f);
        Child c25 = new Child("kid5", "1600/01/01", "999-65-1114", 1600.0f, "FHS", 1234.0f);
        Child c26 = new Child("kid6", "1700/01/01", "999-65-1115", 7300.0f, "FHS", 6650.0f);
        Child c27 = new Child("kid7", "1800/01/01", "999-65-1116", 12000.0f, "FHS", 11999.0f);
        Child c28 = new Child("kid8", "1900/01/01", "999-65-1117", 27000.0f, "FHS", 100.0f);
        Child c29 = new Child("kid9", "2000/01/01", "999-65-1118", 41560.0f, "FHS", 8765.0f);
        Family f21 = new Family((byte) 2, (byte) 3);
        f21.addMember(a21);
        f21.addMember(c21);
        f21.calculateTax();
        Family f22 = new Family((byte) 4, (byte) 2);
        f22.addMember(a22);
        f22.addMember(a23);
        f22.addMember(c22);
        f22.addMember(c23);
        f22.calculateTax();
        Family f23 = new Family((byte) 3, (byte) 2);
        f23.addMember(a24);
        f23.addMember(a25);
        f23.addMember(c24);
        f23.calculateTax();
        Family f24 = new Family((byte) 6, (byte) 2);
        f24.addMember(a26);
        f24.addMember(a27);
        f24.addMember(c25);
        f24.addMember(c26);
        f24.addMember(c27);
        f24.addMember(c28);
        f24.calculateTax();
        Family f25 = new Family((byte) 2, (byte) 2);
        f25.addMember(a28);
        f25.addMember(a29);
        f25.calculateTax();
        Family f26 = new Family((byte) 1, (byte) 1);
        f26.addMember(c29);
        TaxYear y = new TaxYear(100);

        if (y.taxFiling(f21)) {
            score++;
            potential++;
        } // returns true
        else {
            System.out.println("f21 failed");
            potential++;
        }
        if (y.taxFiling(f22)) {
            score++;
            potential++;
        } // returns true
        else {
            System.out.println("f22 failed");
            potential++;
        }
        if (y.taxFiling(f23)) {
            score++;
            potential++;
        } // returns true
        else {
            potential++;
            System.out.println("incorrect f23");
        }
        if (y.taxFiling(f24)) {
            score++;
            potential++;
        } // returns true
        else {
            potential++;
            System.out.println("incorrect f24");
        }
        if (y.taxFiling(f25)) {
            score++;
            potential++;
        } // returns true
        else {
            potential++;
            System.out.println("incorrect f25");
        }
        if (!y.taxFiling(f26)) {
            score++;
            potential++;
        } // returns false
        else {
            potential++;
            System.out.println("failed edgecase of family with no parents filing");
        }
        if (y.numberOfReturnsFiled() == 5) {
            score++;
            potential++;
        } // returns 5
        else {
            potential++;
            System.out.println("incorrect number of returns. expected: 5, got: " + y.numberOfReturnsFiled());
        } // returns 5
        if (y.numberOfPersonsFiled() == 17) {
            score++;
            potential++;
        } // returns 17
        else {
            potential++;
            System.out.println("incorrect number of persons. expected: 17, got: " + y.numberOfPersonsFiled());
        }
        if (y.taxWithheld() == 142866.65f) {
            score++;
            potential++;
        } // returns 142866.65
        else {
            potential++;
            System.out
                    .println("tax withheld calculated wrongly. expected: 142866.65, got: " + y.taxWithheld());
        }
        if (y.taxOwed() == 216255.72f) {
            score++;
            potential++;
        } // returns 216255.72
        else {
            potential++;
            System.out.println("tax owed calculated wrongly. expected: 216255.72, got: " + y.taxOwed());
        }
        //y.taxDue(); // returns 73119.06
        //y.taxCredits(); // returns 270.0*/

        System.out.println("Score: " + score + "/" + potential);
    }
}