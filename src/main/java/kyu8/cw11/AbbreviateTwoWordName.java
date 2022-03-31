package main.java.kyu8.cw11;

public class AbbreviateTwoWordName {

    public static void main(String[] args) {
        System.out.println(abbrevName("Sam Harris"));
    }

    public static String myAbbrevName(String name) {
        String[] splited = name.split("\\s+");
        return splited[0].substring(0,1).toUpperCase()+"."+splited[1].substring(0,1).toUpperCase();
    }

    public static String abbrevName(String name) {
        String[] names = name.split(" ");
        return (names[0].charAt(0) + "." + names[1].charAt(0)).toUpperCase();
    }
}
