import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Tester {
    public static void compareContent(String userOutput, String expectedOutput) {
        OutputWriter.writeMessageOnNewLine("Reading files...");
        String mismatchFilePath = getMismatchPath(expectedOutput);
        List<String> actualOutputString = readTextFile(userOutput);
        List<String> expectedOutputString = readTextFile(expectedOutput);
        boolean mismatch = compareStrings(actualOutputString, expectedOutputString, mismatchFilePath);
        if (mismatch) {
            List<String> mismatchLines = readTextFile(mismatchFilePath);
            mismatchLines.forEach(OutputWriter::writeMessageOnNewLine);
        } else {
            OutputWriter.writeMessageOnNewLine("No mismatches.");
        }
    }

    private static String getMismatchPath(String expectedOutput) {
        int lastSlash = expectedOutput.lastIndexOf("\\");
        String folder = expectedOutput.substring(0, lastSlash);
        return folder + "\\mismatch.txt";
    }

    private static List<String> readTextFile(String path) {
        List<String> lines = new ArrayList<>();
        File file = new File(path);
        try {
            FileReader fileReader = new FileReader(file);
            try (BufferedReader br = new BufferedReader(fileReader)) {
                String line = br.readLine();
                while (!line.equals("")) {
                    lines.add(line);
                    line = br.readLine();
                }
            }

        } catch (Exception e) {
            OutputWriter.writeException("Error 404. Unable to read file.");
        }
        return lines;
    }

    private static boolean compareStrings(List<String> userOutput, List<String> expectedOutput, String mismatchPath) {
        OutputWriter.writeMessageOnNewLine("Comparing files...");
        String output = "";
        boolean isMismatch = false;
        try {
            try (FileWriter fileWriter = new FileWriter(mismatchPath); BufferedWriter writer = new BufferedWriter(fileWriter)) {

                for (int i = 0; i < expectedOutput.size(); i++) {
                    String userLine = userOutput.get(i);
                    String expectedLine = expectedOutput.get(i);
                    if (!userLine.equals(expectedLine)) {
                        output = String.format("mismatch -> expected(%s), actual(%s)%n", userLine, expectedLine);
                        isMismatch = true;
                    } else {
                        output = String.format("line match -> %s%n", userLine);
                    }

                    writer.write(output);
                }
            }
        } catch (Exception e) {
            OutputWriter.writeException("Error 404. Unable to read file.");
        }

        return isMismatch;
    }

    private static void writeOutputToFile(String output, String mismatchPath) {
        File f = new File(mismatchPath);

    }
}
