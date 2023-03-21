import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<String> myList = new ArrayList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        Random r = new Random();
        Scanner scanner = new Scanner(System.in);

        // Print the welcome message
        System.out.println("Welcome to the random word generator");

        // Start an infinite loop
        while (true) {
            // Print the menu
            System.out.println("\nMenu:");
            System.out.println("1. Generate a random word");
            System.out.println("2. Add a new word");
            System.out.println("3. Remove a word");
            System.out.println("4. Show all words");
            System.out.println("5. Quit");
            System.out.print("Enter your choice: ");

            // Read user input
            String input = scanner.nextLine();

            // If the user chose to generate a random word
            if (input.equals("1")) {
                // Generate a random integer between 0 (inclusive) and the size of the list (exclusive)
                int randomItem = r.nextInt(myList.size());

                // Get the element from the list at the index of the randomly generated integer
                String randomElement = myList.get(randomItem);

                // Print the random element to the console
                System.out.println("Random word: " + randomElement);
            }
            // If the user chose to add a new word
            else if (input.equals("2")) {
                System.out.print("Enter the new word: ");
                String newWord = scanner.nextLine();
                myList.add(newWord);
                System.out.println("Word added: " + newWord);
            }
            // If the user chose to remove a word
            else if (input.equals("3")) {
                System.out.print("Enter the word to remove: ");
                String wordToRemove = scanner.nextLine();
                if (myList.remove(wordToRemove)) {
                    System.out.println("Word removed: " + wordToRemove);
                } else {
                    System.out.println("Word not found: " + wordToRemove);
                }
            }
            else if (input.equals("4")) {
                System.out.println("All words:" );
                for(String word : myList){
                    System.out.println(word);
                }
            }
            // If the user chose to quit
            else if (input.equals("5")) {
                break;
            }
            // If the user entered an invalid choice
            else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        // Close the scanner
        scanner.close();

        System.out.println("Goodbye!");
    }
}
