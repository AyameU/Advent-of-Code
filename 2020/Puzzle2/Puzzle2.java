import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;

public class Puzzle2 {

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

            // Get the min digits
            int min = Integer.parseInt(line.substring(0, line.indexOf("-")));
            //System.out.println(min);

            // Get the max digits
            int max = Integer.parseInt(line.substring(line.indexOf("-") + 1, line.indexOf(" ")));
            //System.out.println(max);

            // Using these pieces figure out solution.
            // Count instances of the key character.
            int numOfLetter = 0;

            // Loop through each character in the password.
            for(int i = 0; i < passwordChars.length; i++) {
                if(passwordChars[i] == character) {
                    numOfLetter++;
                }
            }

            // Check numOfLetters against min/max values
            // If between or equal to those values, add to array
            if(numOfLetter >= min && numOfLetter <= max) {
                valid.add(password);
            }
        }

        // Print number of valid passwords
        System.out.println("Valid passwords: " + valid.size());
    }
}