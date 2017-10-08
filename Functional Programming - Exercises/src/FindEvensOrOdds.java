import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FindEvensOrOdds {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String line = in.nextLine();
        if (line.equals("odd")) {
            printOdd(numbers[0], numbers[1]);
        } else if (line.equals("even")) {
            printEven(numbers[0], numbers[1]);
        }
    }

    private static void printEven(int bottom, int top) {
        Predicate<Integer> isOdd = (x) -> x % 2 == 0;
        for (int i = bottom; i <= top; i++) {
            if (isOdd.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

    private static void printOdd(int bottom, int top) {
        Predicate<Integer> isOdd = (x) -> x % 2 != 0;
        for (int i = bottom; i <= top; i++) {
            if (isOdd.test(i)) {
                System.out.print(i + " ");
            }
        }
    }

}
