import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ParseTags {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        parseTags(text);
    }

    private static void parseTags(String text) {
        String openTag = "<upcase>";
        String closeTag = "</upcase>";
        while (text.contains(openTag)) {
            int i = text.indexOf(openTag);
            int j = text.indexOf(closeTag, i);
            String substring = text.substring(i + openTag.length(), j);
            String temp = "";
            temp = temp.concat(text.substring(0, i));
            temp = temp.concat(substring.toUpperCase());
            temp = temp.concat(text.substring(j + closeTag.length()));
            text = temp;
        }
        System.out.println(text);
    }

}
