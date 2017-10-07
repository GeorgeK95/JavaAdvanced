import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class TheStockSpanProblem {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        System.out.println(getCalculatedStockSpanProblem(arr));
    }

    private static StringBuilder getCalculatedStockSpanProblem(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        StringBuilder builder = new StringBuilder();
        builder.append(1).append("\n");
        for (int i = 1; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                builder.append(i - stack.peek()).append("\n");
            } else {
                builder.append(i + 1).append("\n");
            }
            stack.push(i);
        }

        return builder;
    }

}
