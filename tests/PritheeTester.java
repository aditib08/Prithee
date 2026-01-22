package tests;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PritheeTester {

    @Test
    void checkGuessExactMatch() {
        Prithee p1 = new Prithee("Hello world");
        assertTrue(
                p1.checkGuess("world", "world"),
                "Exact matching words should return true"
        );
    }

    @Test
    void checkGuessIgnoresCase() {
        Prithee p1 = new Prithee("Hello world");
        assertTrue(
                p1.checkGuess("WoRLD", "world"),
                "checkGuess should ignore letter case"
        );
    }

    @Test
    void checkGuessDifferentWords() {
        Prithee p1 = new Prithee("Hello world");
        assertFalse(
                p1.checkGuess("hello", "world"),
                "Different words should return false"
        );
    }

    @Test
    void checkGuessInvalidWord() {
        Prithee p1 = new Prithee("Hello world");
        assertFalse(p1.checkGuess(null, "world"), "Invalid word should return false");
    }
}

