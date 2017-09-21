import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CalculateExpression {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        double a = Double.parseDouble(line[0]);
        double b = Double.parseDouble(line[1]);
        double c = Double.parseDouble(line[2]);
        double f1 = calculateF1(a, b, c);
        double f2 = calculateF2(a, b, c);
        double diff = calculateDifference(a, b, c, f1, f2);
        System.out.printf("F1 result: %.2f; F2 result: %.2f; Diff: %.2f", f1, f2, diff);
    }

    private static double calculateDifference(double a, double b, double c, double f1, double f2) {
        double f3 = Math.abs(((a + b + c) / 3) - (f1 + f2) / 2);
        return f3;
    }

    private static double calculateF2(double a, double b, double c) {
        double f2 = Math.pow((a * a + b * b - c * c * c), (a - b));
        return f2;
    }

    private static double calculateF1(double a, double b, double c) {
        double f1 = Math.pow((a * a + b * b) / (a * a - b * b), ((a + b + c) / Math.sqrt(c)));
        return f1;
    }

}
