package main.java.kyu6.cw30;

/*
A child is playing with a ball on the nth floor of a tall building. The height of this floor, h, is known.
He drops the ball out of the window. The ball bounces (for example), to two-thirds of its height (a bounce of 0.66).
His mother looks out of a window 1.5 meters from the ground.
How many times will the mother see the ball pass in front of her window (including when it's falling and bouncing?

Three conditions must be met for a valid experiment:
Float parameter "h" in meters must be greater than 0
Float parameter "bounce" must be greater than 0 and less than 1
Float parameter "window" must be less than h.
If all three conditions above are fulfilled, return a positive integer, otherwise return -1.

Note:
The ball can only be seen if the height of the rebounding ball is strictly greater than the window parameter.

Examples:
- h = 3, bounce = 0.66, window = 1.5, result is 3
- h = 3, bounce = 1, window = 1.5, result is -1
(Condition 2) not fulfilled).
 */

public class BouncingBalls {

    public static void main(String[] args) {
        System.out.println(bouncingBall(30.0, 0.66, 1.5));
    }

    public static int myBouncingBall(double h, double bounce, double window) {
        if (h<0 || bounce<0 || bounce>=1 || window>h) return -1;
        int steps = (int) Math.ceil(Math.log(window/h)/Math.log(bounce));
        return steps*2-1;
    }

    public static int bouncingBall(double h, double bounce, double window) {
        if ((h <= 0) || (window >= h) || (bounce <= 0) || (bounce >= 1))
            return -1;
        int seen = -1;
        while (h > window) {
            seen += 2;
            h = h * bounce;
        }
        return seen;

    }

}
