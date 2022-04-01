package main.java.kyu6.cw26;

import java.util.stream.IntStream;

public class SortedYesNo {

    public static String myIsSortedAndHow(int[] array) {
        boolean asc = true, desc = true;
        int last = array[0];
        for (int i = 1; i < array.length; i++) {
            if (asc && array[i]<last) asc = false;
            if (desc && array[i]>last) desc = false;
            last = array[i];
        }
        return (asc) ? "yes, ascending" : (desc) ? "yes, descending" : "no";
    }

    public static String isSortedAndHow(int[] array) {
        if(IntStream.range(0, array.length-1).allMatch(i -> array[i] <= array[i+1]))
            return "yes, ascending";

        if(IntStream.range(0, array.length-1).allMatch(i -> array[i] >= array[i+1]))
            return "yes, descending";

        return "no";
    }

}
