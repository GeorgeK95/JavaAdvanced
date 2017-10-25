import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RegularExtensions {
    private static String text;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        text = in.readLine();

        while (true) {
            String pattern = in.readLine();
            if ("Print".equals(pattern)) {
                print();
                break;
            }
            replace(pattern);
        }
    }

    private static void replace(String pattern) {
        String reversed = new StringBuilder(pattern).reverse().toString();
        if (pattern.contains("%")) {
            if (pattern.contains(".")) {
                pattern = pattern.replace(".", "\\.");
            }
            pattern = pattern.replaceAll("%", "[^ ]*");

            Matcher m = Pattern.compile(pattern).matcher(text);
            while (m.find()) {
                String found = m.group();
                reversed = new StringBuilder(found).reverse().toString();
                text = text.replace(found, reversed);
            }
        } else if (text.contains(pattern)) {
            text = text.replace(pattern, reversed);
        }
    }

    private static void print() {
        System.out.println(text);
    }
}
