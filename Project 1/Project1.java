public class Project1{
    public static void main(String[] args){
        /*
        System.out.println(stringValue("Mason"));
        System.out.println(stringValue("Ma son"));
        System.out.println(stringValue("mass"));
        System.out.println(stringValue("50 Cent"));
        
        System.out.println(mirrorNum(4));
        System.out.println(mirrorNum(98014));
        System.out.println(mirrorNum(-593));
        System.out.println(mirrorNum(12300));
        
        System.out.println(raisedNum(6));
        System.out.println(raisedNum(17));
        System.out.println(raisedNum(593));
        System.out.println(raisedNum(1125));

        System.out.println(expValue(1, 0.0000001));
        System.out.println(expValue(1, 0.00000001));
        System.out.println(expValue(1, 0.00001));
        
        int[][] myArray = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(vortex(myArray));
        
        int[][] myArray = {{1,2,3,4,5},{6,7,8,9}};
        System.out.println(removeDuplicates(myArray));
        int[][] myArray1 = {{1,2,2,2,3,4,5,5},{6,7,8,8,8,9}};
        System.out.println(removeDuplicates(myArray1));
        int[][] myArray2 = {{1,2,2,2,3,4,5,5},{5,5,5,5},{5,5,9}};
        System.out.println(removeDuplicates(myArray2));
        int[][] myArray3 = {{1,2,3,4},{4,4,4,4,4},{4,5,6,7}};
        System.out.println(removeDuplicates(myArray3));

        int[][] array = {{1,2,3,4,5}, {6,7,8}};
        int[] newElem = {0};
        System.out.println(replaceElement(array, 2, newElem));

        int[][] array1 = {{1,2,3,4,5}, {5,4,3,2}};
        int[] newElem1 = {-5,5};
        System.out.println(replaceElement(array1, 5, newElem1));

        int[][] array2 = {{0,1,2,3,4,5}, {5,4,3,4}};
        int[] newElem2 = {1,2,3};
        System.out.println(replaceElement(array2, 4, newElem2));
        */
    }
    // function 1
    public static int stringValue(String word){
        char[] letters = new char[word.length()];
        int max = 0;
        int sum = 0;
        // seperates each letter in the word and add to a new array
        for (int i = 0; i < word.length(); i++){
            letters[i] = word.charAt(i);
        }
        // checks for double letters and removes the double if one is found
        for (int i = 0; i < letters.length - 1; i++){
            if (letters[i] == ' ' || letters[i] == 0){
                continue;
            }
            else if ((letters[i] == letters[i+1]) && (letters[i] >= 65 && letters[i] <= 90 || letters[i] >= 97 && letters[i] <= 122)){
                letters[i+1] = 0;
            }
        }
        // finds max ascii value
        for (int i = 0; i < letters.length; i++){
            if (letters[i] == ' '){
                continue;
            }
            else if (letters[i] > max){
                max = letters[i];
            }
        }
        // calculates the value of the word
        for (int i = 0; i < letters.length; i++){
            if (letters[i] == ' '){
                sum += 0;
            }
            else if (letters[i] >= 48 && letters[i] <= 57){
                sum += (letters[i] * max);
            }
            else{
                sum += letters[i];
            }
        }
        return sum;
    }

    // function 2
    public static double expValue(int x, double precision){
        double sum = 1.0;
        double newSum = 1.0;
        int denom = 1;
        double improve = 0;
        for (int i = 1; i > 0; i++){
            newSum += Math.pow(x, i) / denom;
            // calculate the precision of the result
            improve = (newSum - sum);
            // keeps adding if the improvement is greater than or equal to precision value
            if (Math.abs(improve) >= precision){
                sum += Math.pow(x, i) / denom;
                denom = denom * (i+1);
            }
            // stops adding when the improvement is less than the precision value
            else{
                break;
            }
        }
        return sum;
    }
    
    // function 3
    public static int mirrorNum(int num){
        int mirrored = 0;
        while (num != 0){
            // multiply by 10 to add a digit
            // mod 10 to get right most digit
            mirrored = (mirrored * 10) + (num % 10);
            num /= 10;
        }
        if (num < 0){
            mirrored *= -1;
        }
        return mirrored;
    }

    // function 4
    public static boolean raisedNum(long num){
        boolean result = false;
        for (int x = 2; x < num; x++){
            for (int y = 2; y < num; y++){
                if (Math.pow(x,y) + Math.pow(y,x) == num){
                    result = true;
                    // breaks for loop once an x and a y have been found
                    break;
                }
            }
            // breaks for loop in case there are higher values of x or y that would return true
            if (result == true){
                break;
            }
        }
        return result;
    }

    // function 5
    public static int[][] smallestSubarray(int[][] array, int sum){
        int row = 0;
        int col = 0;
        int endRow = array[0].length;
        int subArrSize = 2;
        while (subArrSize < array.length){
            for (int i = 0; i < array.length; i++){ // moves across top
                for (int j = 0; j < array[i].length; j++){ // moves down
                    
                    for (int k = 0; k < subArrSize; k++){ // x dimention of subarray
                        for (int l = 0; l < subArrSize; l++){ // y dimension of subarray

                        }
                    }
                }
            }
        }
    }

    // function 6
    public static void replaceElement(int[][] array, int elem, int[] newElem){
        if (newElem.length == 1){
            for (int i = 0; i < array.length; i++){
                for (int j = 0; j < array[i].length; j++){
                    if (array[i][j] == elem){
                        array[i][j] = newElem[0];
                    }
                }
            }
        }
        else{
            for (int i = 0; i < array.length; i++){
                int replace = 0;
                // finds number of times elem is found in a subarray
                for (int j = 0; j < array[i].length; j++){
                    if (array[i][j] == elem){
                        replace += 1;
                    }
                }
                // calulates length of new subarray including spaces for newElem items
                int newLen = (array[i].length - 1) + (newElem.length * replace);
                int[] subArray = new int[newLen];
                int shift = 0;
                // populate subArray with array and newElem
                for (int k = 0; k < subArray.length; k++){
                    /*
                    // checks if last element in array
                    if (array[i][k - shift] == array.length - 1){
                        if (array[k][k] != elem){
                            subArray[k] = array[i][k];
                        }
                        else if (array[i][k] == elem){
                            for (int index = 0; index < newElem.length; index++){
                                subArray[k + index] = newElem[index];
                            }
                        }
                    }
                    */
                    if (array[i][k - shift] != elem){
                        subArray[k] = array[i][k - shift];
                    }
                    else if (array[i][k - shift] == elem){
                        for (int index = 0; index < newElem.length; index++){
                            subArray[k + index] = newElem[index];
                            //shift += 1;
                        }
                        k += newElem.length - 1;
                        if (newElem.length > 2){
                            shift += newElem.length - 1;
                        }
                        else{
                            shift += 1;
                        }
                    }
                }
                array[i] = subArray;
                shift = 0;
            }
        }
        /*
        // test
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        return array;
        */
    }
    
    // function 7
    public static int[][] removeDuplicates(int[][] array){
        int[][] tempArray = new int[array.length][array[0].length];
        int prevVal = array[0][0];
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                // skips first item in first subarray
                if (array[i][j] == array[0][0]){
                    tempArray[i][j] = array[0][0];
                    continue;
                }
                // adds item to tempArray if unique item
                else if (array[i][j] != prevVal){
                    tempArray[i][j] = array[i][j];
                    prevVal = array[i][j];
                }
                // skips duplicate items
                else if (array[i][j] == prevVal){
                    continue;
                }
            }
        }
        for (int i = 0; i < tempArray.length; i++){
            int count = 0;
            for (int j = 0; j < tempArray[i].length; j++){
                // counts number of empty items in each sublist
                if (tempArray[i][j] == 0){
                    count += 1;
                }
            }
            // creates subarrary and adds non 0 values in
            int[] tempSubArr = new int[tempArray[i].length - count];
            int shift = 0;
            //for (int index = 0; index < tempSubArr.length; index++){
                for (int k = 0; k < tempArray[i].length; k++){
                    if (tempArray[i][k] == 0){
                        shift += 1;
                        continue;
                    }
                    else{
                        tempSubArr[k - shift] = tempArray[i][k];
                    }
                }
                //break;
            //}
            tempArray[i]= tempSubArr; 
            count = 0;
        }
        int empty = 0;
        int shift = 0;
        // finds empty subarrays
        for (int i = 0; i < tempArray.length; i++){
            if (tempArray[i].length == 0){
                empty += 1;
            }
        }
        // new array removing empty subarrays
        int[][] resultArr = new int[tempArray.length - empty][];
        for (int i = 0; i < tempArray.length; i++){
            if (tempArray[i].length == 0){
                shift += 1;
            }
            else{
                resultArr[i - shift] = tempArray[i];
            }
        }
        
        for (int i = 0; i < resultArr.length; i++){
            for (int j = 0; j < resultArr[i].length; j++){
                System.out.print(resultArr[i][j] + " ");
            }
            System.out.println();

        }
        
        return resultArr;
    }
    
    // function 8
    public static int[] vortex(int[][] array){
        int currRow = 0;
        int currCol = 0;
        int endRow = array.length;
        int endCol = array[0].length;
        int x = 0;
        int topRow = 0;
        int leftCol = 0;
        int arraySize = array[0].length * array.length;
        int[] newArray = new int[arraySize];
        while(x < newArray.length){
            // adds first row
            while (currCol < endCol){
                newArray[x] = array[currRow][currCol];
                currCol += 1;
                x += 1;
            }
            if (currCol >= endCol){
                currCol -= 1;
                currRow += 1;
                topRow += 1;
            }
            // adds last column
            while (currRow < endRow){
                newArray[x] = array[currRow][currCol];
                currRow += 1;
                x += 1;
            }
            if (currRow >= endRow){
                currCol -= 1;
                currRow -= 1;
                endCol -= 1;
            }
            // adds bottom row
            while (currCol >= leftCol){
                newArray[x] = array[currRow][currCol];
                currCol -= 1;
                x += 1;
            }
            if (currCol < leftCol){
                currCol += 1;
                currRow -= 1;
                endRow -= 1;
            }
            // adds remaining first column
            while (currRow >= topRow){
                newArray[x] = array[currRow][currCol];
                currRow -= 1;
                x += 1;
            }
            if (currRow < topRow){
                currCol += 1;
                currRow += 1;
                leftCol += 1;
            }
        }
        return newArray;
    }
    
}