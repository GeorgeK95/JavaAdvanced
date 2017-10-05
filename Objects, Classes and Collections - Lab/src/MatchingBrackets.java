import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < line.length(); i++) {
            char current = line.charAt(i);
            if (current == '(') {
                stack.push(i);
            } else if (current == ')') {
                int stackIndex = stack.pop();
                String subString = line.substring(stackIndex, i + 1);
                System.out.println(subString);
            }
        }
    }
}
