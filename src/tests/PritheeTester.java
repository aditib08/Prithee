package tests;

import main.Prithee;

public class PritheeTester {
    public static void main(String[] args) {
        Prithee p1 = new Prithee("Hello world");

        //Test 1
        if (p1.checkGuess("world", "world")) {
            System.out.println("Test 1 Passed!");
        } else {
            System.out.println("Test 1 Failed!");
        }

        //Test 2
        if (p1.checkGuess("WoRLD", "world")) {
            System.out.println("Test 2 Passed!");
        } else {
            System.out.println("Test 2 Failed!");
        }

        //Test 3
        if (!p1.checkGuess("hello", "world")) {
            System.out.println("Test 3 Passed!");
        } else {
            System.out.println("Test 3 Failed!");
        }
    }
}
