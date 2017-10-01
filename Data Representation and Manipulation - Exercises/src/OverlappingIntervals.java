import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class OverlappingIntervals {

    public static void main(String[] args) {
        TreeMap<Integer, Integer> intervals = getIntervals();
        System.out.println(checkForOverlap(intervals));
    }

    private static boolean checkForOverlap(TreeMap<Integer, Integer> intervals) {
        Map.Entry<Integer, Integer> first = intervals.firstEntry();
        intervals.remove(intervals.firstKey());
        int prevEnd = first.getValue();

        for (Map.Entry<Integer, Integer> integerIntegerEntry : intervals.entrySet()) {
            int currStart = integerIntegerEntry.getKey();
            if (prevEnd >= currStart) {
                return true;
            }
            prevEnd = integerIntegerEntry.getValue();
        }

        return false;
    }

    private static TreeMap<Integer, Integer> getIntervals() {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        TreeMap<Integer, Integer> intervals = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] currentLine = in.nextLine().split(",");
            intervals.put(Integer.parseInt(currentLine[0]), Integer.parseInt(currentLine[1]));
        }
        return intervals;
    }


}
