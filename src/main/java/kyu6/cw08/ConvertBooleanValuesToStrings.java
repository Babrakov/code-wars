package main.java.kyu6.cw08;

public class ConvertBooleanValuesToStrings {

    public static void main(String[] args) {
        System.out.println(boolToWord(true));
    }

    public static String boolToWord(boolean b)
    {
        return b ? "Yes" : "No";
    }

}
