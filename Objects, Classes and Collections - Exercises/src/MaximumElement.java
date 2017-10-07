import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MaximumElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int line = Integer.parseInt(in.nextLine());
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < line; i++) {
            int[] ids = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            switch (ids[0]) {
                case 1:
                    stack.push(ids[1]);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    System.out.println(stack.stream().max(Integer::compareTo).get());
                    break;
            }
        }
    }
}
