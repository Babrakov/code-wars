package test.java.kyu7.kata13;

import main.java.kyu7.kata13.JadenCasingStrings;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class JadenCasingStringsTest {
    JadenCasingStrings jadenCase = new JadenCasingStrings();

    @Test
    public void test() {
        assertEquals("Most Trees Are Blue", jadenCase.toJadenCase("most trees are blue"));
    }

    @Test
    public void testNullArg() {
        assertNull( jadenCase.toJadenCase(null));
    }

    @Test
    public void testEmptyArg() {
        assertNull(jadenCase.toJadenCase(""));
    }
}
