import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CountSubstringOccurrences {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String text = in.nextLine();
        String subString = in.nextLine();
        int count = getSubStringOccurrences(text, subString);
        System.out.println(count);
    }

    private static int getSubStringOccurrences(String text, String subString) {
        int p = 0;

        for (int i = 0; i < text.length() - subString.length(); i++) {
            String temp = text.substring(i, subString.length() + i);

            if (subString.toLowerCase().equals(temp.toLowerCase())) {
                p++;
            }
        }

        return p;
    }
}
