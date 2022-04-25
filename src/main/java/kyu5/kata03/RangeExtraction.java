package main.java.kyu5.kata03;

public class RangeExtraction {

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[] {-6,-3,-2,-1,0,1,3,4,5,7,8,9,10,11,14,15,17,18}));
    }

    public static String rangeExtraction(int[] arr) {
        StringBuilder result = new StringBuilder();
        result.append(arr[0]);
        boolean range = true;
        int counter = 0;
        int last = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==arr[i-1]+1) {
                counter++;
                range = true;
                last = arr[i];
                if (i==arr.length-1 && counter<2)
                    result.append(","+arr[i]);
                else
                    continue;
            } else if (range && counter>=2) {
                range = false;
                result.append("-"+last);
                result.append(","+arr[i]);
                counter = 0;
                last = arr[i];
            } else {
                if (counter==1) {
                    result.append("," + last);
                    counter = 0;
                }
                result.append(","+arr[i]);
            }
        }
        if (range && counter>=2)
            result.append("-"+last);
        return result.toString();
    }

    public static String bestRangeExtraction(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
            int j = i;
            while (j < arr.length - 1 && arr[j] + 1 == arr[j + 1]) j++;
            if (i + 1 < j) {
                i = j;
                sb.append("-");
                sb.append(arr[i]);
            }
            sb.append(",");
        }
        sb.setLength(sb.length() - 1);
        return sb.toString();
    }

}
