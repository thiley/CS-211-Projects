import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
/**
 * A utility class that provides two methods for generating a Field
 * @author thiley
 *
 */
public class FieldGenerator {
	/**
	 * This method scans a given file and creates a Field based on the data in the text file
	 * If the element can be parsed into an integer, that means it is a numerical value and can be made into a passage
	 * If not, the catch statement will make the element into an obstacle
	 * @param filename a text file
	 * @return a Field 
	 */
	public static Field<Block> loadDataFromFile(String filename) {
		Field<Block> field = new Field<>(0,0);
		try {
			// get number of columns for the field
			Scanner colScanner = new Scanner(new File(filename));
			int colNum = colScanner.nextLine().split(" ").length;
			colScanner.close();
			
			// get number of rows for the field
			Scanner rowScanner = new Scanner(new File(filename));
			int rowNum = 0;
			while (rowScanner.hasNextLine()) {
				rowNum++;
				rowScanner.nextLine();
			}
			rowScanner.close();
			
			field = new Field<>(rowNum, colNum);
			
			// checks if the element is an integer (passage) or not (obstacle)
			Scanner scnr = new Scanner(new File(filename));
			for (int i = 0; i < rowNum; i++) {
				for (int j = 0; j < colNum; j++) {
					String elem = scnr.next();
					try {
						field.setElement(i, j, new Passage(Integer.parseInt(elem)));
					}
					catch(Exception e) {
						field.setElement(i, j, new Obstacle(elem));
					}
				}
			}
			scnr.close();
			return field;
		}
		catch(FileNotFoundException e) {
			System.err.println("File not found");
		}
		return field;
	}
	
	/**
	 * This method generates a field, not from a text file, but from generating passages with random point values
	 * The field is also generated with randomly places objects
	 * @param h height of the field
	 * @param w width of the field
	 * @param l lowest random number of points a passage can have
	 * @param m greatest random number of points a passage can have
	 * @param n number of obstacle objects in the field
	 * @return a Field
	 */
	public static Field<Block> randomIntegers(int h, int w, int l, int m, int n){
		Field<Block> field = new Field<>(h, w);
		Random random = new Random();
		// first populates the field with passages
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (field.getElement(i, j) == null) {
					field.setElement(i, j, new Passage(random.nextInt(m - l + 1) + l));
				}
			}
		}
		// then generates random coordinates to be replaced by obstacles
		while (n > 0) {
			int i = random.nextInt(h);
			int j = random.nextInt(w);
			if (!(field.getElement(i, j) instanceof Obstacle)) {
				field.setElement(i, j, new Obstacle("-"));
				n--;
			}
			else {
				continue;
			}
		}
		return field;
	}
}
