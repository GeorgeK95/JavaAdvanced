import java.math.BigDecimal;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class EuroTrip {
    private static final BigDecimal dm = new BigDecimal("4210500000000");
    private static final double pricePerKiloWurst = 1.2;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double input = Double.parseDouble(in.nextLine());
        System.out.printf("%.2f marks", dm.multiply(new BigDecimal(pricePerKiloWurst * input)));
    }
}
