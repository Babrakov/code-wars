package test.java.kyu7.cw17;

import main.java.kyu7.cw17.SumOfNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SumTest {
    SumOfNumbers s = new SumOfNumbers();

    @Test
    public void Test1()
    {
        assertEquals(-1, s.GetSum(0, -1));
        assertEquals(1, s.GetSum(0, 1));
    }
}
