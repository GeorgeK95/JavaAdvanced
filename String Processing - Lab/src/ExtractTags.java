import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ExtractTags {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<String> tags = new ArrayList<>();
        while (true) {
            String line = in.nextLine().trim();
            if (line.equals("END")) {
                break;
            }
            String pattern = "<.*?>";
            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(line);
            while (m.find()) {
                tags.add(m.group());
                line = line.replace(m.group(), "");
            }
        }
        printTags(tags);
    }

    private static void printTags(List<String> tags) {
        for (String tag : tags) {
            System.out.println(tag);
        }
    }

}
