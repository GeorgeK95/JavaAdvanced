import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String phone = in.nextLine();
        String pattern = "^\\+359([ -])2\\1[0-9]{3}\\1[0-9]{4}$";
        while (!phone.equals("end")) {
            if (Pattern.matches(pattern, phone)) {
                System.out.println(phone);
            }
            phone = in.nextLine();
        }
    }

}
