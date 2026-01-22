package main;

import java.util.Scanner;

public class Prithee {

    //Sonnet text stored as a single String
    String sonnet;

    //Constructor
    public Prithee(String sonnet) {
        this.sonnet = sonnet;
    }

    public static void main(String[] args) {
        Prithee p1 = new Prithee("Two households, both alike in dignity,\n" +
                "In fair Verona, where we lay our scene,\n" +
                "From ancient grudge break to new mutiny,\n" +
                "Where civil blood makes civil hands unclean.\n" +
                "From forth the fatal loins of these two foes\n" +
                "A pair of star-cross’d lovers take their life;\n" +
                "Whose misadventured piteous overthrows\n" +
                "Do with their death bury their parents’ strife.\n" +
                "The fearful passage of their death-mark’d love,\n" +
                "And the continuance of their parents’ rage,\n" +
                "Which, but their children’s end, nought could remove,\n" +
                "Is now the two hours’ traffic of our stage;\n" +
                "The which if you with patient ears attend,\n" +
                "What here shall miss, our toil shall strive to mend.\n");

        p1.performNextLine();
    }

    //Starts the game for user
    public void performNextLine() {
        Scanner scan = new Scanner(System.in);

        //Split the sonnet into an array of words at each comma and space
        String[] words = sonnet.split("[,\\s]+");
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
        return userWord.equalsIgnoreCase(correctWord);
    }

}