import java.io.File;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class GetFolderSize {
    private static final String folderPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\Files-and-Streams";

    public static void main(String[] args) {
        System.out.printf("Folder size: %d", getFolderSize());
    }

    private static int getFolderSize() {
        int sum = 0;
        Deque<File> queue = new ArrayDeque<>();
        queue.addLast(new File(folderPath));
        while (!queue.isEmpty()) {
            File pop = queue.poll();
            sum += pop.length();
//            System.out.println(pop.getName());
            File[] nastedFiles = pop.listFiles();
            if (nastedFiles != null) {
                for (File nastedFile : nastedFiles) {
                    queue.addLast(nastedFile);
                }
            }
        }
        return sum;
    }
}
