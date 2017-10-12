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
        String small = ">----->";
        String medium = ">>----->";
        String large = ">>>----->>";
        arrowsCount.putIfAbsent(small, 0);
        arrowsCount.putIfAbsent(medium, 0);
        arrowsCount.putIfAbsent(large, 0);
        for (int i = 0; i < 4; i++) {
            String line = in.nextLine();
            line = writeData(line, large);
            line = writeData(line, medium);
            line = writeData(line, small);
        }
        String num = arrowsCount.get(small) + "" + arrowsCount.get(medium) + "" + arrowsCount.get(large);
        String binary = Integer.toString(Integer.parseInt(num), 2);
        String binaryReversed = reverseString(binary);
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

    private static String writeData(String line, String type) {
        Matcher matcher = Pattern.compile(type).matcher(line);
        while (matcher.find()) {
            arrowsCount.put(type, arrowsCount.get(type) + 1);
            line = line.replaceFirst(type, "");
        }

        /*while (line.contains(type)) {
            arrowsCount.put(type, arrowsCount.get(type) + 1);
            line = line.replaceFirst(type, "");
        }*/
        return line;
    }

}
