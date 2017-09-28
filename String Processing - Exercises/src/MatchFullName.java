import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MatchFullName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = in.nextLine();
        String pattern = "^([A-Z][a-z]+) ([A-Z][a-z]+)$";
        while (!name.equals("end")) {
            if (Pattern.matches(pattern, name)) {
                System.out.println(name);
            }
            name = in.nextLine();
        }
    }

}
