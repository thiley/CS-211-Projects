import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
/**
 * This class contains the main method that tests the application
 * @author thiley
 *
 */
public class Game
{
    /**
    static nested class serving as a vehicle to return two values from a method
    */
    public static class TwoValues
    {
        public int startingColumn;
        public int totalPoints;
    }

    public static void main(String args[]) throws FileNotFoundException
    {
        /**
        command line arguments validation
        */
        if (args.length != 1)
        {
            System.err.println("Usage: java " + Game.class.getName() + " <filename>");
            return;
        }

        /**
        example of loading data from a file
        */
        Field<Block> field = FieldGenerator.loadDataFromFile(args[0]);

        /**
        example of generating a random Field
        */
//        Field<Block> field = FieldGenerator.randomIntegers(8,11,0,9,10);
//        Field<Block> field = FieldGenerator.randomIntegers(5,7,0,9,7);
        
        /**
        print the whole field
        */
        System.out.println("-----Print field-----");
        System.out.println(field);

        /**
        Example of running a foreach loop
        This will invoke the default iterator (the one using the anonymous inner class)
        */
//        System.out.println("-----Default Iterator-----");
//        for(Block b:field)
//            System.out.print(b + " ");
//        	System.out.println("");

        /**
        Example of running a while loop
        This will invoke the overloaded iterator (the one using the FieldIterator class)
        */
        System.out.println("-----Overloaded Iterator-----");
        Iterator<Block> it = field.iterator("Passage");
//      Iterator<Block> it = field.iterator("Obstacle"); // same thing for Obstacle objects
        while(it.hasNext())
        	System.out.print(it.next() + " ");
        	System.out.println("");

        /**
        find the best starting point and print the results
        */
        System.out.println("-----Best Starting Point-----");
        TwoValues br = bestStartingPoint(field);
        System.out.println("Best starting point is in column " + br.startingColumn + " and the total points collected from this route is " + br.totalPoints);

        /**
        find the best route and print it
        */
        System.out.println("-----Best Route-----");
        ArrayList<Block> al = bestRoute(field, br.startingColumn);
        for (Block b : al)
            System.out.println(b);
    }
    
    /**
     * This method uses recursion to find the best column to start at in the first row in order to collect the most amount of points while crossing the field
     * @param board a field with blocks of passages and obstacles
     * @return a TwoValues object with the starting column number and the total points earned from that path
     */
    public static TwoValues bestStartingPoint(Field<Block> board) {
    	TwoValues twoValues = new TwoValues();
    	int startingColumn = 0;
        int maxPoints = 0;
        // loops through first row of the field
        for (int i = 0; i < board.getWidth(); i++) {
        	int tempPoints = bspHelper(board, 0, i);
        	// finds which column yields the most points and sums up the points
        	if (tempPoints > maxPoints) {
        		maxPoints = tempPoints;
        		startingColumn = i;
        	}
        }
    	twoValues.startingColumn = startingColumn;
    	twoValues.totalPoints = maxPoints;
    	return twoValues;
    }
    
    /**
     * This is a helper method for the bestStartingPoint method
     * This method stores the values of the possible left, middle, and right blocks that can be crosses
     * Then this method compares these values and finds the block with the greatest number of points, and sums up these points
     * @param board a Field
     * @param rowNum the row number on the field
     * @param colNum the column number on the field
     * @return the block with the highest number of points
     */
    private static int bspHelper(Field<Block> board, int rowNum, int colNum) {
    	int leftVal = 0;
    	int middleVal = 0;
    	int rightVal = 0;
    	
    	int h = board.getHeight();
    	int w = board.getWidth();
    	
    	if (board.getElement(rowNum, colNum) instanceof Obstacle)
    		return 0;
    	// if we're in the last row of the field
    	if (rowNum == board.getHeight() - 1)
    		return board.getElement(rowNum, colNum).getValue();
    	// calculates the values of the possible passage options
    	// if in the leftmost column, there are only two next move options: down or right
    	if (colNum != 0) {
    		Block leftPos = board.getElement(rowNum + 1, colNum - 1);
    		if (rowNum + 1 < h && colNum < w && leftPos instanceof Passage)
        		leftVal = board.getElement(rowNum, colNum).getValue() + bspHelper(board, rowNum + 1, colNum - 1);
    	}
    	// if in the rightmost column, there are only two next move options: down or left
    	if (colNum != w - 1) {
    		Block rightPos = board.getElement(rowNum + 1, colNum + 1);
    		if (rowNum + 1 < h && colNum < w && rightPos instanceof Passage)
        		rightVal = board.getElement(rowNum, colNum).getValue() + bspHelper(board, rowNum + 1, colNum + 1);
    	}
    	Block middlePos = board.getElement(rowNum + 1, colNum);
    	if (rowNum + 1 < h && colNum < w && middlePos instanceof Passage)
    		middleVal = board.getElement(rowNum, colNum).getValue() + bspHelper(board, rowNum + 1, colNum);
    	// finds and returns the passage that will give the most points
    	if (leftVal >= middleVal && leftVal >= rightVal) return leftVal;
    	else if (middleVal >= leftVal && middleVal >= rightVal) return middleVal;
    	else return rightVal;
    }
    
    /**
     * This method returns the list of Blocks that form the best route from one endline to the other one given a starting point
     * @param board a Field
     * @param col the column number
     * @return a list of blocks that make up the route taken from start to finish
     */
    public static ArrayList<Block> bestRoute(Field<Block> board, int col){
    	ArrayList<Block> bestRoute = new ArrayList<Block>();
    	// call helper method to do calculations for the next move
    	brHelper(board, 0, col, bestRoute);
    	return bestRoute;
    }
    
    /**
     * This is the helper method for the bestRoute method
     * This method first starts by adding the current element to the list
     * Then uses bspHelper to find the starting point and the values of each passage option
     * Finally this method compares the values and changes the column number for the next pass accordingly
     * @param board a Field
     * @param rowNum the row number on the field
     * @param colNum the column number on the field
     * @param route a list of the blocks crossed on the field
     */
    private static void brHelper(Field<Block> board, int rowNum, int colNum, ArrayList<Block> route) {
    	// add current block to the route
    	route.add(board.getElement(rowNum, colNum));
    	// base case: if we're in the last row of the field
    	if (rowNum == board.getHeight() - 1) return;
    	
    	int leftVal = 0;
    	int middleVal = 0;
    	int rightVal = 0;
    	
    	// calculates the values of the possible passage options
    	if (colNum != 0) {
    		Block leftPos = board.getElement(rowNum + 1, colNum - 1);
    		if (colNum < board.getWidth() && leftPos instanceof Passage)
        		leftVal = board.getElement(rowNum, colNum).getValue() + bspHelper(board, rowNum + 1, colNum - 1);
    	}
    	if (colNum != board.getWidth() - 1) {
    		Block rightPos = board.getElement(rowNum + 1, colNum + 1);
    		if (colNum < board.getWidth() && rightPos instanceof Passage)
        		rightVal = board.getElement(rowNum, colNum).getValue() + bspHelper(board, rowNum + 1, colNum + 1);
    	}
    	Block middlePos = board.getElement(rowNum + 1, colNum);
    	if (colNum < board.getWidth() && middlePos instanceof Passage)
    		middleVal = board.getElement(rowNum, colNum).getValue() + bspHelper(board, rowNum + 1, colNum);
    	
    	// finds the path with the highest number of points and changes the column accordingly
    	int nextCol = colNum;
    	if (leftVal >= middleVal && leftVal >= rightVal) {
    		nextCol--;
    	}
    	else if (rightVal >= leftVal && rightVal >= middleVal) {
    		nextCol++;
    	}
    	brHelper(board, rowNum + 1, nextCol, route);
    }

}