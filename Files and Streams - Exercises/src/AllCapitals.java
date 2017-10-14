import java.io.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AllCapitals {
    private static final String inputPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testIn.txt";
    private static final String outputPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testOut.txt";

    public static void main(String[] args) {
        readAndWriteUpper();
    }

    private static void readAndWriteUpper() {
        File f = new File(inputPath);
        try (BufferedReader br = new BufferedReader(new FileReader(f)); PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {
            for (String line; (line = br.readLine()) != null; ) {
                pw.print(line.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
