import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MagicExchangeableWords {
    static String str_1;
    static String str_2;
    static Map<Character, Character> letters = new HashMap<>();
    static boolean isExchangleable = true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        str_1 = line.split(" ")[0];
        str_2 = line.split(" ")[1];

        changeStrings();
        iterateToShorterString();
        iterateFromShorterStringToEndOfLongerOne();

        printResult();
    }

    private static void printResult() {
        if (isExchangleable) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }

    private static void iterateFromShorterStringToEndOfLongerOne() {
        if (str_1.length() - str_2.length() != 0) {
            int index = str_2.length();
            for (int i = 0; i < (str_1.length() - str_2.length()); i++) {
                char charStr1 = str_1.charAt(index);
                index++;

                if (!letters.containsKey(charStr1)) {
                    isExchangleable = false;
                    break;
                }

            }
        }
    }

    private static void iterateToShorterString() {
        for (int i = 0; i < str_2.length(); i++) {
            char charStr1 = str_1.charAt(i);
            char charStr2 = str_2.charAt(i);

            if (!letters.containsKey(charStr1)) {
                letters.put(charStr1, charStr2);
            } else {
                if (!letters.get(charStr1).equals(charStr2)) {
                    isExchangleable = false;
                    break;
                }
            }
        }
    }

    private static void changeStrings() {
        if (str_2.length() > str_1.length()) {
            String a = str_2;
            str_2 = str_1;
            str_1 = a;
        }
    }

}
