package main.java.kyu8.kata05;

public class NeedleInHaystack {

    public static void main(String[] args) {
        System.out.println(findNeedle(new Object[]{"3", "123124234", null, "needle", "world", "hay", 2, "3", true, false}));
    }

    public static String myFindNeedle(Object[] haystack) {
        for (int i=0;i<haystack.length;i++) {
            if (haystack[i]=="needle") return "found the needle at position "+i;
        }
        return "";
    }

    public static String findNeedle(Object[] haystack) {
        return String.format("found the needle at position %d", java.util.Arrays.asList(haystack).indexOf("needle"));
    }
}
