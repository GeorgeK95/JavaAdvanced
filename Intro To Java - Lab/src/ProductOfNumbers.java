import java.math.BigInteger;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ProductOfNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        BigInteger firstNumber = new BigInteger(line[0]);
        BigInteger secondNumber = new BigInteger(line[1]);
        BigInteger product = findProduct(firstNumber, secondNumber);
        System.out.printf("product[%d..%d] = %d", firstNumber, secondNumber, product);
    }

    private static BigInteger findProduct(BigInteger i, BigInteger j) {
        if (Objects.equals(j, i)) {
            return i;
        }
        return j.multiply(findProduct(i, j.subtract(BigInteger.ONE)));
    }
}
