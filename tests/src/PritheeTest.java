package src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PritheeTest {

    @Test
    void performNextLine() {
        Prithee p1 = new Prithee("Hello world");
        assertTrue(p1.checkGuess("world", "world"), "Exact matching words should return true");
    }

    @Test
    void preformDifferentWords() {
        Prithee p1 = new Prithee("Hello world");
        assertFalse(p1.checkGuess("hello", "world"), "Different words should return false");
    }

    @Test
    void preformInvalidWord() {
        Prithee p1 = new Prithee("Hello world");
        assertFalse(p1.checkGuess(null, "world"), "Invalid word should return false");
        }

    }


