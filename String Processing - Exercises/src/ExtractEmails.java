import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ExtractEmails {
    public static void main(String[] args) {
        List<String> emails = getEmails();
        printValidEmails(emails);
    }

    private static void printValidEmails(List<String> emails) {
        for (String allMatch : emails) {
            System.out.println(allMatch);
        }
    }

    private static List<String> getEmails() {
        Scanner in = new Scanner(System.in);
        char[] separators = new char[]{' ', ','};
        return getAllEmails(in.nextLine(), separators);
    }

    private static List<String> getAllEmails(String line, char[] separators) {
        String pattern = "^[a-zA-Z0-9]+([\\.\\-\\_]*[a-zA-Z0-9]+)*@[a-zA-Z]+((\\-|\\.)[a-zA-Z]+)+(\\.[a-zA-Z]+)*$";
        List<String> allMatches = new ArrayList<>();
        List<String> potencialValidEmails = Arrays.stream(line.split("[" + String.valueOf(separators) + "]")).filter(x -> !x.equals("")).collect(Collectors.toList());

        for (String potencialValidEmail : potencialValidEmails) {
            if (!potencialValidEmail.equals("") && potencialValidEmail.charAt(potencialValidEmail.length() - 1) == '.') {
                potencialValidEmail = potencialValidEmail.substring(0, potencialValidEmail.length() - 1);
            }
            Matcher p = Pattern.compile(pattern).matcher(potencialValidEmail);
            while (p.find()) {
                allMatches.add(p.group());
            }
        }

        return allMatches;
    }

}
