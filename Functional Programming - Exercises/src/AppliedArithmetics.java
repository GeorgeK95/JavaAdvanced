import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AppliedArithmetics {
    private static int[] numbers;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        numbers = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], int[]> increaseByOne = (int[] a) -> Arrays.stream(a).map(x -> x += 1).toArray();
        Function<int[], int[]> decreaseByOne = (int[] a) -> Arrays.stream(a).map(x -> x -= 1).toArray();
        Function<int[], int[]> multiplyByOne = (int[] a) -> Arrays.stream(a).map(x -> x *= 2).toArray();
        Consumer<int[]> print = (int[] x) -> Arrays.stream(x).forEach(y -> System.out.print(y + " "));

        while (true) {
            String line = in.nextLine();
            if (line.equalsIgnoreCase("end")) {
                break;
            }
            switch (line) {
                case "add":
                    numbers = increaseByOne.apply(numbers);
                    break;
                case "subtract":
                    numbers = decreaseByOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiplyByOne.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
        }

    }

}
