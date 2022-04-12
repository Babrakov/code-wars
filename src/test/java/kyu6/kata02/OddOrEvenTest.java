package test.java.kyu6.cw27;

import main.java.kyu6.cw27.OddOrEven;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OddOrEvenTest {

    @Test
    public void exampleTest() {
        assertEquals("odd", OddOrEven.oddOrEven(new int[] {2, 5, 34, 6}));
    }
}
