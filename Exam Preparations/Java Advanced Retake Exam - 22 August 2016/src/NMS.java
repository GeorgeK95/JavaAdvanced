import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class NMS {
    private static List<String> words = new ArrayList<>();
    private static String splitter;

    public static void main(String[] args) {
        //read whole input to single sb
        StringBuilder sb = generateInput();
        iterate(sb);
    }

    private static StringBuilder generateInput() {
        StringBuilder sb = new StringBuilder();
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if ("---NMS SEND---".equalsIgnoreCase(line)) {
                splitter = in.nextLine();
                break;
            }
            sb.append(line);
        }
        return sb;
    }

    private static void iterate(StringBuilder sb) {
        //iterate
        StringBuilder seq = new StringBuilder();
        for (char currChar : sb.toString().toCharArray()) {
            if (seq.length() == 0) {
                seq.append(currChar);
            } else {
                if (Character.toLowerCase(currChar) >= Character.toLowerCase(seq.charAt(seq.length() - 1))) {
                    seq.append(currChar);
                } else {
                    words.add(seq.toString());
                    seq.setLength(0);
                    seq.append(currChar);
                }
            }
        }
        words.add(seq.toString());
        generateOutput(splitter);
    }

    private static void generateOutput(String splitter) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            if (i != words.size() - 1)
                System.out.printf("%s%s", word, splitter);
            else
                System.out.printf("%s", word);
        }
    }

}
