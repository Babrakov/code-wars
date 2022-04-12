package main.java.kyu7.cw22;

public class Factorial {

    public int myFactorial(int n) {
        if (n==0) return 1;
        if (n<0 || n>12) throw new IllegalArgumentException();
        return ((n > 1) ? n * factorial(n - 1) : 1);
    }

    public int factorial(int n) {
        if(n < 0 || n > 12) throw new IllegalArgumentException("Useless fuffery!");
        return n <= 1 ? 1 : n * factorial(n - 1);
    }

}
