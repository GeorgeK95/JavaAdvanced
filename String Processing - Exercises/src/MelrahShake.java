import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MelrahShake {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder line = new StringBuilder(in.nextLine());
        String pattern = in.nextLine();

        while (true) {
            if (pattern.length() == 0) {
                System.out.println("No shake.");
                System.out.println(line);
                break;
            }
            line = removeFirstAndLast(line, pattern);
            if (line == null) {
                break;
            }
            System.out.println("Shaked it.");
            pattern = editPattern(pattern);
        }

    }

    private static String editPattern(String pattern) {
        int index = pattern.length() / 2;
        return pattern.substring(0, index) + pattern.substring(index + 1);
    }

    private static StringBuilder removeFirstAndLast(StringBuilder line, String pattern) {
        int firstIndex = line.indexOf(pattern);
        int lastIndex = line.lastIndexOf(pattern);

        if (firstIndex == -1 || lastIndex == -1 || firstIndex == lastIndex) {
            System.out.println("No shake.");
            System.out.println(line);
            return null;
        }

        line = line.replace(firstIndex, firstIndex + pattern.length(), "");
        line = line.replace(lastIndex - pattern.length(), lastIndex, "");
        return line;
    }
}
