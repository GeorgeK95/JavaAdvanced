import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class WriteToAFile {
    private static final List<Character> symbols = Arrays.asList(',', '.', '!', '?');
    private static final String inputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private static final String outputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\output_task_2.txt";

    public static void main(String[] args) {
        write();
    }

    private static void write() {
        try (FileInputStream fis = new FileInputStream(inputTxtPath); FileOutputStream fos = new FileOutputStream(outputTxtPath)) {
            int currentByte = fis.read();
            while (currentByte != -1) {
                char currentChar = (char) currentByte;
                if (!symbols.contains(currentChar))
                    fos.write(currentChar);
                currentByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
