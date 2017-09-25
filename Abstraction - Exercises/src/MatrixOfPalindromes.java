import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        int r = Integer.parseInt(line[0]);
        print(r);
    }

    private static void print(int r) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < r; j++) {
                String str = Character.toString((char) (i + 97)) + "" + Character.toString((char) (i + 97 + j)) + "" + Character.toString((char) (i + 97));
                System.out.printf("%s ", str);
            }
            System.out.println();
        }
    }

}
