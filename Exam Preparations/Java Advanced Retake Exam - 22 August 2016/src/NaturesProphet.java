import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class NaturesProphet {
    private static int[][] garden;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] numbers = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int rows = numbers[0];
        int cols = numbers[1];
        garden = new int[rows][cols];

        while (true) {
            String line = in.nextLine();
            if ("Bloom Bloom Plow".equalsIgnoreCase(line)) {
                printTwoDimensionArray();
                break;
            }
            int[] currentCoordinates = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            fillHorizontal(currentCoordinates[0], currentCoordinates[1]);
            fillVertical(currentCoordinates[1]);
        }
    }

    private static void fillVertical(int currC) {
        for (int i = 0; i < garden.length; i++) {
            garden[i][currC]++;
        }
    }

    private static void fillHorizontal(int currR, int currC) {
        for (int j = 0; j < garden[currR].length; j++) {
            if (j != currC)
                garden[currR][j]++;
        }
    }

    private static void printTwoDimensionArray() {
        for (int[] ints : garden) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
