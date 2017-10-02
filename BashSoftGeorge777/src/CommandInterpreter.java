/**
 * Created by George-Lenovo on 6/29/2017.
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {

    public static void interpretCommand(String line) {
        String[] data = line.split(" ");
        String command = data[0];
        switch (command) {
            case "mkdir":
                tryCreateDirectory(line, data);
                break;
            case "Is":
                break;
            case "cmp":
                break;
            case "changeDirRel":
                break;
            case "changeDirAbs":
                break;
            case "readDb":
                break;
            case "filter":
                break;
            case "order":
                break;
            case "download":
                break;
            case "downloadAsync":
                break;
            case "help":
                break;
            case "open":
                tryOpenFile(line, data);
                break;
            default:
                displayInvalidCommand(line);
                break;
        }
    }

    private static void tryCreateDirectory(String line, String[] data) {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }
        IOManager.createDirectoryInCurrentFolder(data[1]);
    }

    private static void tryOpenFile(String line, String[] data) {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }
        String fullFilePath = SessionData.currentPath + "\\" + data[1];
        File f = new File(fullFilePath);
        try {
            Desktop.getDesktop().open(f);
        } catch (IOException e) {
            OutputWriter.writeException(String.format("Unable to open file %s.", fullFilePath));
        }
    }

    private static void displayInvalidCommand(String line) {
        OutputWriter.writeMessageOnNewLine(String.format("The command %s is invalid.", line));
    }
}
