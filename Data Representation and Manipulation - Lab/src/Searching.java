import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Searching {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] line = getArray(in.nextLine());//Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int x = Integer.parseInt(in.nextLine());
//        System.out.println(doLinearSearch(line, x));
        System.out.println(doBinarySearch(line, x));
    }

    private static int[] getArray(String s) {
        String[] split = s.split("\\s+");
        int[] arr = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            arr[i] = Integer.parseInt(split[i]);
        }
        return arr;
    }

    private static int doBinarySearch(int[] line, int x) {
        return doBinarySearch(line, 0, line.length - 1, x);
    }

    private static int doBinarySearch(int[] line, int i, int j, int x) {
        if (i > j) {
            return -1;
        }
        int middle = (i + j) / 2;
        if (line[middle] == x) {
            return middle;
        } else if (line[middle] > x) {
            return doBinarySearch(line, 0, middle - 1, x);
        } else {
            return doBinarySearch(line, middle + 1, j, x);
        }

    }

    private static int doLinearSearch(int[] line, int x) {
        for (int i = 0; i < line.length; i++) {
            if (line[i] == x) {
                return i;
            }
        }
        return -1;
    }

}
