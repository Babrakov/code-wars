package test.java.kyu6.cw33;

import main.java.kyu6.cw33.ValidBraces;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidBracesTest {

    private ValidBraces checker = new ValidBraces();

    @Test
    public void testValid() {
        assertEquals(true, checker.isValid("([{}])"));
    }

    @Test
    public void testInvalid() {
        assertEquals(false, checker.isValid("())({}}{()][]["));
    }

    @Test
    public void testSimm() {
        assertEquals(true, checker.isValid("{}[]"));
    }

}
