import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

/** 
* Advent of Code 2020 - Puzzle 1 Part 2
*
* Small little program that compares the values in a text file to
* find three values that equal 2020. Then prints the product of the numbers.
*
* @author AyameU
* @version 1.0
*/
public class Puzzle1Part2 {

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

        // First number to be compared against. Incremented every loop.
        for(int i = 0; i < values.size(); i++) {
            
            // Second number to be compared against.
            for(int j = 1; j < values.size(); j++) {
                
                // Third number to be compared against.
                for(int k = 2; k < values.size(); k++) {

                    // Checks if the three compared values equal 2020.
                    // If true, print product of the values and break inner loop.
                    if(values.get(i) + values.get(j) + values.get(k) == 2020) {
                        System.out.println("The values are " + values.get(i) + ", " + values.get(j) + " and " + values.get(k));
                        System.out.println(values.get(i) * values.get(j) * values.get(k));

                        is2020 = true;
                        break;
                    }
                }
            }

            // Terminates the outer loop if the compared values equal 2020.
            if(is2020) {
                break;
            }
        }
    }
}