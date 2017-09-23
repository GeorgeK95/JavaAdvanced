import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class PascalsTriangle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        printPascalsTriangle(n);
    }

    private static void printPascalsTriangle(int n) {
        BigInteger[] previousRow;
        BigInteger[] currentRow = {BigInteger.ONE};
        printArray(currentRow);
        previousRow = currentRow;
        for (int i = 2; i <= n; i++) {
            currentRow = new BigInteger[i];
            currentRow[0] = BigInteger.ONE;
            currentRow[i - 1] = BigInteger.ONE;
            for (int j = 0; j <= i - 3; j++) {
                currentRow[j + 1] = previousRow[j].add(previousRow[j + 1]);
            }
            printArray(currentRow);
            previousRow = currentRow;
        }
    }

    private static void printArray(BigInteger[] array) {
        for (BigInteger anArray : array) {
            System.out.print(anArray + " ");
        }
        System.out.println();
    }
}
