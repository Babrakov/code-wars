package test.java.kyu7.cw19;

import main.java.kyu7.cw19.SumOfAngles;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AnglesSumTest {
    @Test
    public void sampleTests() {
        assertEquals(180, SumOfAngles.sumOfAngles(3));
        assertEquals(360, SumOfAngles.sumOfAngles(4));
    }
}
