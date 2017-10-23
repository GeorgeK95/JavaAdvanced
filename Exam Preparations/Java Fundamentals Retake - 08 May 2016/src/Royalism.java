import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Royalism {
    private static List<String> royalists = new ArrayList<>();
    private static List<String> nonroyalists = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String[] data = line.split("\\s+");
        for (String word : data) {
            writeData(word);
        }
        print();
    }

    private static void print() {
        if (royalists.size() >= nonroyalists.size()) {
            System.out.printf("Royalists - %d%n", royalists.size());
            for (String royalist : royalists) {
                System.out.printf("%s%n", royalist);
            }
            System.out.println("All hail Royal!");
        } else {
            for (String nonroyalist : nonroyalists) {
                System.out.println(nonroyalist);
            }
            System.out.println("Royalism, Declined!");
        }
    }

    private static void writeData(String currentWord) {
        int sum = 0;
        for (char c : currentWord.toCharArray()) {
            sum += (int) c;
            while (sum > 26) {
                sum -= 26;
            }
        }
        if (sum == 18) {
            royalists.add(currentWord);
        } else {
            nonroyalists.add(currentWord);
        }
    }

}
