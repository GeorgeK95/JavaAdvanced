import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SeriesOfLetters {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        String duplicates = removeDuplicates(inputLine.toCharArray(), inputLine);
        System.out.println(duplicates);
    }

    private static String removeDuplicates(char[] inputLine, String line) {
        Set<String> duplicates = new HashSet<>();
        for (int i = 1; i < inputLine.length; i++) {
            if (inputLine[i] == inputLine[i - 1]) {
                duplicates.add(String.valueOf(inputLine[i]));
            }
        }
        for (String duplicate : duplicates) {
            line = line.replaceAll(duplicate + "+", duplicate);
        }
        return line;
    }

}
