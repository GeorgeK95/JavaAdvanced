import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CountSymbols {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] line = in.nextLine().toCharArray();
        Map<Character, Integer> symbolsCount = getSymbolsCount(line);
        printTable(symbolsCount);
    }

    private static void printTable(Map<Character, Integer> symbolsCount) {
        for (Map.Entry<Character, Integer> iter : symbolsCount.entrySet()) {
            System.out.printf("%c: %d time/s%n", iter.getKey(), iter.getValue());
        }
    }

    private static Map<Character, Integer> getSymbolsCount(char[] line) {
        Map<Character, Integer> table = new TreeMap<>();
        for (char c : line) {
            if (!table.containsKey(c)) {
                table.put(c, 1);
            } else {
                table.put(c, table.get(c) + 1);
            }
        }
        return table;
    }

}
