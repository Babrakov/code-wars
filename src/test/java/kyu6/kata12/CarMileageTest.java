package test.java.kyu6.kata12;

import main.java.kyu6.kata12.CarMileage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarMileageTest {

    @Test
    public void testTooSmall() {
        assertEquals(0, CarMileage.isInteresting(3, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostAwesome() {
        assertEquals(1, CarMileage.isInteresting(1336, new int[]{1337, 256}));
    }

    @Test
    public void testAwesome() {
        assertEquals(2, CarMileage.isInteresting(1337, new int[]{1337, 256}));
    }

    @Test
    public void testFarNotInteresting() {
        assertEquals(0, CarMileage.isInteresting(11208, new int[]{1337, 256}));
    }

    @Test
    public void testAlmostInteresting() {
        assertEquals(1, CarMileage.isInteresting(11209, new int[]{1337, 256}));
    }

    @Test
    public void testInteresting() {
        assertEquals(2, CarMileage.isInteresting(11211, new int[]{1337, 256}));
    }

    @Test
    public void testSameDigits() {
        assertEquals(2, CarMileage.isInteresting(4444, new int[]{1337, 256}));
    }

    @Test
    public void testZeroes() {
        assertEquals(1, CarMileage.isInteresting(4998, new int[]{1337, 256}));
    }

    @Test
    public void testUpcomingBigNumbers () {
        assertEquals(1, CarMileage.isInteresting(999999998, new int[]{1337, 256}));
    }

    @Test
    public void testSequentalDigits () {
        assertEquals(2, CarMileage.isInteresting(567890, new int[]{1337, 256}));
    }

    @Test
    public void testReverseSequentalDigits () {
        assertEquals(0, CarMileage.isInteresting(97, new int[]{1337, 256}));
    }
}
