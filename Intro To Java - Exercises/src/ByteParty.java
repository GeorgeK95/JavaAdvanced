import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ByteParty {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int n = Integer.parseInt(in.nextLine());
        int[] collection = readCollection(n);
        executeCommands(n, collection);
    }

    private static int[] readCollection(int n) {
        int[] collection = new int[n];
        for (int i = 0; i < n; i++) {
            collection[i] = Integer.parseInt(in.nextLine());
        }
        return collection;
    }

    private static void executeCommands(int n, int[] collection) {
        String command = in.nextLine();
        while (!command.equals("party over")) {
            int num = Integer.parseInt(command.split("\\s+")[0]);
            int position = Integer.parseInt(command.split("\\s+")[1]);
            switch (num) {
                case -1:
                    for (int i = 0; i < collection.length; i++) {
                        int element = collection[i];
                        collection[i] = element ^ (1 << position);
                    }
                    break;
                case 0:
                    for (int i = 0; i < collection.length; i++) {
                        int element = collection[i];
                        collection[i] = element & ~(1 << position);
                    }
                    break;
                case 1:
                    for (int i = 0; i < collection.length; i++) {
                        int element = collection[i];
                        collection[i] = element | (1 << position);
                    }
                    break;
            }
            command = in.nextLine();
        }

        printResult(collection);
    }

    private static void printResult(int[] collection) {
        for (int i : collection) {
            System.out.printf("%d%n", i);
        }
    }

}
