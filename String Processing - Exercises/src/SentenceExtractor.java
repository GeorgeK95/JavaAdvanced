import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SentenceExtractor {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String keyWord = in.nextLine();
        List<String> col = getSentences();
        printValidOnes(col, keyWord);
    }

    private static void printValidOnes(List<String> col, String keyWord) {
        for (String sentence : col) {
            sentence = trimStart(sentence, " ");
            for (String s : sentence.split("\\s+")) {
                if (s.equalsIgnoreCase(keyWord)) {
                    System.out.println(sentence);
                    break;
                }
            }
        }
    }

    private static List<String> getSentences() {
        String text = in.nextLine();
        String pattern = "[^.!?]*[.!?]";
        Matcher matcher = Pattern.compile(pattern).matcher(text);
        List<String> col = new ArrayList<>();
        while (matcher.find()) {
            col.add(matcher.group());
        }
        return col;
    }

    private static String trimStart(String input, String charsToTrim) {
        return input.replaceAll("^[" + charsToTrim + "]+", "");
    }
}
