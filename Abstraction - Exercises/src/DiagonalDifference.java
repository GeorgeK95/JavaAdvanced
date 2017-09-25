import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int primary = 0;
        int secondary = 0;
        for (int i = 0; i < n; i++) {
            String[] line = in.nextLine().split("\\s+");
            for (int j = 0; j < line.length; j++) {
                if (i == j) {
                    primary += Integer.parseInt(line[j]);
                }
                if (i == n - 1 - j) {
                    secondary += Integer.parseInt(line[j]);
                }
            }
        }
        System.out.println(Math.abs(primary - secondary));
    }

}
