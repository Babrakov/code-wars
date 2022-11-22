package test.java.kyu04.kata02;

import main.java.kyu4.kata02.Bagel;
import main.java.kyu4.kata02.BagelSolver;
import org.junit.Test;

public class BagelTest {

    @Test
    public void testBagel() {
        Bagel bagel = BagelSolver.getBagel();

        org.junit.Assert.assertEquals(
                bagel.getValue() == 4,
                java.lang.Boolean.TRUE
        );
    }
}
