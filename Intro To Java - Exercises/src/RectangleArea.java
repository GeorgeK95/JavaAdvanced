import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RectangleArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        double a = Double.parseDouble(line[0]);
        double b = Double.parseDouble(line[1]);
        System.out.printf("%.2f", a * b);
    }
}
