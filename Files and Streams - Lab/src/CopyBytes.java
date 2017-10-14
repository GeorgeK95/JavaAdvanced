import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CopyBytes {
    private static final String inputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private static final String outputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\output_task_2.txt";

    public static void main(String[] args) {
        copyBytes();
    }

    private static void copyBytes() {
        try (FileInputStream fis = new FileInputStream(inputTxtPath);
             FileOutputStream fos = new FileOutputStream(outputTxtPath)) {
            int currentByte = fis.read();
            while (currentByte != -1) {
                String asciiValue = String.valueOf(currentByte);
                if ("10".equals(asciiValue)) {
                    fos.write('\n');
                } else if ("32".equals(asciiValue)) {
                    fos.write(' ');
                } else {
                    for (char c : asciiValue.toCharArray()) {
                        fos.write(c);
                    }
                }
                currentByte = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
