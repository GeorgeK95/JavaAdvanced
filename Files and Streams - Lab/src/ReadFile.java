import java.io.FileInputStream;
import java.io.IOException;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ReadFile {
    private static final String inputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(inputTxtPath)) {
            int currentByte = fis.read();
            while (currentByte != -1) {
                System.out.printf("%s ", Integer.toBinaryString(currentByte));
                currentByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
