import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class LittleAlchemy {
    private static Deque<Integer> stones = new ArrayDeque<>();
    private static Deque<Integer> gold = new ArrayDeque<>();
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        readStones();

        while (true) {
            String[] data = in.readLine().split("\\s+");
            if ("Revision".equalsIgnoreCase(data[0])) {
                print();
                break;
            }

            if (data[0].equals("Apply")) {
                apply(Integer.parseInt(data[2]));
            } else if (data[0].equals("Air")) {
                leak(Integer.parseInt(data[2]));
            }
        }

    }

    private static void leak(int i) {
        if (gold.size() > 0) {
            gold.pop();
            stones.addLast(i);
        }
    }

    private static void apply(int i) {
        for (int j = 0; j < i; j++) {
            Integer poll = stones.poll();
            if (poll == null) {
                break;
            } else {
                poll--;
                if (poll > 0) {
                    stones.addLast(poll);
                } else {
                    gold.push(poll);
                }
            }
        }
    }

    private static void print() {
        while (!stones.isEmpty()) {
            System.out.printf("%s ", stones.poll());
        }
        System.out.println();
        System.out.println(gold.size());
    }

    private static void readStones() throws IOException {
        int[] collect = Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i : collect) {
            stones.addLast(i);
        }

    }
}
