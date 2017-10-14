/**
 * Created by George-Lenovo on 6/29/2017.
 */

import java.io.*;
import java.util.Scanner;

public class WriteEveryThirdLine {
    private static final String inputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
    private static final String outputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\output_task_2.txt";

    public static void main(String[] args) {
        writeLinesDivisibleBy3();
    }

    private static void writeLinesDivisibleBy3() {
        File f = new File(inputTxtPath);
        PrintWriter pw = null;
        try {
            Scanner in = new Scanner(f);
            pw = new PrintWriter(new FileWriter(outputTxtPath));
            int counter = 1;
            while (in.hasNextLine()) {
                String line = in.nextLine();
                if (counter % 3 == 0) {
                    pw.println(line);
                }
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }

}
