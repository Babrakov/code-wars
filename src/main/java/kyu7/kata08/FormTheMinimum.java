package main.java.kyu7.kata08;

import java.util.*;
import java.util.stream.Collectors;

/*
Task
Given a list of digits, return the smallest number that could be formed from these digits,
using the digits only once (ignore duplicates).

Notes:
Only positive integers will be passed to the function (> 0 ), no negatives or zeros.
 */

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
