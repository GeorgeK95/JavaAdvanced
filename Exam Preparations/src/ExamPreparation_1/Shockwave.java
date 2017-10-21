import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Shockwave {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int[][] room = getRoom();
        processShockWave(room);
    }

    private static void processShockWave(int[][] room) {
        while (true) {
            String line = in.nextLine();
            if ("Here We Go".equals(line)) {
                printRoom(room);
                break;
            }
            int[] numbers = Arrays.stream(line.split("\\s+")).mapToInt(Integer::parseInt).toArray();
            increase(numbers[0], numbers[1], numbers[2], numbers[3], room);
        }
    }

    private static void increase(int startRow, int startCol, int destRow, int destCol, int[][] room) {
        for (int i = startRow; i <= destRow; i++) {
            for (int j = startCol; j <= destCol; j++) {
                room[i][j]++;
            }
        }
    }

    private static void printRoom(int[][] room) {
        for (int[] ints : room) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    private static int[][] getRoom() {
        int[] numbers = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        return new int[numbers[0]][numbers[1]];
    }
}
