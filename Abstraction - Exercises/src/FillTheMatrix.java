import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(", ");
        int n = Integer.parseInt(line[0]);
        String type = line[1];
        int[][] matrix = new int[n][n];
        if (type.equals("A")) {
            fillMatrixA(matrix);
        } else if (type.equals("B")) {
            fillMatrixB(matrix);
        } else {
            System.out.println("Wrong type.");
        }
        printMatrix(matrix);
    }

    private static int[][] fillMatrixB(int[][] matrix) {
        int c = 1;
        for (int i = 0; i < matrix.length; i++) {
            if (i % 2 == 0) {
                fillSubMatrix(matrix, i, true, c);
            } else {
                fillSubMatrix(matrix, i, false, c);
            }
            c += matrix.length;
        }
        return matrix;
    }

    private static void fillSubMatrix(int[][] matrix, int i, boolean b, int c) {
        if (b) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[j][i] = c;
                c++;
            }
        } else {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                matrix[j][i] = c;
                c++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrixA(int[][] matrix) {
        int c = 1;
        for (int i = 0; i < matrix.length; i++) {
            fillSubMatrix(matrix, i, true, c);
            c += matrix.length;
        }
        return matrix;
    }

}
