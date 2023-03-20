import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> myList = Arrays.asList("A", "B", "C", "D");
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);

        // Print the welcome message
        System.out.println("Welcome to the random word generator");

        // Start an infinite loop
        while (true) {
            // Print the prompt message
            System.out.println("Press Enter to generate a new random word or type 'quit' to exit.");

            // Read user input
            String input = scanner.nextLine();

            // Check if the user typed 'quit' to exit the loop and the program
            if (input.equalsIgnoreCase("quit")) {
                break;
            }

            // Generate a random integer between 0 (inclusive) and the size of the list (exclusive)
            int randomItem = r.nextInt(myList.size());

            // Get the element from the list at the index of the randomly generated integer
            String randomElement = myList.get(randomItem);

            // Print the random element to the console
            System.out.println("Random word: " + randomElement);
        }

        // Close the scanner
        scanner.close();

        System.out.println("Goodbye!");
    }
}
