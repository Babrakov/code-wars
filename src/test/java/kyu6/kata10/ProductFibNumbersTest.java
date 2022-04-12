package test.java.kyu6.kata10;

import main.java.kyu6.kata10.ProductFibNumbers;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductFibNumbersTest {

    @Test
    public void test1() {
        long[] r = new long[] {55, 89, 1};
        assertArrayEquals(r, ProductFibNumbers.productFib(4895));
    }
    @Test
    public void test2() {
        long[] r = new long[] {89, 144, 0};
        assertArrayEquals(r, ProductFibNumbers.productFib(5895));
    }

}
