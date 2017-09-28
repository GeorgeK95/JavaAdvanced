import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SumOfAllValues {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String key = in.nextLine();
        String text = in.nextLine();

        String startKey = getStartKey(key);
        String endKey = getEndKey(key);

        if (!startKey.isEmpty() && !endKey.isEmpty()) {
            printValue(startKey, endKey, text);
        } else {
            System.out.println("<p>A key is missing</p>");
        }
    }

    private static void printValue(String startKey, String endKey, String text) {
        double sum = calculateValue(startKey, endKey, text);
        if (sum == 0) {
            System.out.println("<p>The total value is: <em>nothing</em></p>");
        } else {
            DecimalFormat df = new DecimalFormat("#.##");
            System.out.printf("<p>The total value is: <em>%s</em></p>", df.format(sum));
        }
    }

    private static double calculateValue(String startKey, String endKey, String text) {
        String pat = startKey + "(.*?)" + endKey;
        Matcher matcher = Pattern.compile(pat).matcher(text);
        double sum = 0;

        while (matcher.find()) {
            try {
                double curr = Double.parseDouble(matcher.group(1));
                sum += curr;
            } catch (NumberFormatException ignored) {
            }
        }
        return sum;
    }

    private static String getEndKey(String key) {
        String endKeyPattern = "\\d([a-zA-Z_]+)$";
        Matcher m = Pattern.compile(endKeyPattern).matcher(key);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

    private static String getStartKey(String key) {
        String startKeyPattern = "^([a-zA-Z_]+)\\d";
        Matcher m = Pattern.compile(startKeyPattern).matcher(key);
        if (m.find()) {
            return m.group(1);
        }
        return "";
    }

}
