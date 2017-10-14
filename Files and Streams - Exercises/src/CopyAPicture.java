import java.io.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CopyAPicture {
    private static final String imagePath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\r32.jpg";
    private static final String imageCopyPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\r32-copy.jpg";

    public static void main(String[] args) {
        copyPicture();
    }

    private static void copyPicture() {
        try (InputStream is = new FileInputStream(new File(imagePath));
             OutputStream os = new FileOutputStream(new File(imageCopyPath))) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
