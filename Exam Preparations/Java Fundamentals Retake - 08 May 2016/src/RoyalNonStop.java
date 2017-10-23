import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RoyalNonStop {
    private static BigDecimal check = new BigDecimal(0);
    private static int clients = 0;
    private static double[] prices = new double[2];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.nextLine();
        String[] pricesInput = in.nextLine().split("\\s+");
        prices[0] = Double.parseDouble(pricesInput[0]);
        prices[1] = Double.parseDouble(pricesInput[1]);
        while (true) {
            String line = in.nextLine();
            if ("Royal Close".equals(line)) {
                print();
                break;
            }
            serveClient(line.split("\\s+"));
            clients++;
        }
    }

    private static void print() {
        System.out.println(check.setScale(6, RoundingMode.HALF_EVEN));
        System.out.println(clients);
    }

    private static void serveClient(String[] split) {
        int startRow = Integer.parseInt(split[0]);
        int startCol = Integer.parseInt(split[1]);
        if (startRow >= startCol) {
            traverseLeftTop(startRow, startCol);
        } else {
            traverseTopLeft(startRow, startCol);
        }
    }

    private static void traverseTopLeft(int startRow, int startCol) {
        //TOP
        for (int i = startRow; i >= 0; i--) {
            BigDecimal sum = new BigDecimal((startCol + 1) * (i + 1) * prices[i % 2]);
            check = check.add(sum);
        }
        //LEFT
        for (int i = startCol - 1; i > 0; i--) {
            BigDecimal sum = new BigDecimal((i + 1) * prices[0]);
            check = check.add(sum);
        }
    }

    private static void traverseLeftTop(int startRow, int startCol) {
        //LEFT
        for (int i = startCol; i >= 0; i--) {
            BigDecimal sum = new BigDecimal((startRow + 1)).multiply(new BigDecimal(i + 1)).multiply(new BigDecimal(prices[startRow % 2]));
            check = check.add(sum);
        }
        //TOP
        for (int i = startRow - 1; i > 0; i--) {
            BigDecimal sum = new BigDecimal(i + 1).multiply(new BigDecimal(prices[i % 2]));
            check = check.add(sum);
        }
    }

}
