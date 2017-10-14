/**
 * Created by George-Lenovo on 6/29/2017.
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SortLines {
    private static final String inputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private static final String outputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\output_task_2.txt";

    public static void main(String[] args) {
        sortLines();
    }

    private static void sortLines() {
        File f = new File(inputTxtPath);

        try {
            Scanner in = new Scanner(f);
            Path path = Paths.get(inputTxtPath);
            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);
            writeToFile(lines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeToFile(List<String> lines) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter(outputTxtPath));
        for (String line : lines) {
            pw.println(line);
        }
        pw.close();
    }

}
