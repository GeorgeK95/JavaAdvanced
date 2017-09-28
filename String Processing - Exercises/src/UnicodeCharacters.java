import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class UnicodeCharacters {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        for (int i = 0; i < input.length(); i++) {
            System.out.print(getEscapeSequence(input.charAt(i)));
        }
    }

    private static String getEscapeSequence(char c) {
        return "\\u".concat(Integer.toHexString(c | 0x10000).substring(1));
    }
}
