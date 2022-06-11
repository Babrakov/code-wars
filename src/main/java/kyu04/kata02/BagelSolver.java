package main.java.kyu04.kata02;

/*
Here's a seemingly simple challenge. We're giving you a class called bagel, exactly as it appears below.
All it really does is return an int, specifically 3.

public class Bagel {
    public final int getValue() {
        return 3;
    }
}
The catch? For the solution, we're testing that the result is equal to 4. But as a little hint,
the solution to this Kata is (almost) exactly the same as the example test cases.
 */

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class BagelSolver {
    public static Bagel getBagel() {
        try {
            Field field = Boolean.class.getField("TRUE");
            Field modifiers = Field.class.getDeclaredField("modifiers");
            modifiers.setAccessible(true);
            modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);
            field.setAccessible(true);
            field.set(null, false);
        } catch (Exception e){
            System.out.println(e);
        }
        Bagel bagel = new Bagel();
        return bagel;
    }

}




