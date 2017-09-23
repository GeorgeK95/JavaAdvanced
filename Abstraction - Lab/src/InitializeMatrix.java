import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
class InitializeMatrix {
    private static Scanner in = new Scanner(System.in);

    static int[][] getInitializedMatrix() {
        return getMatrix();
    }

    private static int[][] getMatrix() {
        String[] line = in.nextLine().split(", ");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        return fillMatrix(r, c);
    }

    private static int[][] fillMatrix(int r, int c) {
        int[][] matrix = new int[r][c];
        for (int i = 0; i < r; i++) {
            String[] line = in.nextLine().split(", ");
            for (int j = 0; j < c; j++) {
                matrix[i][j] = Integer.parseInt(line[j]);
            }
        }
        return matrix;
    }
}
