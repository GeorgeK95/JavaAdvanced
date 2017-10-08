import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], Integer> smallest = (int[] x) -> Arrays.stream(x).min().getAsInt();
        System.out.println(smallest.apply(numbers));
    }

}
