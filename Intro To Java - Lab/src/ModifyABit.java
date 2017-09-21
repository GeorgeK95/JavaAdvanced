import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ModifyABit {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        int n = Integer.parseInt(line[0]);
        int p = Integer.parseInt(line[1]);
        int v = Integer.parseInt(line[2]);
        System.out.println(modifyBit(n, p, v));
    }

    private static int modifyBit(int n, int p, int v) {
        if (v == 1) {
            return n | (1 << p); //set a bit
        }
        return n & ~(1 << p); //unset a bit
    }

}
