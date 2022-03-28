package main.java.kyu7.cw17;

public class SumOfNumbers {

    public int myGetSum(int a, int b)
    {
        int max, min, sum;
        sum = 0;
        if (a>b) {
            max = a;
            min = b;
        } else {
            max = b;
            min = a;
        }
        for (int i = min; i <= max; i++) {
            sum += i;
        }
        return sum;
    }

    public int GetSum(int a, int b)
    {
        return (a + b) * (Math.abs(a - b) + 1) / 2;
    }

    public int simpleGetSum(int a, int b) {
        int res = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            res += i;
        }
        return a == b ? a : res;
    }
}
