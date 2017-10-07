import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class EvaluateExpression {
    private static Deque<Operator1> operator1s = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        doPostFix(line);
        evaluateExpression();
    }

    private static void evaluateExpression() {
        Deque<String> stack = getStack();
        Deque<Double> numbers = new ArrayDeque<>();

        while (stack.size() >= 1) {
            String current = stack.pop();
            try {
                double num = Double.parseDouble(current);
                numbers.push(num);
            } catch (NumberFormatException e) {
                double num1 = numbers.pop();
                double num2 = numbers.pop();
                double result = calculateResult(num1, num2, current);
                numbers.push(result);
            }
        }

        System.out.println(String.format("%.2f", numbers.pop()));
    }

    private static Deque<String> getStack() {
        List<String> split = Arrays.stream(sb.toString().split("\\s+")).collect(Collectors.toList());
        Collections.reverse(split);
        Deque<String> stack = new ArrayDeque<>();
        for (String s : split) {
            stack.push(s);
        }
        return stack;
    }

    private static double calculateResult(double num1, double num2, String operator) {
        double result = 0D;
        switch (operator) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num2 - num1;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = Math.max(num1, num2) / Math.min(num1, num2);
                break;
        }
        return result;
    }

    private static void doPostFix(String[] line) {
        for (String current : line) {
            try {
                int parsed = Integer.parseInt(current);
                sb.append(parsed);
                sb.append(" ");

            } catch (NumberFormatException e) {
                Operator1 o = new Operator1(current);
                if (current.equals("(")) {
                    operator1s.push(o);
                } else if (current.equals(")")) {
                    Operator1 popped = operator1s.pop();
                    while (!popped.getValue().equals("(")) {
                        sb.append(popped.getValue());
                        sb.append(" ");
                        popped = operator1s.pop();
                    }
                } else {
                    while (!operator1s.isEmpty() && operator1s.peek().getPrecedence() >= o.getPrecedence()) {
                        sb.append(operator1s.pop().getValue());
                        sb.append(" ");
                    }
                    operator1s.push(o);
                }
            }


        }
        while (true) {
            sb.append(operator1s.pop().getValue());
            if (operator1s.isEmpty()) {
                break;
            }
            sb.append(" ");
        }
    }
}

class Operator1 {
    String value;
    int precedence;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getPrecedence() {
        return precedence;
    }

    public Operator1(String value) {
        this.value = value;
        switch (value) {
            case "+":
                this.precedence = 2;
                break;
            case "-":
                this.precedence = 2;
                break;
            case "*":
                this.precedence = 3;
                break;
            case "/":
                this.precedence = 3;
                break;
            /*case "^":
                this.precedence = 4;
                break;*/
            case "(":
                this.precedence = 0;
                break;
        }
    }
}
