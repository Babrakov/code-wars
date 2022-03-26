package main.java.cw16;

public class GetMiddleCharacter {

    public static void main(String[] args) {
        System.out.println(getMiddle("A"));
    }

    public static String myGetMiddle(String word) {
        String res = "";
        int len = word.length();
        if (len%2 == 0) {
            res += word.toCharArray()[(int) (len / 2) - 1];
            res += word.toCharArray()[(int) (len / 2)];
        } else
            res += word.toCharArray()[(int) len/2];
        return res;
    }

    public static String getMiddle(String word) {
        String s = "";
        int length = word.length();
        int half = length/2;

        if (length % 2 == 0) {
            s = word.substring(half - 1, half + 1);
        } else {
            s = word.substring(half, half + 1);
        }

        return s;
    }
}
