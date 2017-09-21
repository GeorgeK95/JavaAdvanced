import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AverageOfThreeNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.printf("%.2f", Arrays.stream(in.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).average().getAsDouble());
    }
}
