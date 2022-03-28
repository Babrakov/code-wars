package main.java.kyu7.cw21;

import java.util.*;
import java.util.stream.Collectors;

public class Isograms {

    public static boolean  myIsIsogram(String str) {
        Set<Character> charsSet = str.toLowerCase().chars()
                .mapToObj(e->(char)e).collect(Collectors.toSet());
        return (charsSet.size()==str.length());
    }

    public static boolean  isIsogram(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
