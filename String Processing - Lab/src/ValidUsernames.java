import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ValidUsernames {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String pattern = "^[A-Za-z\\d_-]{3,16}$";
        Pattern r = Pattern.compile(pattern);

        while (!line.equals("END")) {
            Matcher m = r.matcher(line);
            if (m.find()) {
                System.out.println("valid");
            } else {
                System.out.println("invalid");
            }
            line = in.nextLine();
        }
    }

}
