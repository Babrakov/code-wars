package main.java.kyu8.cw08;

public class ConvertBooleanValuesToStrings {

    public static void main(String[] args) {
        System.out.println(boolToWord(true));
    }

    public static String boolToWord(boolean b)
    {
        return b ? "Yes" : "No";
    }

}
