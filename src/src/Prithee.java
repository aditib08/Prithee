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
        String[] words = sonnet.split("[,;\\s]+");
        int correct = 0; //correct guesses
        int incorrect = 0; //incorrect guesses

        while (correct + incorrect < 3) {

            //Get the correct word and the random word given to user
            int randomIndex = (int) (Math.random() * words.length - 1);
            String nextWord = words[randomIndex + 1];
            String randomWord = words[randomIndex];

            //Create underscores for the hidden word
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nextWord.length(); i++) {
                sb.append("_");
            }
            String underscores = sb.toString();

            //Print sonnet up until the random word
            int index = sonnet.indexOf(randomWord);
            System.out.print(sonnet.substring(0, index));
            System.out.println(randomWord + " " + underscores);

            String guess = scan.nextLine();

            if (checkGuess(guess, nextWord)) {
                System.out.println("Correct!");
                correct++;
            } else {
                System.out.println("Incorrect!");
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