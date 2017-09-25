import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CollectTheCoins {
    private static Scanner in = new Scanner(System.in);
    private static int coins = 0;
    private static int wall = 0;

    public static void main(String[] args) {
        List<List<Character>> array = getArray();
        String commands = in.nextLine();
        executeCommands(commands, array);//, 0, 0
        System.out.printf("Coins = %d%nWalls = %d", coins, wall);
    }

    private static void executeCommands(String commands, List<List<Character>> array) {
        int r = 0;
        int c = 0;
        for (char command : commands.toCharArray()) {
            switch (command) {
                case 'V':
                    try {
                        move(array, r + 1, c);
                        r += 1;
                    } catch (IndexOutOfBoundsException i) {
                        wall++;
                    }
                    break;
                case '^':
                    try {
                        move(array, r - 1, c);
                        r -= 1;
                    } catch (IndexOutOfBoundsException i) {
                        wall++;
                    }
                    break;
                case '>':
                    try {
                        move(array, r, c + 1);
                        c += 1;
                    } catch (IndexOutOfBoundsException i) {
                        wall++;
                    }
                    break;
                case '<':
                    try {
                        move(array, r, c - 1);
                        c -= 1;
                    } catch (IndexOutOfBoundsException i) {
                        wall++;
                    }
                    break;
            }
        }
    }

    private static void move(List<List<Character>> array, int r, int c) throws IndexOutOfBoundsException {
        Character newCell = array.get(r).get(c);
        if (newCell.equals('$')) {
            coins++;
        }
    }

    private static List<List<Character>> getArray() {
        List<List<Character>> outer = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            String s = in.nextLine();
            List<Character> inner = new ArrayList<>();
            for (char c : s.toCharArray()) {
                inner.add(c);
            }
            outer.add(inner);
        }

        return outer;
    }


}
