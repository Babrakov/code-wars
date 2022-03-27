package main.java.cw13;

public class AnagramDetection {
    public static void main(String[] args) {
        System.out.println(isAnagram("Buckethead", "DeathCubeK"));
    }

    public static boolean myIsAnagram(String test, String original) {
        char[] testCh = getArrayFromString(test.toLowerCase());
        char[] originalCh = getArrayFromString(original.toLowerCase());

        int testLength = testCh.length;
        int originalLength = originalCh.length;

        if (testLength != originalLength)
            return false;

        java.util.Arrays.sort(testCh);
        java.util.Arrays.sort(originalCh);

        for (int i = 0; i < testLength; i++) {
            if (testCh[i] != originalCh[i])
                return false;
        }

        return true;
    }

    public static char[] getArrayFromString(String str){
        char[] result = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = str.charAt(i);
        }
        return result;
    }

    public static boolean isAnagram(String test, String original) {
        if( test == null || original == null || test.length() != original.length())
            return false;

        char ch1 [] = test.toLowerCase().toCharArray();
        char ch2 [] = original.toLowerCase().toCharArray();

        java.util.Arrays.sort(ch1);
        java.util.Arrays.sort(ch2);

        return java.util.Arrays.equals(ch1, ch2);

    }

}
