import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Palindromes {
    public static void main(String[] args) {
        char[] separators = new char[]{' ', '!', '.', ',', '\\', '/', '?'};
        Scanner in = new Scanner(System.in);
        List<String> text = Arrays.stream(in.nextLine().split("[" + String.valueOf(separators) + "]")).filter(x -> !x.equals("")).collect(Collectors.toList());
        Set<String> palindromes = new TreeSet<>();

        for (int i = 0; i < text.size(); i++) {
            if (isWordPalindrome(text.get(i))) {
                palindromes.add(text.get(i));
            }
        }

        printPalindromes(palindromes);
    }

    private static void printPalindromes(Set<String> palindromes) {
        System.out.println(palindromes);
    }

    private static boolean isWordPalindrome(String s) {
        String reversed = new StringBuilder(s).reverse().toString();
        return s.equals(reversed);
    }

}
