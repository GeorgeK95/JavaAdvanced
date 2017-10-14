import java.io.File;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ListFiles {
    private static final String folderPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

    public static void main(String[] args) {
        File f = new File(folderPath);
        printSizeOfFilesOnly(f.listFiles());
    }

    private static void printSizeOfFilesOnly(File[] files) {
        for (File file : files) {
            if (file.isFile()) {
                System.out.printf("%s: %d%n", file.getName(), file.length());
            }
        }
    }

}
