package src;

import java.util.Scanner;

public class Prithee {

    //Sonnet text stored as a single String
    String sonnet;

    //Constructor
    public Prithee(String sonnet) {
        this.sonnet = sonnet;
    }

    @Override
    public String toString() {
        return "Prithee{" +
                "sonnet='" + sonnet + '\'' +
                '}';
    }

    public String getSonnet() {
        return sonnet;
    }

    public void setSonnet(String sonnet) {
        this.sonnet = sonnet;
    }

    //Starts the game for user
    public void performNextLine() {
        Scanner scan = new Scanner(System.in);

        //Split the sonnet into an array of words at each comma and space
        sonnet = sonnet.replace("'", "");
        String[] words = sonnet.split("[,;.\\s]+");

        int correct = 0; //correct guesses
        int incorrect = 0; //incorrect guesses

        while (correct + incorrect < 3) {

            //Get the correct word and the random word given to user
            int randomIndex = (int) (Math.random() * words.length - 1);
            String nextWord = words[randomIndex + 1];
            String randomWord = words[randomIndex];

            // Print sonnet up until the random word
            int index = sonnet.indexOf(randomWord + " " + nextWord);
            if (index == -1) {
                index = sonnet.indexOf(randomWord);
            }
            System.out.print(sonnet.substring(0, index));
            System.out.print(randomWord);

            // Print underscores for the rest of the sonnet
            for (int i = index + randomWord.length(); i < sonnet.length(); i++) {
                char c = sonnet.charAt(i);

                if (c == '\n' || c == ' ' || c == '.' || c == ',' || c == ';') {
                    System.out.print(c);
                } else {
                    System.out.print("_");
                }
            }

            System.out.println();

            //Prompt the user for the next word and indicates whether it was correct or incorrect
            System.out.print("\n" + "Enter a guess for the next word: ");
            String guess = scan.nextLine();

            if (checkGuess(guess, nextWord)) {
                System.out.println("Correct!" + "\n");
                correct++;
            } else {
                System.out.println("Incorrect!" + "\n");
                incorrect++;
            }
        }
    }

    //Checks if user guess is correct
    public boolean checkGuess(String userWord, String correctWord) {
        if (userWord == null || correctWord == null) {
            return false;
        }

        return userWord.equalsIgnoreCase(correctWord);
    }

}