package main.java.kyu7.cw19;

/*
Find the total sum of internal angles (in degrees) in an n-sided simple polygon. N will be greater than 2.
 */

public class SumOfAngles {

    public static int sumOfAngles(int n) {
        return 180 * (n - 2);
    }
}
