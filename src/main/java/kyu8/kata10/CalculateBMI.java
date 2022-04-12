package main.java.kyu8.cw10;

public class CalculateBMI {

    public static void main(String[] args) {
        System.out.println(bmi(78, 1.73));
    }

    public static String myBmi(double weight, double height) {
        double index = weight / (height * height);
        if (index<= 18.5) return "Underweight";
        else if (index <= 25.0) return "Normal";
        else if (index <= 30.0) return "Overweight";
        return "Obese";
    }

    public static String bmi(double weight, double height) {
        double bmi =weight/(height*height);
        return bmi <= 18.5 ? "Underweight": bmi <=25.0 ? "Normal" : bmi<=30.0 ? "Overweight" : "Obese";
    }

}
