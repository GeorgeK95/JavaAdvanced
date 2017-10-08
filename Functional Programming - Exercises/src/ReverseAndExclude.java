import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> collected = Arrays.stream(Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray()).boxed().collect(Collectors.toList());
        int n = Integer.parseInt(in.nextLine());
        Predicate<Integer> personPredicate = x -> x % n == 0;
        collected.removeIf(personPredicate);
        Collections.reverse(collected);
        System.out.println(Arrays.toString(collected.toArray()).replace("]", "").replace("[", "").replace(",", ""));
    }

}
