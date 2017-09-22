import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FirstOddOrEvenElements {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] collection = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String[] command = in.nextLine().split("\\s+");
        printResult(collection, command);
    }

    private static void printResult(int[] collection, String[] command) {
        int n = Integer.parseInt(command[1]);
        String type = command[2];
        if (type.equals("even")) {
            printEven(n, collection);
        } else if (type.equals("odd")) {
            printOdds(n, collection);
        } else {
            System.out.println("Wrong numbers type.");
        }
    }

    private static void printOdds(int n, int[] collection) {
        int counter = 0;
        for (int i = 0; i < collection.length; i++) {
            if (counter == n) {
                break;
            } else {
                if (collection[i] % 2 != 0) {
                    counter++;
                    System.out.printf("%d ", collection[i]);
                }
            }
        }
    }

    private static void printEven(int n, int[] collection) {
        int counter = 0;
        for (int i = 0; i < collection.length; i++) {
            if (counter == n) {
                break;
            } else {
                if (collection[i] % 2 == 0) {
                    counter++;
                    System.out.printf("%d ", collection[i]);
                }
            }
        }
    }

}
