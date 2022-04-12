package main.java.kyu7.kata12;

public class MaximumLengthDifference {

    public static int myMxdiflg(String[] a1, String[] a2) {
        if (a1.length==0 || a2.length==0) return -1;
        int a1min = a1[0].length();
        int a2min = a2[0].length();
        int a1max = a1min;
        int a2max = a2min;
        for (int i = 1; i < a1.length; i++) {
            int length = a1[i].length();
            if (length < a1min) a1min = length;
            if (length > a1max) a1max = length;
        }
        for (int i = 1; i < a2.length; i++) {
            int length = a2[i].length();
            if (length < a2min) a2min = length;
            if (length > a2max) a2max = length;
        }
        int d1 = a1max - a2min;
        int d2 = a2max - a1min;
        return Math.max(d1,d2);
    }

    public static int mxdiflg(String[] a1, String[] a2) {
        if(a1.length==0||a2.length==0)
            return -1;

        int b1=0, b2=0;
        int l1=Integer.MAX_VALUE, l2=Integer.MAX_VALUE;

        for (String s : a1) {
            b1 = Math.max(b1, s.length());
            l1 = Math.min(l1, s.length());
        }
        for (String s : a2) {
            b2 = Math.max(b2, s.length());
            l2 = Math.min(l2, s.length());
        }

        return Math.max(Math.abs(b2-l1), Math.abs(b1-l2));
    }

}
