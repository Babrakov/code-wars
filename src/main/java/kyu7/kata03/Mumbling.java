package main.java.kyu7.kata03;

public class Mumbling {

    public static void main(String[] args) {
        System.out.println(accum("ZpglnRxqenU"));
    }

    public static String myAccum(String s) {
        String res = "";
        char[] arr = s.toLowerCase().toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (res != "")
                res += "-";
            String first = "";
            String current = "";
            first += arr[i];
            current = first.toUpperCase();
            for (int j = 0; j < i; j++) {
                current += arr[i];
            }
            res += current;
        }
        return res;
    }

    public static String accum(String s) {
        StringBuilder bldr = new StringBuilder();
        int i = 0;
        for(char c : s.toCharArray()) {
            if(i > 0) bldr.append('-');
            bldr.append(Character.toUpperCase(c));
            for(int j = 0; j < i; j++) bldr.append(Character.toLowerCase(c));
            i++;
        }
        return bldr.toString();
    }

}
