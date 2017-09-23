import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CalculateTriangleAreaMethod {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double b = in.nextDouble();
        System.out.printf("Area = %.2f", calculateArea(a, b));
    }

    private static double calculateArea(double a, double b) {
        return a * b / 2;
    }

}
