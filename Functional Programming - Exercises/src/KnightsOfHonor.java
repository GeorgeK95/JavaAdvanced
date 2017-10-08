import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] data = in.nextLine().split("\\s+");
        Consumer<String[]> c = (String[] x) -> Arrays.stream(x).forEach(y -> System.out.println("Sir " + y));
        c.accept(data);
    }

}
