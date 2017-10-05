import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MathPotato {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        int n = Integer.parseInt(in.nextLine());
        Deque<String> queue = new ArrayDeque<>();
        fillDeque(line, queue);
        int cycle = 1;

        while (queue.size() > 1) {
            for (int i = 1; i <= n; i++) {
                if (i % n == 0) {
                    if (!isPrime(cycle)) {
                        System.out.println("Removed " + queue.remove());
                    } else {
                        System.out.println("Prime " + queue.element());
                    }
                } else {
                    queue.add(queue.poll());
                }
            }
            cycle++;
        }

        System.out.println("Last is " + queue.remove());
    }

    public static boolean isPrime(int number) {
        return number > 1 &&
                IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .noneMatch(i -> number % i == 0);
    }

    private static void fillDeque(String[] line, Deque<String> queue) {
        for (String s : line) {
            queue.add(s);
        }
    }
}
