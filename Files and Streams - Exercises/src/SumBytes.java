import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;


/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SumBytes {
    private static final String path = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\test.txt";

    public static void main(String[] args) {
        printAsciiSum();

    }

    private static void printAsciiSum() {
        long sum = 0;
        File f = new File(path);
        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            for (String line; (line = br.readLine()) != null; ) {
                sum += findSumOfCurrentLine(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sum);
    }

    private static int findSumOfCurrentLine(String line) {
        int sum = 0;
        for (char c : line.toCharArray()) {
            sum += (int) c;
        }
        return sum;
    }

}
