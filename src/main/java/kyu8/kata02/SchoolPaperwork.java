package main.java.kyu8.cw02;

public class SchoolPaperwork {

    public static void main(String[] args) {
        System.out.println( paperWork(-5,5));
        System.out.println( paperWork(5,5));
    }

    public static int myPaperWork(int n, int m)
    {
        if (n<0 || m<0) {
            return 0;
        } else {
            return m*n;
        }
    }

    public static int paperWork(int n, int m)
    {
        return (n < 0) || (m < 0) ? 0 : n * m;
        //Happy Coding! ^_^
    }
}
