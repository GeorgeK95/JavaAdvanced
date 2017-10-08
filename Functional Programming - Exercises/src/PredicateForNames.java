import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class PredicateForNames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        List<String> data = Arrays.stream(in.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> isLessOrEqual = x -> x.length() <= n;
        data.forEach(x -> {
            if (isLessOrEqual.test(x)) {
                System.out.println(x);
            }
        });
    }

}
