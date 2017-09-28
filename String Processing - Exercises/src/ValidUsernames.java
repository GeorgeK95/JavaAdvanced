import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ValidUsernames {
    public static void main(String[] args) {
        List<String> validNames = getValidUserNames();
        printBestCouple(validNames);
    }

    private static void printBestCouple(List<String> validNames) {
        int best = 0;
        String first = null;
        String second = null;
        for (int i = 0; i < validNames.size() - 1; i++) {
            String current = validNames.get(i);
            String next = validNames.get(i + 1);
            int currentLength = current.length() + next.length();
            if (currentLength > best) {
                best = currentLength;
                first = current;
                second = next;
            }
        }
        System.out.println(first);
        System.out.println(second);
    }

    private static List<String> getValidUserNames() {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        return Arrays.stream(line.split("[()\\\\/ ]"))
                .filter(x -> !x.isEmpty() && isValidName(x))
                .collect(Collectors.toList());
    }

    private static boolean isValidName(String currentName) {
        String regex = "^[A-Za-z][A-Za-z\\d\\_]{2,24}$";
        Matcher matcher = Pattern.compile(regex).matcher(currentName);
        return matcher.matches();
    }


}
