import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/** 
* Advent of Code 2020 - Puzzle 1
*
* Small little program that compares the values in a text file to
* find two values that equal 2020. Then print the product of those two numbers.
*
* @author AyameU
* @version 1.0
*/
public class Puzzle1 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input.txt");
        Scanner reader = new Scanner(file);
        ArrayList<Integer> values = new ArrayList<Integer>();

        // Reads each line in the file and adds that line to the ArrayList.
        while(reader.hasNextLine()) {
            values.add(Integer.parseInt(reader.next()));
        }

        // Used to track if the right two values have been found.
        boolean is2020 = false;

        for(int i = 0; i < values.size(); i++) {
            // Number to be compared against. Incremented every loop.
            int num = values.get(i);
            
            for(int j = 1; j < values.size(); j++) {
                // Checks if the two compared values equal 2020.
                // If true, print product of two values and break inner loop.
                if(num + values.get(j) == 2020) {
                    System.out.println("The values are " + num + " and " + values.get(j));
                    System.out.println(num * values.get(j));

                    is2020 = true;
                    break;
                }
            }

            // Terminates the outer break if the compared values equal 2020.
            if(is2020) {
                break;
            }
        }
    }
}