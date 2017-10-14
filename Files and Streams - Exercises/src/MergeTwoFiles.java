import java.io.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MergeTwoFiles {
    private static final String inputPath_1 = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testIn.txt";
    private static final String inputPath_2 = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testIn_2.txt";
    private static final String outputPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testOut.txt";

    public static void main(String[] args) {
        readWriteFile(inputPath_1);
        readWriteFile(inputPath_2);
    }

    private static void readWriteFile(String inputPath_1) {
        File f = new File(inputPath_1);
        try (BufferedReader br = new BufferedReader(new FileReader(f)); PrintWriter pw = new PrintWriter(new FileWriter(outputPath, true))) {
            for (String line; (line = br.readLine()) != null; ) {
                pw.print(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
