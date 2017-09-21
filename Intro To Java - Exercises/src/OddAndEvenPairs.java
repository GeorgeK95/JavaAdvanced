import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class OddAndEvenPairs {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        if (line.length % 2 != 0) {
            System.out.println("invalid length");
        } else {
            for (int i = 0; i < line.length; i += 2) {
                int a = Integer.parseInt(line[i]);
                int b = Integer.parseInt(line[i + 1]);
                printResult(a, b);
            }
        }
    }

    private static void printResult(int a, int b) {
        if (a % 2 == 0 && b % 2 == 0) {
            System.out.printf("%d, %d -> both are even%n", a, b);
        } else if (a % 2 != 0 && b % 2 != 0) {
            System.out.printf("%d, %d -> both are odd%n", a, b);
        } else {
            System.out.printf("%d, %d -> different%n", a, b);
        }
    }

}
