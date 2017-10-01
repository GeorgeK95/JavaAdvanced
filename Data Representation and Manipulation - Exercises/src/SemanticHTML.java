import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SemanticHTML {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String openTagRegex = "<div\\s+.*((?:id|class)\\s*=\\s*\\\"([a-zA-Z]*)\\\").*?>";
        String closeTagRegex = "<\\/div>\\s+(<!--\\s*([a-zA-Z]+)\\s*-->)";
        List<String> fixedLines = new ArrayList<>();

        while (true) {
            String line = in.nextLine();
            if (line.equals("END")) {
                break;
            }
            Matcher openTagMatcher = Pattern.compile(openTagRegex).matcher(line);
            boolean matched = false;
            if (openTagMatcher.find()) {
                line = replaceOpenTag(openTagMatcher, line);
                fixedLines.add(line);
                matched = true;
            }
            Matcher closeTagMatcher = Pattern.compile(closeTagRegex).matcher(line);
            if (closeTagMatcher.find()) {
                line = replaceCloseTag(closeTagMatcher, line);
                fixedLines.add(line);
                matched = true;
            }
            if (!matched) {
                fixedLines.add(line);
            }
        }
        printList(fixedLines);
    }

    private static String replaceCloseTag(Matcher closeTagMatcher, String line) {
        String commented = closeTagMatcher.group(1);
        String newTag = closeTagMatcher.group(2);
        line = line.replace("div", newTag);
        line = line.replace(commented, "");
        return line;
    }

    private static String replaceOpenTag(Matcher openTagMatcher, String line) {
        String remove = openTagMatcher.group(1);
        String newTag = openTagMatcher.group(2);
        line = line.replace("<div", "<" + newTag);
        line = line.replace(remove, "");
        line = line.replaceAll("\\s{2,}", " ");
        line = line.replace(" >", ">");
        return line;
    }

    private static void printList(List<String> fixedLines) {
        for (String fixedLine : fixedLines) {
            System.out.println(fixedLine);
        }
    }

}
