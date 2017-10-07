import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ids = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> queue = new ArrayDeque<>();
        pushToTail(queue, numbers);
        popFromTail(queue, ids[1]);
        printMinElement(queue, ids[2]);
    }

    private static void printMinElement(Deque<Integer> queue, int number) {
        if (!queue.isEmpty()) {
            if (queue.contains(number)) {
                System.out.println(true);
            } else {
                System.out.println(queue.stream().min(Integer::compareTo).get());
            }
        } else {
            System.out.println(0);
        }
    }

    private static void popFromTail(Deque<Integer> queue, int count) {
        for (int i = 0; i < count; i++) {
            queue.remove();
        }
    }

    private static void pushToTail(Deque<Integer> queue, int[] numbers) {
        for (Integer integer : numbers) {
            queue.add(integer);
        }
    }

}
