import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class EncryptSortAndPrintArray {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[] names = getNames();
        int[] encryptedScore = calculateNames(names);
        printScore(encryptedScore);
    }

    private static void printScore(int[] encryptedScore) {
        Arrays.sort(encryptedScore);
        for (int i : encryptedScore) {
            System.out.printf("%d%n", i);
        }
    }

    private static int[] calculateNames(String[] names) {
        int[] values = new int[names.length];
        for (int j = 0; j < values.length; j++) {
            String name = names[j];
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
                        c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                    values[j] += (int) c * name.length();
                } else {
                    values[j] += (int) c / name.length();
                }
            }
        }
        return values;
    }

    private static String[] getNames() {
        int n = Integer.parseInt(in.nextLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = in.nextLine();
        }
        return names;
    }

}
