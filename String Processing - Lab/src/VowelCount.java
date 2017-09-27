import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class VowelCount {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();
        printVowelsCount(inputLine.toLowerCase());
    }

    private static void printVowelsCount(String inputLine) {
        String pattern = "[aeoyui]";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(inputLine);
        int c = 0;
        while (m.find()) {
            c++;
        }
        System.out.println("Vowels: " + c);
    }

}
