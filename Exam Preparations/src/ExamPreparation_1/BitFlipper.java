package ExamPreparation_1;

import java.math.BigInteger;
import java.util.Scanner;

public class BitFlipper {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger num = new BigInteger(in.nextLine());
        BigInteger seven = new BigInteger("7");
        BigInteger zero = new BigInteger("0");

        for (int i = 0; i <= 61; i++) {
            int n = 61 - i;
            BigInteger curr = num.shiftRight(n).and(seven);
            if (curr.equals(seven) || curr.equals(zero)) {
                num = num.xor(seven.shiftLeft(n));
                i += 2;
            }
        }

        System.out.println(num);
    }
}