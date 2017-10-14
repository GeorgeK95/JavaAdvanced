import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SumLines {
    private static final String path = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\test.txt";

    public static void main(String[] args) {
        printLinesSum();
    }

    private static int findSumOfCurrentLine(String line) {
        int sum = 0;
        for (char c : line.toCharArray()) {
            sum += (int) c;
        }
        return sum;
    }

    private static void printLinesSum() {
        File f = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (String line; (line = br.readLine()) != null; ) {
                System.out.println(findSumOfCurrentLine(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
