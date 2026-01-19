package main;

import java.util.Scanner;

public class Prithee {

    String sonnet;

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

    public void performNextLine() {
        Scanner scan = new Scanner(System.in);
        String[] words = sonnet.split("[,\\s]+");
        int correct = 0;
        int incorrect = 0;

        while (correct + incorrect < 3) {

            int randomIndex = (int) (Math.random() * words.length - 1);
            String nextWord = words[randomIndex + 1];
            String randomWord = words[randomIndex];

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

    public boolean checkGuess(String userWord, String correctWord) {
        return userWord.equalsIgnoreCase(correctWord);
    }

}