package cw12;

public class TotalAmountOfPoints {

    public static void main(String[] args) {
        System.out.println(points(new String[]{"1:0","2:0","3:0","4:0","2:1","3:1","4:1","3:2","4:2","4:3"}));
    }

    public static int myPoints(String[] games) {
        int result = 0;
        for (String str: games) {
            String[] game = str.split(":");
            int x = Integer.valueOf(game[0]);
            int y = Integer.valueOf(game[1]);
            if (x>y) result += 3;
            else if (x==y) result += 1;
        }
        return result;
    }

    public static int points(String[] games) {
        int sum = 0;

        for (String s : games) {
            char x = s.charAt(0),
                    y = s.charAt(2);

            sum += x > y ? 3 : x == y ? 1 : 0;
        }

        return sum;
    }
}
