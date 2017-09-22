import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class BlurFilter {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int blur = Integer.parseInt(in.nextLine());
        String[] size = in.nextLine().split("\\s+");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);
        long[][] array = getArray(row, col);
        String[] target = in.nextLine().split("\\s+");
        int targetRow = Integer.parseInt(target[0]);
        int targetCol = Integer.parseInt(target[1]);
        fillArray(array, targetRow, targetCol, blur, row, col);
        printArray(array);
    }

    private static long[][] getArray(int row, int col) {
        long[][] array = new long[row][col];
        for (int i = 0; i < row; i++) {
            String[] line = in.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                String s = line[j];
                array[i][j] = Long.parseLong(s);
            }
        }
        return array;
    }

    private static void fillArray(long[][] array, int targetRow, int targetCol, int blur, int r, int c) {
        fillTopLine(array, targetRow, targetCol, blur, r, c);
        fillMiddleLine(array, targetRow, targetCol, blur, r, c);
        fillBottomLine(array, targetRow, targetCol, blur, r, c);
    }

    private static void fillBottomLine(long[][] array, int targetRow, int targetCol, int blur, int r, int c) {
        if (targetRow < r - 1) {
            if (targetCol > 0) {
                array[targetRow + 1][targetCol - 1] += blur;
            }
            array[targetRow + 1][targetCol] += blur;
            if (targetCol < c - 1) {
                array[targetRow + 1][targetCol + 1] += blur;
            }
        }
    }

    private static void fillMiddleLine(long[][] array, int targetRow, int targetCol, int blur, int r, int c) {
        if (targetCol > 0) {
            array[targetRow][targetCol - 1] += blur;
        }
        if (targetCol < c - 1) {
            array[targetRow][targetCol + 1] += blur;
        }
        array[targetRow][targetCol] += blur;
    }

    private static void fillTopLine(long[][] array, int targetRow, int targetCol, int blur, int r, int c) {
        if (targetRow > 0) {
            if (targetCol > 0) {
                array[targetRow - 1][targetCol - 1] += blur;
            }
            array[targetRow - 1][targetCol] += blur;
            if (targetCol < c - 1) {
                array[targetRow - 1][targetCol + 1] += blur;
            }
        }
    }

    private static void printArray(long[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.printf("%d ", array[i][j]);
            }
            System.out.println();
        }
    }


}
