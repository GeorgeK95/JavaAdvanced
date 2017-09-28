import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class TextFilter {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] words = in.nextLine().split("[, ]");
        String text = in.nextLine();

        for (int i = 0; i < words.length; i++) {
            String stars = "";
            for (int j = 0; j < words[i].length(); j++) {
                stars += "*";
            }
            text = text.replace(words[i], stars);
        }

        System.out.println(text);
    }
}
