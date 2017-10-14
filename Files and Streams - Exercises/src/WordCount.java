import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class WordCount {
    private static final String inputPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private static final String wordsPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testIn.txt";
    private static final String outputPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testOut.txt";
    private static Map<String, Integer> wordsCount = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        readFile();
        writeToFile();
    }

    private static void writeToFile() {
        File f = new File(wordsPath);
        try (PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {
            wordsCount = wordsCount.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getValue,Comparator.reverseOrder()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));
            for (Map.Entry<String, Integer> wordCount : wordsCount.entrySet()) {
                String formattedLine = String.format("%s - %d", wordCount.getKey(), wordCount.getValue());
                pw.print(formattedLine);
                pw.print(System.getProperty("line.separator"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void fillMap() {
        File f = new File(wordsPath);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (String line; (line = br.readLine()) != null; ) {
                String[] words = line.split("\\s+");
                for (String word : words) {
//                    word = word.toLowerCase();
                    wordsCount.put(word, 0);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        File f = new File(inputPath);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (String line; (line = br.readLine()) != null; ) {
                for (String key : wordsCount.keySet()) {
                    line = line.toLowerCase();
                    while (line.contains(key.toLowerCase())) {
                        wordsCount.put(key, wordsCount.get(key) + 1);
                        line = line.replaceFirst(key.toLowerCase(), "");
                    }

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
