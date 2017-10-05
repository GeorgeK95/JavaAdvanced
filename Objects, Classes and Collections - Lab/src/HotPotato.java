import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class HotPotato {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        int n = Integer.parseInt(in.nextLine());
        Deque<String> queue = new ArrayDeque<>();
        fillDeque(line, queue);

        while (queue.size() > 1) {
            for (int i = 1; i <= n; i++) {
                if (i % n == 0) {
                    System.out.println("Removed " + queue.remove());
                } else {
                    queue.add(queue.poll());
                }
            }
        }

        System.out.println("Last is " + queue.remove());
    }

    private static void fillDeque(String[] line, Deque<String> queue) {
        for (String s : line) {
            queue.add(s);
        }
    }

}
