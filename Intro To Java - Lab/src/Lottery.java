/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Lottery {
    public static void main(String[] args) {
        for (int i = 1; i <= 8; i++) {
            for (int j = i + 1; j <= 9; j++) {
                for (int p = j + 1; p <= 10; p++) {
                    System.out.printf("%d %d %d%n", i, j, p);
                }
            }

        }
    }
}
