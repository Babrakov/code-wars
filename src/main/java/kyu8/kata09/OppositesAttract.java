package main.java.kyu8.cw09;

public class OppositesAttract {

    public static void main(String[] args) {
        System.out.println(isLove(2,2));
    }

    public static boolean myIsLove(final int flower1, final int flower2) {
        return (flower1+flower2)%2 > 0;
    }

    public static boolean isLove(final int flower1, final int flower2) {
        return flower1 % 2 != flower2 % 2;
    }
}
