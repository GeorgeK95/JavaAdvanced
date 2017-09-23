import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SumMatrixElements {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrix = InitializeMatrix.getInitializedMatrix();
        printResult(matrix);
    }

    private static void printResult(int[][] matrix) {
        System.out.println(matrix.length);
        System.out.println(matrix[0].length);
        int sum = 0;
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                sum += anInt;
            }
        }
        System.out.println(sum);
    }
}

