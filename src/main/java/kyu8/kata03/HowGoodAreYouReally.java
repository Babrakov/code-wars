package main.java.kyu8.kata03;

import java.util.Arrays;

public class HowGoodAreYouReally {

    public static void main(String[] args) {
        System.out.println(betterThanAverage(new int[] {100, 90}, 11));
    }

    public static boolean myBetterThanAverage(int[] classPoints, int yourPoints) {
        var sum = 0;
        for (int i = 0; i < classPoints.length; i++) {
            sum += classPoints[i];
        }
        return (sum/classPoints.length)<yourPoints;
    }

    static boolean betterThanAverage(final int[] classPoints, final int yourPoints) {
        return Arrays.stream(classPoints).average().orElse(0) < yourPoints;
    }

}

