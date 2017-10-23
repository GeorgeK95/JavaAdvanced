import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SecondNature {
    private static List<Integer> secondNatureList = new ArrayList<>();
    private static Deque<Integer> stack = new ArrayDeque<>();
    private static Deque<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        readData();
        irrigate();
        printResult();
    }

    private static void printResult() {
        if (stack.isEmpty() && !queue.isEmpty()) {
            //flowers left
            while (!queue.isEmpty()) {
                System.out.printf("%s ", queue.poll());
            }
        } else if (!stack.isEmpty() && queue.isEmpty()) {
            //buckets left
            while (!stack.isEmpty()) {
                System.out.printf("%s ", stack.pop());
            }
        }
        //print second nature flowers
        System.out.println();
        boolean isPrinted = false;
        for (Integer integer : secondNatureList) {
            System.out.print(integer + " ");
            isPrinted = true;
        }
        if (!isPrinted) {
            System.out.println("None");
        }
    }

    private static void irrigate() {
        while (!stack.isEmpty() && !queue.isEmpty()) {
            Integer pop = stack.pop(); //bucket
            Integer poll = queue.poll(); // flower
            int diff = pop - poll;

            if (diff > 0) {
                try {
                    Integer next = stack.pop();
                    next += diff;
                    stack.push(next);
                } catch (NoSuchElementException e) {
                    stack.push(diff);
                }

            } else if (diff < 0) {
                queue.addFirst(diff * -1);
            } else {
                secondNatureList.add(poll);
            }
        }
    }

    private static void readData() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] flowers = Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : flowers) {
            queue.addLast(i);
        }
        int[] buckets = Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int bucket : buckets) {
            stack.push(bucket);
        }
    }

}
