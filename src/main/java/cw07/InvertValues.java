package main.java.cw07;

import java.util.Arrays;

public class InvertValues {

    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4,5};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(invert(new int[] {1,2,3,4,5})));
    }

    public static int[] myInvert(int[] array) {
        for (int i=0; i<array.length; i++) {
            array[i] *= -1;
        }
        return array;
    }

    public static int[] invert(int[] array) {
        return java.util.Arrays.stream(array).map(i -> -i).toArray();
    }
}
