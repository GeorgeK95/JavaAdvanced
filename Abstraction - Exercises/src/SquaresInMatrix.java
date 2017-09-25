import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SquaresInMatrix {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[] line = in.nextLine().split("\\s+");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        System.out.println(getSquaresCount(r, c));
    }

    private static int getSquaresCount(int r, int c) {
        String[][] matrix = readMatrix(r, c);
        int count = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                String[][] subMatrix = getSubMatrix(matrix, i, j);
                if (isSubMatrixValid(subMatrix)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isSubMatrixValid(String[][] subMatrix) {
        String str = subMatrix[0][0];
        for (String[] strings : subMatrix) {
            for (String string : strings) {
                if (!string.equals(str)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static String[][] getSubMatrix(String[][] matrix, int i, int j) {
        String[][] submatrix = new String[2][2];
        submatrix[0][0] = matrix[i][j];
        submatrix[0][1] = matrix[i][j + 1];
        submatrix[1][0] = matrix[i + 1][j];
        submatrix[1][1] = matrix[i + 1][j + 1];
        return submatrix;
    }

    private static String[][] readMatrix(int r, int c) {
        String[][] matrix = new String[r][c];
        for (int i = 0; i < r; i++) {
            String[] line = in.nextLine().split("\\s+");
            for (int j = 0; j < c; j++) {
                matrix[i][j] = line[j];
            }
        }
        return matrix;
    }

}
