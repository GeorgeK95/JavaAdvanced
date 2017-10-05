import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String name = in.nextLine();
            double[] avgGrade = Arrays.stream(in.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();//.average().getAsDouble();
            System.out.printf("%s is graduated with %s%n", name, avg(avgGrade));
        }
    }

    private static String avg(double[] avgGrade) {
        double res = 0;
        for (double v : avgGrade) {
            res += v;
        }
        return (res / avgGrade.length) + "";
    }
}
