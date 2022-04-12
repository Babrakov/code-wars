package test.java.kyu7.kata04;

import main.java.kyu7.kata04.GetMiddleCharacter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiddleExampleTests {
    @Test
    public void evenTests() {
        assertEquals("es", GetMiddleCharacter.getMiddle("test"));
        assertEquals("dd", GetMiddleCharacter.getMiddle("middle"));
    }

    @Test
    public void oddTests() {
        assertEquals("t", GetMiddleCharacter.getMiddle("testing"));
        assertEquals("A", GetMiddleCharacter.getMiddle("A"));
    }
}
