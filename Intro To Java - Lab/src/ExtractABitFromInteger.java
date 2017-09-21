import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ExtractABitFromInteger {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        System.out.println(getBit(Integer.parseInt(line[0]), Integer.parseInt(line[1])));
    }

    private static int getBit(int n, int p) {
        return (n >> p) & 1;
    }

}
