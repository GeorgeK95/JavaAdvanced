import java.util.Arrays;
import java.util.Scanner;
import java.util.function.UnaryOperator;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AddVAT {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double[] collected = Arrays.stream(in.nextLine().split(", ")).mapToDouble(Double::parseDouble).toArray();
        UnaryOperator<Double> vatMultiply = num -> num * 1.2;
        System.out.println("Prices with VAT:");
        for (double anInput : collected) {
            System.out.println(String.format("%.2f", vatMultiply.apply(anInput)).replace(".", ","));
        }
    }
}
