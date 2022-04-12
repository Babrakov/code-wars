package main.java.kyu7.kata11;

import java.util.stream.Collectors;

public class TwoToOne {

    public static String myLongest (String s1, String s2) {
        String str = s1+s2;
        return str.chars().distinct().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
    }

    public static String longest (String s1, String s2) {
        String s = s1 + s2;
        return s.chars().distinct().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
    }
}
