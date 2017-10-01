import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ExtractHyperlinks {
    public static void main(String[] args) {
        String regex = "<a\\s+[^>]*href\\s*=\\s*('([^']*)|\"([^\"]*)|([^\\s>]+))[^>]*";
        StringBuilder fullInput = readWholeInput();

        Matcher matcher = Pattern.compile(regex).matcher(fullInput);
        while (matcher.find()) {
            for (int i = 4; i >= 1; i--) {
                if (matcher.group(i) != null) {
                    System.out.println(matcher.group(i));
                    break;
                }
            }
        }
    }

    private static StringBuilder readWholeInput() {
        Scanner in = new Scanner(System.in);
        StringBuilder fullInput = new StringBuilder();
        while (true) {
            String line = in.nextLine();
            if (line.equalsIgnoreCase("end")) {
                break;
            }
            fullInput.append(line);
        }
        return fullInput;
    }

}
