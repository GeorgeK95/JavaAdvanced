import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ReplaceATag {

    public static void main(String[] args) {
        StringBuilder html = getFullHTML();
        Pattern pattern = Pattern.compile("(<a\\s+href\\s*=\\s*)(.+?)(>)(\\n?.+?)(<\\/a>)");
        Matcher matcher = pattern.matcher(html);

        while (matcher.find()) {
            String replaceTag = "[URL href=" + matcher.group(2) + "]" + matcher.group(4) + "[/URL]";
            html.replace(matcher.start(), matcher.end(), replaceTag);
            matcher = pattern.matcher(html);
        }

        System.out.println(html);
    }

    private static StringBuilder getFullHTML() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        StringBuilder sb = new StringBuilder();
        while (!line.equals("END")) {
            sb.append("\n");
            sb.append(line);
            line = in.nextLine();
        }
        return sb;
    }

}
