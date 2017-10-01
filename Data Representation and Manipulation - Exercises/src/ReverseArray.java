import java.util.Scanner;
import java.util.StringJoiner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ReverseArray {
    public static void main(String[] args) {
        int[] line = getArray();
        reverse(line);
        print(line);
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

    private static void reverse(int[] line) {
        reverse(line, 0, line.length - 1);
    }

    private static void reverse(int[] line, int i, int j) {
        if (i >= j) {
            return;
        }
        swap(line, i, j);
        reverse(line, i + 1, j - 1);
    }

    private static void swap(int[] line, int i, int j) {
        int a = line[i];
        line[i] = line[j];
        line[j] = a;
    }

    private static int[] getArray() {
        Scanner in = new Scanner(System.in);
        String[] split = in.nextLine().split("\\s+");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }

}
