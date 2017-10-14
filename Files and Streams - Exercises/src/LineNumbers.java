import java.io.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class LineNumbers {
    private static final String inputPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testIn.txt";
    private static final String outputPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\testOut.txt";
    private static int lineNumber = 1;

    public static void main(String[] args) {
        writeNumberedLines();
    }

    private static void writeNumberedLines() {
        File f = new File(inputPath);
        try (BufferedReader br = new BufferedReader(new FileReader(f)); PrintWriter pw = new PrintWriter(new FileWriter(outputPath))) {
            for (String line; (line = br.readLine()) != null; ) {
                String numberedLine = lineNumber + ". " + line;
                pw.print(numberedLine);
                pw.print(System.getProperty("line.separator"));
                lineNumber++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
