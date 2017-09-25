import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MaximalSum {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] matrix = readMatrix();
        printBestSubMatrix(matrix);
    }

    private static void printSubMatrix(int[][] bestSumMatrix, long bestSum) {
        System.out.println("Sum = " + bestSum);
        for (int[] ints : bestSumMatrix) {
            for (int anInt : ints) {
                System.out.printf("%d ", anInt);
            }
            System.out.println();
        }
    }

    private static void printBestSubMatrix(int[][] matrix) {
        int[][] bestSumMatrix = new int[3][3];
        long bestSum = 0;
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                int[][] subMatrix = getSubMatrix(matrix, i, j);
                long currentSum = getSubMatrixSum(subMatrix);
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestSumMatrix = subMatrix;
                }
            }
        }
        printSubMatrix(bestSumMatrix, bestSum);
    }

    private static long getSubMatrixSum(int[][] subMatrix) {
        long sum = 0;
        for (int[] iters : subMatrix) {
            for (int iter : iters) {
                sum += iter;
            }
        }
        return sum;
    }

    private static int[][] getSubMatrix(int[][] matrix, int i, int j) {
        int[][] submatrix = new int[3][3];
        submatrix[0][0] = matrix[i][j];
        submatrix[0][1] = matrix[i][j + 1];
        submatrix[0][2] = matrix[i][j + 2];
        submatrix[1][0] = matrix[i + 1][j];
        submatrix[1][1] = matrix[i + 1][j + 1];
        submatrix[1][2] = matrix[i + 1][j + 2];
        submatrix[2][0] = matrix[i + 2][j];
        submatrix[2][1] = matrix[i + 2][j + 1];
        submatrix[2][2] = matrix[i + 2][j + 2];
        return submatrix;
    }

    private static int[][] readMatrix() {
        String[] line = in.nextLine().split("\\s+");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] currentLine = in.nextLine().split("\\s+");
            for (int j = 0; j < c; j++) {
                matrix[i][j] = Integer.parseInt(currentLine[j]);
            }
        }
        return matrix;
    }
}
