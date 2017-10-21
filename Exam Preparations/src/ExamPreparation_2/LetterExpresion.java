package ExamPreparation_2;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class LetterExpresion {
    public static void main(String[] args) {
        long sum = 0;
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String numberRegex = "(\\d+)";
        Matcher numberMatcher = Pattern.compile(numberRegex).matcher(line);
        String[] words = getWords(line, numberRegex);
        numberMatcher.find();
        sum += Integer.parseInt(numberMatcher.group(1));
        sum = findSum(sum, numberMatcher, words);
        printSum(sum);
    }

    private static String[] getWords(String line, String numberRegex) {
        List<String> asd = Arrays.stream(line.split(numberRegex)).filter(x -> !x.equals(""))
                .collect(Collectors.toList());
        return asd.toArray(new String[asd.size()]);
    }

    private static long findSum(long sum, Matcher numberMatcher, String[] words) {
        int index = 0;

        while (numberMatcher.find()) {
            if (isEvenLength(words[index])) {
                sum += Integer.parseInt(numberMatcher.group(1));
            } else {
                sum -= Integer.parseInt(numberMatcher.group(1));
            }
            index++;
        }
        return sum;

    }

    private static void printSum(long sum) {
        DecimalFormat df = new DecimalFormat("#.#######");
        System.out.println(df.format(sum));
    }

    private static boolean isEvenLength(String word) {
        return word.length() % 2 == 0;
    }

}
