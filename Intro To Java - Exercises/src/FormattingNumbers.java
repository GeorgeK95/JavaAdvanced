import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FormattingNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        int a = Integer.parseInt(line[0]);
        double b = Double.parseDouble(line[1]);
        double c = Double.parseDouble(line[2]);

        String aHex = Integer.toString(a, 16).toUpperCase();
        String aBin = Integer.toString(a, 2);
        String bFormatted = String.format("%.02f", b);
        String cFormatted = String.format("%.03f", c);

        print(aHex, aBin, bFormatted, cFormatted);
    }

    private static void print(String hexStr, String binStr, String bFormatted, String cFormatted) {
        printLeftAligned(hexStr);
        printBinaryString(binStr);
        printRightAligned(bFormatted);
        printLeftAligned(cFormatted);
    }

    private static void printBinaryString(String binStr) {
        for (int i = 0; i < 10 - binStr.length(); i++) {
            System.out.printf("%d", 0);
        }
        System.out.printf(binStr);
        System.out.printf("|");
    }

    private static void printLeftAligned(String element) {
        System.out.printf("|" + element);
        for (int i = 0; i < 10 - element.length(); i++) {
            System.out.printf(" ");
        }
        System.out.printf("|");
    }

    private static void printRightAligned(String element) {
        for (int i = 0; i < 10 - String.valueOf(element).length(); i++) {
            System.out.printf(" ");
        }
        System.out.printf("%s", String.valueOf(element));
    }

}
