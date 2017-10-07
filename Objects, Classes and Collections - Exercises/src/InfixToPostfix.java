import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InfixToPostfix {
    private static Deque<Operator1> operators = new ArrayDeque<>();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        doPostFix(line);
        print();
    }

    private static void doPostFix(String[] line) {
        for (String current : line) {
            try {
                if (current.equals("x")) {
                    sb.append(current);
                    sb.append(" ");
                    continue;
                }

                int parsed = Integer.parseInt(current);
                sb.append(parsed);
                sb.append(" ");

            } catch (NumberFormatException e) {
                Operator1 o = new Operator1(current);
                if (current.equals("(")) {
                    operators.push(o);
                } else if (current.equals(")")) {
                    Operator1 popped = operators.pop();
                    while (!popped.getValue().equals("(")) {
                        sb.append(popped.getValue());
                        sb.append(" ");
                        popped = operators.pop();
                    }
                } else {
                    while (!operators.isEmpty() && operators.peek().getPrecedence() >= o.getPrecedence()) {
                        sb.append(operators.pop().getValue());
                        sb.append(" ");
                    }
                    operators.push(o);
                }
            }


        }
    }

    private static void print() {
        while (true) {
            sb.append(operators.pop().getValue());
            if (operators.isEmpty()) {
                break;
            }
            sb.append(" ");
        }

        for (char operator : sb.toString().toCharArray()) {
            System.out.print(operator);
        }
    }

}

class Operator {
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

    public Operator(String value) {
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