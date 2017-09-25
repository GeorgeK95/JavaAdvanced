import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SequenceInMatrix {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] matrix = readMatrix();
        printBestSequence(matrix);
    }

    private static void printBestSequence(String[][] matrix) {
        findBestSequence(matrix);
    }

    private static void findBestSequence(String[][] matrix) {
        int length = 0;
        String[] best = new String[0];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                String[] diagonal = getDiagonal(matrix, i, j);
                String[] vertical = getCol(matrix, i, j);
                int currentLength = Math.max(diagonal.length, vertical.length);
                if (currentLength >= length) {
                    if (diagonal.length >= vertical.length) {
                        best = diagonal;
                    } else {
                        best = vertical;
                    }
                    length = currentLength;
                }
            }
        }
        printArray(best);
    }

    private static String[] getCol(String[][] matrix, int i, int j) {
        int c = 0;
        for (int k = i; k < matrix.length - 1; k++) {
            if (matrix[k][j].equals(matrix[k + 1][j])) {
                c++;
            } else {
                break;
            }
        }
        return getResultArray(matrix[i][j], c + 1);
    }

    private static String[] getDiagonal(String[][] matrix, int i, int j) {
        int c = 0;
        for (int k = i; k < Math.min(matrix.length - 1, matrix[i].length - 1); k++) {
            if (matrix[k][k].equals(matrix[k + 1][k + 1])) {
                c++;
            } else {
                break;
            }
        }
        return getResultArray(matrix[i][j], c + 1);
    }

    private static void printArray(String[] bestCollection) {
        String join = join(Arrays.stream(bestCollection).collect(Collectors.toList()), ", ");
        System.out.println(join);
    }

    private static String join(Collection<?> s, String delimiter) {
        StringBuilder builder = new StringBuilder();
        Iterator<?> iter = s.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (!iter.hasNext()) {
                break;
            }
            builder.append(delimiter);
        }
        return builder.toString();
    }

    private static String[] getResultArray(String str, int best) {
        String[] result = new String[best];
        for (int i = 0; i < result.length; i++) {
            result[i] = str;
        }
        return result;
    }

    private static String[][] readMatrix() {
        String[] line = in.nextLine().split("\\s+");
        int r = Integer.parseInt(line[0]);
        int c = Integer.parseInt(line[1]);
        String[][] matrix = new String[r][c];
        for (int i = 0; i < r; i++) {
            String[] currentLine = in.nextLine().split("\\s+");
            System.arraycopy(currentLine, 0, matrix[i], 0, c);
        }
        return matrix;
    }
}
