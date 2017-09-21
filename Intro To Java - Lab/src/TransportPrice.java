import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class TransportPrice {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        String day = in.nextLine();
        printPrice(n, day);
    }

    private static void printPrice(int n, String day) {
        if (n < 20) {
            switch (day) {
                case "day":
                    System.out.printf("%.2f", n * 0.79 + 0.70);
                    break;
                case "night":
                    System.out.printf("%.2f", n * 0.90 + 0.70);
                    break;
            }
        } else if (n >= 20 && n < 100) {
            System.out.printf("%.2f", n * 0.09);
        } else if (n >= 100) {
            System.out.printf("%.2f", n * 0.06);
        }
    }
}
