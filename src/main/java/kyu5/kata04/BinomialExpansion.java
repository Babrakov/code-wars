package main.java.kyu5.kata04;

/*
The purpose of this kata is to write a program that can do some algebra. Write a function expand that takes in an expression with a single, one character variable, and expands it. The expression is in the form (ax+b)^n where a and b are integers which may be positive or negative, x is any single character variable, and n is a natural number. If a = 1, no coefficient will be placed in front of the variable. If a = -1, a "-" will be placed in front of the variable.

The expanded form should be returned as a string in the form ax^b+cx^d+ex^f... where a, c, and e are the coefficients of the term, x is the original one character variable that was passed in the original expression and b, d, and f, are the powers that x is being raised to in each term and are in decreasing order. If the coefficient of a term is zero, the term should not be included. If the coefficient of a term is one, the coefficient should not be included. If the coefficient of a term is -1, only the "-" should be included. If the power of the term is 0, only the coefficient should be included. If the power of the term is 1, the caret and power should be excluded.

Examples:
KataSolution.expand("(x+1)^2");      // returns "x^2+2x+1"
KataSolution.expand("(p-1)^3");      // returns "p^3-3p^2+3p-1"
KataSolution.expand("(2f+4)^6");     // returns "64f^6+768f^5+3840f^4+10240f^3+15360f^2+12288f+4096"
KataSolution.expand("(-2a-4)^0");    // returns "1"
KataSolution.expand("(-12t+43)^2");  // returns "144t^2-1032t+1849"
KataSolution.expand("(r+0)^203");    // returns "r^203"
KataSolution.expand("(-x-1)^2");     // returns "x^2+2x+1"
 */

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class BinomialExpansion {

    public static void main(String[] args) {
//        System.out.println(expand("(-12t+43)^2"));
//        System.out.println(expand("(-x-1)^2"));
//        System.out.println(expand("(2f+4)^6"));
//        System.out.println(expand("(x+1)^2"));
//        System.out.println(expand("(9t-0)^2"));
//        System.out.println(expand("(-n-12)^5"));
        System.out.println(expand("(y+5)^15"));
    }

    public static String expand(String expr) {
        System.out.println(expr);

        final String regex = "\\((\\+|\\-)?(\\d*)(\\S)(\\+|\\-)?(\\d*)\\)\\^(\\d+)";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(expr);

        String firstSign,element,secondSign;
        firstSign=element=secondSign=null;
        Integer power = 0, firstFactor = 0, secondFactor = 0;

        while (matcher.find()) {
            firstSign = matcher.group(1);
            if (firstSign==null) firstSign = "+";
            firstFactor = Integer.parseInt(0+matcher.group(2));
            if (firstFactor==0) firstFactor=1;
            element = matcher.group(3);
            secondSign = matcher.group(4);
            secondFactor =  Integer.parseInt(0+matcher.group(5));
            power = Integer.parseInt(matcher.group(6));
        }

        if (firstSign.equals("-")) firstFactor *= -1;
        if (secondSign.equals("-")) secondFactor *= -1;
        if (power == 0) return "1";

        if (secondFactor.equals("0")) {
            String begin = "";
            if (firstFactor!=0) {
                begin = String.valueOf((int) Math.pow(firstFactor,power));
            } else {
                if (firstSign.equals("-") && power%2!=0) begin = "-";
            }
            return begin+element+"^"+power;
        }

        StringBuilder result = new StringBuilder();
        long c = 0;
        long nFactorial = factorial(power);
        for (int i = power; i > 0; i--) {
            int k = power-i;
            c = (long) (Math.pow(firstFactor,i) * Math.pow(secondFactor,k) * nFactorial/(factorial(k)*factorial(power-k)));
            if (i!=power && c>0) result.append("+");
            if (c!=0 && c!=1 && c!=-1) result.append(c);
            if (c==-1) result.append("-");
            if (c!=0) result.append(element);
            if (i!=1) result.append("^"+i);
        }
        c = (long) Math.pow(secondFactor,power);
        if (c>0) result.append("+");
        if (c!=0) result.append(c);

        return result.toString();
    }

    public static long factorial(int number) {
        long result = 1;

        for (int factor = 2; factor <= number; factor++) {
            result *= factor;
        }

        return result;
    }

    public static String bestExpand(String expr) {

        Matcher m = Pattern.compile("(\\-?\\d*)([a-z])([+-])(\\-?\\d+)\\D+(\\d+)").matcher(expr);
        m.find();
        int p = Integer.parseInt(m.group(5));
        String[] str = new String[p + 1];
        int a = m.group(1).length() == 0 ? 1 : m.group(1).equals("-") ? -1 : Integer.parseInt(m.group(1));
        int b = (m.group(3).equals("-") ? -1 : 1) * Integer.parseInt(m.group(4));
        for (int i = 0; i <= p; i++) {
            long f = (long) (nOverK(p, i) * Math.pow(a, p - i) * (i == 0 ? 1 : Math.pow(b, i)));
            if (f != 0) {
                str[i] = p - i == 0 ? f + ""
                        : (f == 1 ? "" : f == -1 ? "-" : f) + m.group(2) + (p - i != 1 ? "^" + (p - i) : "");
            }
        }
        return Arrays.stream(str).filter(s -> s != null).collect(Collectors.joining("+")).replaceAll("\\+\\-", "\\-");
    }

    public static int nOverK(int n, int k) {
        if (n < k)
            return 0;
        if (k == 0 || k == n)
            return 1;
        return nOverK(n - 1, k - 1) + nOverK(n - 1, k);
    }

}
