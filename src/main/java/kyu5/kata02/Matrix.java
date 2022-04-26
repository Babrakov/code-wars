package main.java.kyu5.kata02;

/*
Write a function that accepts a square matrix (N x N 2D array) and returns the determinant of the matrix.

How to take the determinant of a matrix -- it is simplest to start with the smallest cases:

A 1x1 matrix |a| has determinant a.

A 2x2 matrix [ [a, b], [c, d] ] or

|a  b|
|c  d|
has determinant: a*d - b*c.

The determinant of an n x n sized matrix is calculated by reducing the problem to the calculation of the determinants of n matrices ofn-1 x n-1 size.

For the 3x3 case, [ [a, b, c], [d, e, f], [g, h, i] ] or

|a b c|
|d e f|
|g h i|
the determinant is: a * det(a_minor) - b * det(b_minor) + c * det(c_minor) where det(a_minor) refers to taking the determinant of the 2x2 matrix created by crossing out the row and column in which the element a occurs:

|- - -|
|- e f|
|- h i|
Note the alternation of signs.

The determinant of larger matrices are calculated analogously, e.g. if M is a 4x4 matrix with first row [a, b, c, d], then:

det(M) = a * det(a_minor) - b * det(b_minor) + c * det(c_minor) - d * det(d_minor)
 */

import java.util.ArrayList;
import java.util.List;

public class Matrix {

    public static void main(String[] args) {
        int[][] matrix = {{2,5,3}, {1,-2,-1}, {1, 3, 4}};
        System.out.println(determinant(matrix));
    }

    public static int determinant(int[][] matrix) {
        if (matrix.length == 1) return matrix[0][0];
        if (matrix.length == 2)
            return square(matrix);
        else {
            int result = 0;
            boolean sign = true;
            int[][] newMatrix= new int[matrix.length-1][matrix.length-1];
            for (int k = 0; k < matrix.length; k++) {
                int a = matrix[0][k];
                for (int i = 1; i < matrix.length; i++) {
                    List<Integer> row = new ArrayList<>();
                    for (int j = 0; j < matrix.length; j++) {
                        if (j==k) continue;
                        row.add(matrix[i][j]);
                    }
                    newMatrix[i-1] = row.stream().mapToInt(val -> val).toArray();
                }
                if (sign) {
                    result += a * determinant(newMatrix);
                    sign = false;
                } else {
                    result -= a * determinant(newMatrix);
                    sign = true;
                }
            }

            return result;
        }
    }

    private static int square(int[][] matrix) {
        int a,b,c,d;
        a = matrix[0][0];
        b = matrix[0][1];
        c = matrix[1][0];
        d = matrix[1][1];
        return a*d - b*c;
    }

    public static int bestDeterminant(int[][] m) {
        int d = 0, size = m.length;
        if (size == 1) return m[0][0];

        for (int n = 0 ; n < size ; n++) {
            int[][] newM = new int[size-1][size-1];
            for (int x = 1 ; x < size ; x++) for (int y = 0 ; y < size ; y++) {
                if (y == n) continue;
                newM[x-1][y + (y>n ? -1 : 0)] = m[x][y];
            }
            d += (n%2!=0 ? -1 : 1) * m[0][n] * determinant(newM);
        }
        return d;
    }

}
