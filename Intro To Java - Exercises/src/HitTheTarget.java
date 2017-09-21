import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class HitTheTarget {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int target = Integer.parseInt(in.nextLine());
        printSummed(target);
        printSubstracted(target);
    }

    private static void printSubstracted(int target) {
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i - j == target) {
                    System.out.printf("%d - %d = %d%n", i, j, target);
                }
            }
        }
    }

    private static void printSummed(int target) {
        for (int i = 1; i <= 20; i++) {
            for (int j = 1; j <= 20; j++) {
                if (i + j == target) {
                    System.out.printf("%d + %d = %d%n", i, j, target);
                }
            }
        }
    }

}
