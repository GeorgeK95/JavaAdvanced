import java.util.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Sorting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] line = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        doSelectionSort(line);
        doBubbleSort(line);
        print(line);

    }

    private static void doBubbleSort(int[] line) {
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = 0; j < line.length - 1 - i; j++) {
                if (line[j] > line[j + 1]) {
                    swap(line, j, j + 1);
                }
            }

        }
    }

    private static void print(int[] line) {
        System.out.println(join(line));
    }

    private static String join(int[] s) {
        StringJoiner sj = new StringJoiner(" ");
        for (int i : s) {
            sj.add(String.valueOf(i));
        }
        return sj.toString();
    }

    private static void doSelectionSort(int[] line) {
        for (int i = 0; i < line.length - 1; i++) {
            int minValue = Integer.MAX_VALUE;
            int minIndex = Integer.MAX_VALUE;
            for (int j = i + 1; j < line.length; j++) {
                if (line[j] < minValue) {
                    minValue = line[j];
                    minIndex = j;
                }
            }
            if (line[i] > line[minIndex]) {
                swap(line, i, minIndex);
            }
        }
    }

    private static void swap(int[] line, int i, int j) {
        int a = line[i];
        line[i] = line[j];
        line[j] = a;
    }
}
