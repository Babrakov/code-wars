package main.java.kyu7.kata14;

import java.util.stream.IntStream;

public class SpeedControl {

    public static int myGps(int s, double[] x) {
        if (x.length<=1) return 0;
        double max = 0;
        for (int i = 0; i < x.length-1; i++) {
            double current;
            current = (x[i+1]-x[i])*3600/s;
            max = (max>current) ? max : current;
        }
        return (int) max;
    }

    public static int gps(int s, double[] x) {
        double maxSpeed = IntStream
                .range(0, x.length - 1)
                .mapToDouble(i -> (x[i+1] - x[i]) * 3600.0 / (double) s )
                .max().orElse(0.0);
        return (int) Math.floor(maxSpeed);
    }

}
