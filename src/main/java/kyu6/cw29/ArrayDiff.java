package main.java.kyu6.cw29;

/*
Your goal in this kata is to implement a difference function, which subtracts one list from another and returns the result.

It should remove all values from list a, which are present in list b keeping their order.
Kata.arrayDiff(new int[] {1, 2}, new int[] {1}) => new int[] {2}

If a value is present in b, all of its occurrences must be removed from the other:
Kata.arrayDiff(new int[] {1, 2, 2, 2, 3}, new int[] {2}) => new int[] {1, 3}
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayDiff {

    public static int[] myArrayDiff(int[] a, int[] b) {
        if (a.length==0 || b.length==0) return a;
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < a.length; j++) {
            int current = a[j];
            if (!IntStream.of(b).anyMatch(n -> n == current)) res.add(a[j]);
        }

        return res.stream().mapToInt(Integer::intValue).toArray();
    }

    public static int[] arrayDiff(int[] a, int[] b) {
        List<Integer> listA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> listB = Arrays.stream(b).boxed().collect(Collectors.toList());
        listA.removeAll(listB);
        return listA.stream().mapToInt(e -> e).toArray();
    }

}
