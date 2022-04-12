package main.java.kyu8.kata01;

public class SumArrays {

    public static void main(String[] args) {
        System.out.println(sum(new double[]{1,3,4.4}));
    }

    public static double sum(double[] numbers) {
        double result = 0;
        for (int i = 0; i < numbers.length; i++) {
            result += numbers[i];
        }
        return result;
    }
}
