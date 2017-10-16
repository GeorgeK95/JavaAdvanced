import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class IOManager {
    public static void traverseDirectory(int depth) {
        Queue<File> queue = new LinkedList<>();
        String path = SessionData.currentPath;
        int initialIndentation = path.split("\\\\").length;
        queue.add(new File(path));

        while (!queue.isEmpty()) {
            File current = queue.poll();
            int currentIndentation = current.toString().split("\\\\").length - initialIndentation;

            if (depth - currentIndentation < 0) {
                break;
            }

            OutputWriter.writeMessageOnNewLine(current.toString());

            try {
                if (current.listFiles() != null) {
                    for (File file : current.listFiles()) {
                        if (file.isDirectory()) {
                            queue.add(file);
                        } else {
                            int indexOfLastSlash = file.toString().lastIndexOf("\\");
                            for (int i = 0; i < indexOfLastSlash; i++) {
                                OutputWriter.writeMessage("-");
                            }

                            OutputWriter.writeMessageOnNewLine(file.getName());
                        }
                    }
                }

            } catch (Exception err) {
                System.out.println("Error.");
            }

        }
    }

    public static void createDirectoryInCurrentFolder(String name) {
        String path = getCurrentDirectoryPath() + "\\" + name;
        File f = new File(path);
        f.mkdir();
    }

    private static String getCurrentDirectoryPath() {
        return SessionData.currentPath;
    }

    static void changeCurrentDirRelativePath(String relativePath) {
        if (relativePath.equals("..")) {
            String currentPath = SessionData.currentPath;
            int lastSlashIndex = currentPath.lastIndexOf("\\");
            SessionData.currentPath = currentPath.substring(0, lastSlashIndex);
        } else {
            String currentPath = SessionData.currentPath;
            currentPath += "\\" + relativePath;
            changeCurrentDirAbsolute(currentPath);
        }
    }

    static void changeCurrentDirAbsolute(String absolutePath) {
        File f = new File(absolutePath);
        if (!f.exists()) {
            OutputWriter.writeException(ExceptionMessages.INVALID_PATH);
            return;
        }
        SessionData.currentPath = absolutePath;
    }

    public static void main(String[] args) {
//        traverseDirectory("E:\\GITHUB\\JavaAdvanced");
//        StudentsRepository.initializeData();
//        StudentsRepository.getStudentsByCourse("Unity");
//        String filePath_1 = "E:\\SOFTUNI\\Java Advanced - септември 2017\\BashSoft\\03. Java-Advanced-BashSoft-Lab\\test1.txt";
//        String filePath_2 = "E:\\SOFTUNI\\Java Advanced - септември 2017\\BashSoft\\03. Java-Advanced-BashSoft-Lab\\test3.txt";
//        Tester.compareContent(filePath_1, filePath_2);
//        IOManager.createDirectoryInCurrentFolder("golfajiq");
    }


}
