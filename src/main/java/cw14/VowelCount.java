package main.java.cw14;

public class VowelCount {

    public static void main(String[] args) {
        System.out.println(getCount("abracadabra"));
    }

    public static int myGetCount(String str) {
        int vowelsCount = 0;
        String vowels = "aeiou";
        char[] arr = str.toCharArray();
        for (char ch: arr) {
            if (vowels.indexOf(ch) != -1)
                vowelsCount++;
        }

        // your code here
        return vowelsCount;
    }

    public static int getCount(String str) {
        int vowelsCount = 0;

        for(char c : str.toCharArray())
            vowelsCount += (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') ? 1 : 0;

        return vowelsCount;
    }

    public static int regExpGetCount(String str) {
        return str.replaceAll("(?i)[^aeiou]", "").length();
    }
}
