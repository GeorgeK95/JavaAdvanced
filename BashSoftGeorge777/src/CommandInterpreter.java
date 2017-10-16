/**
 * Created by George-Lenovo on 6/29/2017.
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class CommandInterpreter {

    public static void interpretCommand(String line) throws IOException {
        String[] data = line.split("\\s+");
        String command = data[0];
        switch (command) {
            case "mkdir":
                tryCreateDirectory(line, data);
                break;
            case "Is":
                tryTraverseFolder(line, data);
                break;
            case "cmp":
                tryCompareFiles(line, data);
                break;
            case "changeDirRel":
                tryChangeRelativePath(line, data);
                break;
            case "changeDirAbs":
                tryChangeAbsolutePath(line, data);
                break;
            case "readDb":
                tryReadDbFromFile(line, data);
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
                getHelp();
                break;
            case "open":
                tryOpenFile(line, data);
                break;
            default:
                displayInvalidCommand(line);
                break;
        }
    }

    private static void getHelp() {
        OutputWriter.writeMessageOnNewLine("mkdir path - make directory");
        OutputWriter.writeMessageOnNewLine("ls depth - traverse directory");
        OutputWriter.writeMessageOnNewLine("cmp path1 path2 - compare two files");
        OutputWriter.writeMessageOnNewLine("changeDirRel relativePath - change directory");
        OutputWriter.writeMessageOnNewLine("changeDir absolutePath - change directory");
        OutputWriter.writeMessageOnNewLine("readDb path - read students data base");
        OutputWriter.writeMessageOnNewLine("filterExcelent - filter excelent students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterExcelent path - filter excelent students (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("filterAverage - filter average students (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("filterAverage path - filter average students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("filterPoor - filter low grade students (the output is on the console)");
        OutputWriter.writeMessageOnNewLine("filterPoor path - filter low grade students (the output is written in a file)");
        OutputWriter.writeMessageOnNewLine("order - sort students in increasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("order path - sort students in increasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("decOrder - sort students in decreasing order (the output is written on the console)");
        OutputWriter.writeMessageOnNewLine("decOrder path - sort students in decreasing order (the output is written in a given path)");
        OutputWriter.writeMessageOnNewLine("download pathOfFile - download file (saved in current directory)");
        OutputWriter.writeMessageOnNewLine("downloadAsync path - download file asynchronously (save in the current directory)");
        OutputWriter.writeMessageOnNewLine("help - get help");
        OutputWriter.writeEmptyLine();
    }

    private static void tryReadDbFromFile(String line, String[] data) throws IOException {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }
        StudentsRepository.initializeData(data[1]);
    }

    private static void tryChangeAbsolutePath(String line, String[] data) {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }

        IOManager.changeCurrentDirAbsolute(data[1]);
    }

    private static void tryChangeRelativePath(String line, String[] data) {
        if (data.length != 2) {
            displayInvalidCommand(line);
            return;
        }

        IOManager.changeCurrentDirRelativePath(data[1]);
    }

    private static void tryCompareFiles(String line, String[] data) {
        if (data.length != 3) {
            displayInvalidCommand(line);
            return;
        }
        Tester.compareContent(data[1], data[2]);
    }

    private static void tryTraverseFolder(String line, String[] data) {
        if (data.length != 2 && data.length != 1) {
            displayInvalidCommand(line);
            return;
        }
        if (data.length == 2) {
            IOManager.traverseDirectory(Integer.parseInt(data[1]));
        }
        if (data.length == 1) {
            IOManager.traverseDirectory(0);
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
