import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class test {
    public static void main(String[] args) {
        //"
        StringBuilder sb = new StringBuilder();
        String line = null;
        Scanner in = new Scanner(System.in);

        while (true) {
            line = in.nextLine();
            if (line.equals("END")) {
                break;
            }
            sb.append(line);
        }
        String reg = "<a[^>]*.*?>";
        Matcher matcher = Pattern.compile(reg).matcher(sb.toString());
        List<String> aLinks = new ArrayList<>();
        while (matcher.find()) {
            aLinks.add(matcher.group());
//            System.out.println(matcher.group(1));
        }

        printList(aLinks);

    }

    private static void printList(List<String> aLinks) {
        for (String aLink : aLinks) {
            printHref(aLink);
//            System.out.println(aLink);
        }
    }

    private static void printHref(String aLink) {
        String reg = "";
        String matcher = Pattern.compile(reg).matcher(aLink).group();
        System.out.println(matcher);
    }
}
