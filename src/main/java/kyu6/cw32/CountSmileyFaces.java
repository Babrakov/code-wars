package main.java.kyu6.cw32;

import java.util.ArrayList;
import java.util.List;

public class CountSmileyFaces {

    public static void main(String[] args) {
        List<String> a = new ArrayList<String>();
        a.add(":)"); a.add(":D"); a.add(":-}"); a.add(":-()");
        System.out.println(countSmileys(a));
    }

    public static int countSmileys(List<String> arr) {
        return (int)arr.stream().filter( x -> x.matches("[:;][-~]?[)D]")).count();
    }

    public static int myCountSmileys(List<String> arr) {
        int res = 0;
        for (String str:arr) {
            if (checkSmile(str)) res++;
        }
        return res;
    }

    public static boolean checkSmile(String str) {
        if (str.length()>3) return false;
        if (str.charAt(0)!=':' &&  str.charAt(0)!=';') return false;
        if (str.length()==2 && str.charAt(1)!=')' &&  str.charAt(1)!='D') return false;
        if (str.length()==3) {
            if (str.charAt(1)!='-' &&  str.charAt(1)!='~') return false;
            if (str.charAt(2)!=')' &&  str.charAt(2)!='D') return false;
        }
        return true;
    }

}
