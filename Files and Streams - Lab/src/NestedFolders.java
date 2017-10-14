import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class NestedFolders {
    private static final String folderPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams";

    public static void main(String[] args) {
        File f = new File(folderPath);
        BFS(f.listFiles());
    }

    private static void BFS(File[] files) {
        Deque<File> queue = new ArrayDeque<>();
        queue.addLast(new File(folderPath));
        int counter = 0;
        while (!queue.isEmpty()) {
            File pop = queue.poll();
            System.out.println(pop.getName());
            counter++;
            File[] nastedFiles = pop.listFiles();
            if (nastedFiles != null) {
                for (File nastedFile : nastedFiles) {
                    if (nastedFile.isDirectory()) {
                        queue.addLast(nastedFile);
                    }
                }
            }
        }
        System.out.printf("%d folders", counter);
    }

}
