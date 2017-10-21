package ExamPreparation_2;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class BitRoller {
    private static int SIZE = 19;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BigInteger n = new BigInteger(in.nextLine());
        BigInteger one = new BigInteger("1");
        int index = Integer.parseInt(in.nextLine());
        int rolls = Integer.parseInt(in.nextLine());

        for (int i = 0; i < rolls; i++) {
            BigInteger mostRightBit = n.and(one);
            n = n.shiftRight(1);
            mostRightBit = mostRightBit.shiftLeft(18);
            n = n.or(mostRightBit);

            if (index - 1 < 0) {
                n = n.andNot((one.shiftLeft(SIZE - 1))); //7 bit to 0
                n = n.or(one);
                continue;
            }
            BigInteger seventh = n.shiftRight(index - 1).and(one);
            BigInteger eith = n.shiftRight(index).and(one);

            //my_byte = my_byte & ~(1 << pos);
            n = n.andNot((one.shiftLeft(index - 1))); //7 bit to 0
            n = n.andNot((one.shiftLeft(index))); //8 bit to 0

            if (seventh.equals(one)) {
                //my_byte = my_byte | (1 << pos);
                n = n.or(one.shiftLeft(index)); //8 bit to 1
            } else {
                n = n.andNot((one.shiftLeft(index))); //8 bit to 0
            }

            if (eith.equals(one)) {
                n = n.or(one.shiftLeft(index - 1)); //7 bit to 1
            } else {
                n = n.andNot((one.shiftLeft(index - 1))); //7 bit to 0
            }
        }
        System.out.println(n);
    }
}
