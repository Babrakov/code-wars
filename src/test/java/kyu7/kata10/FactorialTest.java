package test.java.kyu7.kata10;

import main.java.kyu7.kata10.Factorial;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FactorialTest {

    private Factorial fact;

    @Before
    public void initFactorial() {
        fact = new Factorial();
    }

    @After
    public void afterFactorial() {
        fact = null;
    }

    @Test
    public void test_factorial0() {
        fact = new Factorial();
        assertEquals(1, fact.factorial(0));
        fact = null;
    }

    @Test
    public void test_factorial3() {
        fact = new Factorial();
        assertEquals(6, fact.factorial(3));
        fact = null;
    }

    @Test
    public void test_factorial5() {
        fact = new Factorial();
        assertEquals(120, fact.factorial(5));
        fact = null;
    }

}
