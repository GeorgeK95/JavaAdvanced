import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SumNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> collected = Arrays.stream(Arrays.stream(in.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
        Function<List<Integer>, Integer> sumFunc = (list) -> list.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Count = " + collected.size());
        System.out.println("Sum = " + sumFunc.apply(collected));
    }

}
