import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SimpleTextEditor {
    private static Deque<Character> mainStack = new ArrayDeque<>();
    private static Deque<String> operationsStack = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split("\\s+");
            int type = Integer.parseInt(line[0]);
            switch (type) {
                case 1:
                    push(line[1], true);
                    break;
                case 2:
                    pop(Integer.parseInt(line[1]),true);
                    break;
                case 3:
                    print(line[1]);
                    break;
                case 4:
                    unDo();
                    break;
            }
        }
    }

    private static void print(String s) {
        int index = Integer.parseInt(s);
        List<Character> temp = mainStack.stream().collect(Collectors.toList());
        Collections.reverse(temp);
        System.out.println(temp.get(index - 1));
    }

    private static void unDo() {
        String poll = operationsStack.poll();
        if (poll.charAt(0) == '1') {
            pop(poll.substring(1).length(), false);
        } else if (poll.charAt(0) == '2') {
            push(poll.substring(1), false);
        }
    }

    private static void pop(int count, boolean isAddToOperationsStack) {
        StringBuilder sb = new StringBuilder();
        if (mainStack.size() >= count) {
            for (int i = 0; i < count; i++) {
                Character pop = mainStack.pop();
                sb.append(pop);
            }
            if (isAddToOperationsStack) {
                operationsStack.push(2 + sb.reverse().toString());
            }
        }
    }

    private static void push(String s, boolean isAddToOperationsStack) {
        for (Character character : s.toCharArray()) {
            mainStack.push(character);
        }

        if (isAddToOperationsStack) {
            operationsStack.push(1 + s);
        }
    }
}