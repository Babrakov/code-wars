package main.java.cw19;

import java.util.*;
import java.util.stream.Collectors;

public class FormTheMinimum {
    public static void main(String[] args) {
        System.out.println(minValue(new int[] {1,3,1}));
    }

    public static int myMinValue(int[] values){
        Integer[] nums = Arrays.stream(values).boxed().toArray(Integer[]::new);
        SortedSet<Integer> sorted = new TreeSet<>();
        Collections.addAll(sorted, nums);
        String res = "";
        for (Integer x: sorted) {
            res += x;
        }

        return Integer.parseInt(res);
    }

    public static int minValue(int[] values){
        String s = Arrays.stream(values)
                .sorted()
                .distinct()
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(""));
        return Integer.valueOf(s);
    }
}
