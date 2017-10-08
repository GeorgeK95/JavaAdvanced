import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> collected = Arrays.stream(Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
        Function<List<Integer>, Integer> smallestIndex = x -> {
            int min = x.stream().min(Integer::compareTo).get();
            return collected.lastIndexOf(min);
        };
        System.out.println(smallestIndex.apply(collected));
    }

}
