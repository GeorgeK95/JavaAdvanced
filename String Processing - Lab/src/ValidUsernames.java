import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ValidUsernames {
    public static void main(String[] args) {
        List<String> validUsernames = getValidUsernames();
        print(validUsernames);
    }

    private static List<String> getValidUsernames() {
        List<String> validUsernames = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String pattern = "^[A-Za-z\\d_-]{3,16}$";
        Pattern r = Pattern.compile(pattern);
        while (!line.equals("END")) {
            Matcher m = r.matcher(line);
            if (m.find()) {
                validUsernames.add("valid");
            } else {
                validUsernames.add("invalid");
            }
            line = in.nextLine();
        }

        return validUsernames;
    }

    private static void print(List<String> validUsernames) {
        if (validUsernames.contains("valid")) {
            for (String name : validUsernames) {
                System.out.println(name);
            }
        }
    }


}
