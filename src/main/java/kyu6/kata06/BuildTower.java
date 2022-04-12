package main.java.kyu6.kata06;

/*
Build Tower
Build a pyramid-shaped tower given a positive integer number of floors. A tower block is represented with "*" character.

For example, a tower with 3 floors looks like this:

[
  "  *  ",
  " *** ",
  "*****"
]
And a tower with 6 floors looks like this:

[
  "     *     ",
  "    ***    ",
  "   *****   ",
  "  *******  ",
  " ********* ",
  "***********"
]
 */

import java.util.Arrays;

public class BuildTower {

    public static final String SYMBOL = "*";
    public static final String SPACE = " ";

    public static void main(String[] args) {
        System.out.println(Arrays.toString(TowerBuilder(3)));
    }


    public static String[] myTowerBuilder(int nFloors)
    {
        String[] res = new String[nFloors];
        int num = nFloors*2-2, current =1;
        for (int i = 0; i < nFloors; i++) {
            res[i] = SPACE.repeat(num/2-i) + SYMBOL.repeat(current) + SPACE.repeat(num/2-i);
            current += 2;
        }
        return res;
    }

    public static String[] TowerBuilder(int n) {
        String t[] = new String[n], e;

        for (int i = 0; i < n; i++)
            t[i] = (e = " ".repeat(n-i-1)) + "*".repeat(i+i+1) + e;

        return t;
    }

}
