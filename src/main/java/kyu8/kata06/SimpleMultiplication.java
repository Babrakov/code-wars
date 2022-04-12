package main.java.kyu8.kata06;

public class SimpleMultiplication {

    public static void main(String[] args) {
        System.out.println(simpleMultiplication(1));
        System.out.println(simpleMultiplication(2));
        System.out.println(simpleMultiplication(3));
        System.out.println(simpleMultiplication(21));
        System.out.println(simpleMultiplication(23));
    }

    public static int mySimpleMultiplication(int n) {
        return ((n ^ 1) == n + 1) ? n * 8 : n * 9;
    }

    public static int simpleMultiplication (int n) {
        return n % 2 == 0 ? n * 8 : n * 9;
    }
}
