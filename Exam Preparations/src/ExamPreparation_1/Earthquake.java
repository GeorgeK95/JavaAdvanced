package ExamPreparation_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Stream;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Earthquake {
    private static Deque<Integer> result = new ArrayDeque<>();
    private static Deque<Deque<Integer>> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        readInput();
        process();
        printSeismicities();
    }

    private static void printSeismicities() {
        System.out.println(result.size());
        StringBuilder sb = new StringBuilder();
        while (!result.isEmpty()) {
            sb.append(result.poll()).append(" ");
        }
        System.out.println(sb);
    }

    private static void process() {
        while (!q.isEmpty()) {
            Deque<Integer> poll = q.poll();
            poll = processList(poll);
            if (!poll.isEmpty()) {
                q.addLast(poll);
            }
        }
    }

    private static Deque<Integer> processList(Deque<Integer> poll) {
        int s = poll.poll();
        while (true) {
            try {
                int next = poll.poll();
                if (s < next) {
                    result.addLast(s);
                    poll.addFirst(next);
                    break;
                }
            } catch (NullPointerException e) {
                result.addLast(s);
                break;
            }

        }
        return poll;
    }

    private static void readInput() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());
        for (int i = 0; i < n; i++) {
            int[] collect = Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            Deque<Integer> temp = new ArrayDeque<>();
            for (Integer integer : collect) {
                temp.addLast(integer);
            }
            q.addLast(temp);
        }
    }

}
