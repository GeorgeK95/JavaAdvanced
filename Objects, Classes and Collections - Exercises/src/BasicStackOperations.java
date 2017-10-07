import java.util.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] ids = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] numbers = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        Deque<Integer> stack = new ArrayDeque<>();
        pushToStack(stack, numbers);
        popFromStack(stack, ids[1]);
        printResult(stack, ids[2]);
    }

    private static void popFromStack(Deque<Integer> stack, int num) {
        for (int i = 0; i < num; i++) {
            stack.pop();
        }
    }

    private static void pushToStack(Deque<Integer> stack, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }
    }

    private static void printResult(Deque<Integer> stack, int num) {
        if (!stack.isEmpty()) {
            if (stack.contains(num)) {
                System.out.println(true);
            } else {
                System.out.println(stack.stream().min(Integer::compareTo).get());
            }
        } else {
            System.out.println(0);
        }
    }

}
