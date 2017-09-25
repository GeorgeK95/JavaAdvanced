import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class StringMatrixRotation {
    public static void main(String[] args) {
        List<String> matrix = readMatrix();
        printRotatedMatrix(matrix);
    }

    private static void printRotatedMatrix(List<String> matrix) {
        int rotateDegrees = getRotateValue(matrix.get(0));
        rotateDegrees -= 360 * (rotateDegrees / 360);
        int longest = getLongestStringInMatrix(matrix);

        switch (rotateDegrees) {
            case 0:
                for (int i = 1; i < matrix.size(); i++) {
                    System.out.println(matrix.get(i));
                }
                break;
            case 90:
                for (int j = 0; j < longest; j++) {
                    for (int i = matrix.size() - 1; i > 0; i--) {
                        System.out.print(matrix.get(i).charAt(j));
                    }
                    System.out.println();
                }
                break;
            case 180:
                for (int i = matrix.size() - 1; i > 0; i--) {
                    System.out.println(new StringBuilder(matrix.get(i)).reverse().toString());
                }
                break;
            case 270:
                for (int j = longest - 1; j >= 0; j--) {
                    for (int i = 1; i < matrix.size(); i++) {
                        System.out.print(matrix.get(i).charAt(j));
                    }
                    System.out.println();
                }
                break;
        }
    }

    private static int getRotateValue(String s) {
        int i = s.indexOf("(");
        int j = s.indexOf(")");
        return Integer.parseInt(s.substring(i + 1, j));
    }


    private static List<String> readMatrix() {
        Scanner in = new Scanner(System.in);
        String command = in.nextLine();
        List<String> matrix = new ArrayList<>();
        matrix.add(command);
        while (true) {
            String line = in.nextLine();
            if (line.equals("END")) {
                break;
            }
            matrix.add(line);
        }
        return fillWithSpaces(matrix);
    }

    private static List<String> fillWithSpaces(List<String> matrix) {
        List<String> newMatrix = new ArrayList<>();
        int longest = getLongestStringInMatrix(matrix);
        newMatrix.add(matrix.get(0));
        for (int i = 1; i < matrix.size(); i++) {
            String str = "";
            String s = matrix.get(i);
            int current = matrix.get(i).length();
            str += s;
            for (int j = current; j < longest; j++) {
                str += " ";
            }
            newMatrix.add(str);
        }
        return newMatrix;
    }

    private static int getLongestStringInMatrix(List<String> matrix) {
        int best = 0;
        for (int i = 1; i < matrix.size(); i++) {
            int length = matrix.get(i).length();
            if (length > best) {
                best = length;
            }
        }
        return best;
    }

}
