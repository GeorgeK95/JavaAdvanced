import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class XBits {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        int[] collection = readCollection();
        String[] table = getBinaryTable(collection);
        int xBitsCount = getXBitsCount(table);
        System.out.println(xBitsCount);
    }

    private static int getXBitsCount(String[] table) {
        int c = 0;
        for (int i = 0; i <= 5; i++) {
            for (int j = 0; j <= table.length - 3; j++) {
                String currentTriple = table[i].charAt(j) + "" + table[i].charAt(j + 1) + "" + table[i].charAt(j + 2) + "" +
                        table[i + 1].charAt(j) + "" + table[i + 1].charAt(j + 1) + "" + table[i + 1].charAt(j + 2) + "" +
                        table[i + 2].charAt(j) + "" + table[i + 2].charAt(j + 1) + "" + table[i + 2].charAt(j + 2);
                if (isValidXBit(currentTriple)) {
                    c++;
                }
            }
        }
        return c;
    }

    private static boolean isValidXBit(String currentTriple) {
        List<String> parts = getParts(currentTriple);
        if (parts.get(0).equals("101")) {
            if (parts.get(1).equals("010")) {
                if (parts.get(2).equals("101")) {
                    return true;
                }
            }
        }
        return false;
    }

    private static List<String> getParts(String string) {
        List<String> parts = new ArrayList<String>();
        int len = string.length();
        for (int i = 0; i < len; i += 3) {
            parts.add(string.substring(i, Math.min(len, i + 3)));
        }
        return parts;
    }

    private static String[] getBinaryTable(int[] collection) {
        String[] table = new String[32];
        for (int i = 0; i < collection.length; i++) {
            table[i] = String.format("%32s", Integer.toBinaryString(collection[i])).replace(' ', '0');
        }
        return table;
    }

    private static int[] readCollection() {
        int[] collection = new int[8];
        for (int i = 0; i < 8; i++) {
            collection[i] = Integer.parseInt(in.nextLine());
        }
        return collection;
    }
}
