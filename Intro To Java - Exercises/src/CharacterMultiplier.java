import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split("\\s+");
        System.out.println(multiplyStrings(line));
    }

    private static int multiplyStrings(String[] line) {
        int sum = 0;
        String shorter = getShorterString(line);
        String longer = getLongerString(line);
        for (int i = 0; i < shorter.length(); i++) {
            int a = line[0].charAt(i);
            int b = line[1].charAt(i);
            sum += a * b;
        }
        if (shorter.length() != longer.length()) {
            String longerSubString = longer.substring(shorter.length());
            for (int i = 0; i < longerSubString.length(); i++) {
                sum += longerSubString.charAt(i);
            }
        }
        return sum;
    }

    private static String getLongerString(String[] line) {
        return line[0].length() > line[1].length() ? line[0] : line[1];
    }


    private static String getShorterString(String[] line) {
        return line[0].length() < line[1].length() ? line[0] : line[1];
    }

}
