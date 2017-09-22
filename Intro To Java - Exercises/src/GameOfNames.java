import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class GameOfNames {
    private static Scanner in = new Scanner(System.in);
    private static Map<String, Integer> table = new LinkedHashMap<>();

    public static void main(String[] args) {
        int n = Integer.parseInt(in.nextLine());
        calculateResult(n);
    }

    private static void calculateResult(int n) {
        getInput(n);
        fillMap(n);
        printWinner();
    }

    private static void fillMap(int n) {
        for (String name : table.keySet()) {
            for (int i = 0; i < name.length(); i++) {
                int current = name.charAt(i);
                if (current % 2 == 0) {
                    table.put(name, table.get(name) + current);
                } else {
                    table.put(name, table.get(name) - current);
                }
            }
        }
    }

    private static void printWinner() {
        int max = Integer.MIN_VALUE;
        String result = "";
        for (Map.Entry<String, Integer> kvp : table.entrySet()) {
            if (kvp.getValue() > max) {
                max = kvp.getValue();
                result = String.format("The winner is %s - %d points", kvp.getKey(), kvp.getValue());
            }
        }
        System.out.println(result);
    }

    private static void getInput(int n) {
        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            int initialScore = Integer.parseInt(in.nextLine());
            table.put(name, initialScore);
        }
    }

}
