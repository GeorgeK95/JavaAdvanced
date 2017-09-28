import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SumBigNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.nextLine();
        String num2 = in.nextLine();

        if (num1.length() > num2.length()) {
            num2 = RoundUpWithZeroes(new StringBuilder(num2), num1.length() - num2.length());
        } else if (num1.length() < num2.length()) {
            num1 = RoundUpWithZeroes(new StringBuilder(num1), num2.length() - num1.length());
        }

        String res = SumNumbers(num1, num2);
        System.out.println(res);
    }

    private static String SumNumbers(String num1, String num2) {
        StringBuilder res = new StringBuilder();
        int accumulation = 0;

        for (int i = num1.length() - 1; i >= 0; i--) {
            int currNumberNum1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int currNumberNum2 = Integer.parseInt(String.valueOf(num2.charAt(i)));

            int sum = currNumberNum1 + currNumberNum2 + accumulation;
            accumulation = 0;

            if (sum >= 10) {
                accumulation++;
                res = res.insert(0, (sum - 10));
            } else {
                accumulation = 0;
                res = res.insert(0, sum);
            }

            if (i == 0 && accumulation != 0) {
                res = res.insert(0, accumulation);
            }
        }

        return removeUnnecessaryZeros(res);
    }

    private static String removeUnnecessaryZeros(StringBuilder res) {
        char c = res.charAt(0);
        while (c == '0') {
            res = res.delete(0, 1);
            c = res.charAt(0);
        }
        return res.toString();

    }

    private static String RoundUpWithZeroes(StringBuilder str, int length) {
        for (int i = 0; i < length; i++) {
            str = str.insert(0, "0");
        }

        return str.toString();
    }

}
