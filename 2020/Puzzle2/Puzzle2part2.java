import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Puzzle2part2 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("input.txt");
        Scanner reader = new Scanner(file);

        // Used to store valid passwords
        ArrayList<String> valid = new ArrayList<String>();

        // Loop through each line in the file. Break into substrings
        while(reader.hasNextLine()) {
            // Get whole line, store as a String.
            String line = reader.nextLine();
            //System.out.println(line);

            // Get the password as a substring. Turn password into char array
            String password = line.substring(line.indexOf(":") + 2);
            char[] passwordChars = password.toCharArray();
            //System.out.println(password);

            // Get the character we will be counting.
            char character = line.charAt(line.indexOf(":") - 1);
            //System.out.println(character);

            // Get the min digit
            int min = Integer.parseInt(line.substring(0, line.indexOf("-")));
            //System.out.println(min);

            // Get the max digit
            int max = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(" ")));
            //System.out.println(max);

            // Check value of index of min (- 1) and max (- 1)
            // If min index equals character and max index does not, it is valid
            // If min index does not equal character and max index does, it is valid
            if(passwordChars[min - 1] == character && passwordChars[max - 1] != character) {
                valid.add(password);
            }
            else if(passwordChars[min - 1] != character && passwordChars[max - 1] == character) {
                valid.add(password);
            }
        }

        // Print number of valid passwords
        System.out.println("Valid passwords: " + valid.size());
    }
}