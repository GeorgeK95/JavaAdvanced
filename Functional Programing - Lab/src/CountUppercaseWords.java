import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split("\\s+");
        Predicate<String> isStartWithUpper = (x) -> x.charAt(0) == x.toUpperCase().charAt(0);
        List<String> res = Arrays.stream(data).filter(isStartWithUpper).collect(Collectors.toList());
        System.out.println(res.size());
        res.forEach(System.out::println);
    }

}
