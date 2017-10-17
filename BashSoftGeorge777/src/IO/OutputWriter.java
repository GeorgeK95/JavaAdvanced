package IO;

import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class OutputWriter {
    public static void writeMessage(String message) {
        System.out.print(message);
    }

    public static void writeMessageOnNewLine(String message) {
        System.out.println(message);
    }

    public static void writeEmptyLine() {
        System.out.println();
    }

    public static void writeException(String message) {
        System.err.print(message);
    }

    public static void printStudent(String name, List<Integer> grades) {
        String output = String.format("%s - %s", name, grades.toString());
        OutputWriter.writeMessageOnNewLine(output);
    }

}
