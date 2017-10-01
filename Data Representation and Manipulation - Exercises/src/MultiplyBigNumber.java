import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String num1 = in.nextLine();
        int num2 = Integer.parseInt(in.nextLine());
        multiplyBigNumbers(num1, num2);
    }

    private static void multiplyBigNumbers(String num1, int num2) {
        if (num1.equals("0") || num2 == 0) {
            System.out.println(0);
        } else {
            System.out.println(getResult(num1, num2));
        }
    }

    private static String getResult(String num1, int num2) {
        String total = "";
        int remainder = num2 % 2;
        num2 /= 2;

        for (int i = 0; i < num2; i++) {
            String result = sumNumbers(num1, num1);
            if (i == 0) {
                total = result;
            } else {
                total = sumNumbers(total, result);
            }
        }

        if (remainder == 1) {
            total = sumNumbers(total, num1);
        }
        return total;
    }

    private static String sumNumbers(String num1, String num2) {
        if (num1.length() > num2.length()) {
            num2 = roundUpWithZeroes(new StringBuilder(num2), num1.length() - num2.length());
        } else if (num1.length() < num2.length()) {
            num1 = roundUpWithZeroes(new StringBuilder(num1), num2.length() - num1.length());
        }

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

    private static String roundUpWithZeroes(StringBuilder str, int length) {
        for (int i = 0; i < length; i++) {
            str = str.insert(0, "0");
        }

        return str.toString();
    }

}