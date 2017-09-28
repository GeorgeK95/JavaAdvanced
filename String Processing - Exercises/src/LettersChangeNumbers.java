import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        char[] separators = new char[]{'\t', ' '};
        List<String> string = Arrays.stream(line.split("[" + String.valueOf(separators) + "]")).filter(x -> !x.equals("")).collect(Collectors.toList());
        double total = 0;

        for (String currStr : string) {
            double result = doActionsOnCurrentString(currStr);
            total += result;
        }

        System.out.printf("%.2f", total);
    }

    private static double doActionsOnCurrentString(String currStr) {
        char firstLetter = currStr.charAt(0);
        char lastLetter = currStr.charAt(currStr.length() - 1);
        String str = currStr.substring(1, currStr.length() - 1);
        double result = Double.parseDouble(str);

        boolean isFirstLetterUpper = isUpperFirstLetter(firstLetter);
        boolean isLastLetterUpper = isUpperFirstLetter(lastLetter);

        int firstLetterPosition = getValue(isFirstLetterUpper, firstLetter);
        int lastLetterPosition = getValue(isLastLetterUpper, lastLetter);

        if (isFirstLetterUpper) {
            result /= firstLetterPosition;
        } else {
            result *= firstLetterPosition;
        }

        if (isLastLetterUpper) {
            result -= lastLetterPosition;
        } else {
            result += lastLetterPosition;
        }

        return result;
    }

    private static int getValue(boolean isFirstLetterUpper, char firstLetter) {
        return isFirstLetterUpper ? (int) firstLetter - 64 : (int) firstLetter - 96;
    }

    private static boolean isUpperFirstLetter(char firstLetter) {
        return (int) firstLetter >= 65 && (int) firstLetter <= 90;

    }

}
