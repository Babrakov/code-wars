package test.java.cw15;

import main.java.cw15.Mumbling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MiddleExampleTests {
    @Test
    public void accumTest() {
        assertEquals("Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu", Mumbling.accum("ZpglnRxqenU"));
    }

}
