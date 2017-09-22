import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class TriangleArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int x1 = in.nextInt();
        int y1 = in.nextInt();
        int x2 = in.nextInt();
        int y2 = in.nextInt();
        int x3 = in.nextInt();
        int y3 = in.nextInt();

        int result = (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2)) / 2;
        System.out.println(Math.abs(result));
    }
}