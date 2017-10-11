import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class UpperStrings {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Arrays.stream(in.nextLine().split("\\s+")).map(String::toUpperCase).forEach(z -> System.out.print(z + " "));
    }

}
