import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        // Create the main window
        JFrame frame = new JFrame("Random Word Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create the main panel
        JPanel panel = new JPanel();
        frame.add(panel);

        // Create the components
        JLabel welcomeLabel = new JLabel("Welcome to the random word generator!");
        JButton generateButton = new JButton("Generate a random word");
        JButton addButton = new JButton("Add a new word");
        JButton removeButton = new JButton("Remove a word");
        JButton showAllButton = new JButton("Show all words");
        JTextArea outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add the components to the panel
        panel.add(welcomeLabel);
        panel.add(generateButton);
        panel.add(addButton);
        panel.add(removeButton);
        panel.add(showAllButton);
        panel.add(scrollPane);

        // Set the layout for the panel
        GroupLayout layout = new GroupLayout(panel);
        panel.setLayout(layout);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(welcomeLabel)
                        .addComponent(generateButton)
                        .addComponent(addButton)
                        .addComponent(removeButton)
                        .addComponent(showAllButton)
                        .addComponent(scrollPane)
        );
        layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(welcomeLabel)
                        .addComponent(generateButton)
                        .addComponent(addButton)
                        .addComponent(removeButton)
                        .addComponent(showAllButton)
                        .addComponent(scrollPane)
        );

        // Initialize the list and random generator
        List<String> myList = new ArrayList<>();
        myList.add("A");
        myList.add("B");
        myList.add("C");
        myList.add("D");
        Random r = new Random();

        // Add action listeners for the buttons
        generateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomItem = r.nextInt(myList.size());
                String randomElement = myList.get(randomItem);
                outputArea.append("Random word: " + randomElement + "\n");
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newWord = JOptionPane.showInputDialog("Enter the new word:");
                if (newWord != null && !newWord.trim().isEmpty()) {
                    myList.add(newWord);
                    outputArea.append("Word added: " + newWord + "\n");
                }
            }
        });

        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String wordToRemove = JOptionPane.showInputDialog("Enter the word to remove:");
                if (wordToRemove != null) {
                    if (myList.remove(wordToRemove)) {
                        outputArea.append("Word removed: " + wordToRemove + "\n");
                    } else {
                        outputArea.append("Word not found: " + wordToRemove + "\n");
                    }
                }
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                outputArea.append("All words:\n");
                for (String word                 : myList) {
                    outputArea.append(word + "\n");
                }
            }
        });

        // Show the main window
        frame.setVisible(true);
    }
}

