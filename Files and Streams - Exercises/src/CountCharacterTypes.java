import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CountCharacterTypes {
    private static List<Character> punctuationsList = Arrays.asList('!', '.', ',', '?');
    private static List<Character> vowelsList = Arrays.asList('a', 'e', 'i', 'o', 'u');
    private static final String inputPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testIn.txt";
    private static int vowels = 0;
    private static int consonants = 0;
    private static int punctuations = 0;

    public static void main(String[] args) {
        count();
        printResult();
    }

    private static void printResult() {
        System.out.printf("Vowels: %d\n" +
                "Consonants: %d\n" +
                "Punctuation: %d\n", vowels, consonants, punctuations);
    }

    private static void count() {
        File f = new File(inputPath);
        try {
            Scanner in = new Scanner(f);
            while (in.hasNext()) {
                String next = in.next();
                countVowels(next);
                countConsonants(next);
                countPunctuations(next);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void countPunctuations(String next) {
        for (char c : next.toCharArray()) {
            if (punctuationsList.contains(c)) {
                punctuations++;
            }
        }
    }

    private static void countConsonants(String next) {
        for (char c : next.toCharArray()) {
            if (!vowelsList.contains(c) && !punctuationsList.contains(c)) {
                consonants++;
            }
        }
    }

    private static void countVowels(String next) {
        for (char c : next.toCharArray()) {
            if (vowelsList.contains(c)) {
                vowels++;
            }
        }
    }

}
