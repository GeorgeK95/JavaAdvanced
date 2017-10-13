import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class LittleJohn {
    private static Map<String, Integer> arrowsCount = new TreeMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        arrowsCount.putIfAbsent("small", 0);
        arrowsCount.putIfAbsent("medium", 0);
        arrowsCount.putIfAbsent("large", 0);
        for (int i = 0; i < 4; i++) {
            String line = in.nextLine();
            Matcher matcher = Pattern.compile("(>-{5}>)|(>>-{5}>)|(>>>-{5}>>)").matcher(line);
            writeData(line, matcher);
        }
        printResult();
    }

    private static void printResult() {
        String num = arrowsCount.get("small") + "" + arrowsCount.get("medium") + "" + arrowsCount.get("large");
        String binary = Integer.toString(Integer.parseInt(num), 2);
        String binaryReversed = new StringBuilder(binary).reverse().toString();
        String resultString = binary + binaryReversed;
        int result = Integer.parseInt(resultString, 2);
        System.out.println(result);
    }

    private static String reverseString(String num) {
        StringBuilder sb = new StringBuilder();
        for (int i = num.length() - 1; i >= 0; i--) {
            sb.append(num.charAt(i));
        }
        return sb.toString();
    }

    private static void writeData(String line, Matcher matcher) {
        while (matcher.find()) {
            if (matcher.group(1) != null) {
                arrowsCount.put("small", arrowsCount.get("small") + 1);
            } else if (matcher.group(2) != null) {
                arrowsCount.put("medium", arrowsCount.get("medium") + 1);
            } else {
                arrowsCount.put("large", arrowsCount.get("large") + 1);
            }
        }


    }

}
