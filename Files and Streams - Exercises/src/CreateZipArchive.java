import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class CreateZipArchive {
    private static final String PATH = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams\\";
    private static String[] fileNames = new String[]{"input.txt", "output.txt", "smo.txt"};

    public static void main(String[] args) throws IOException {
        createZipFile();
    }

    private static void createZipFile() throws IOException {
        File f = new File(PATH + "archive.zip");
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));

        for (String fileName : fileNames) {
            ZipEntry e = new ZipEntry(fileName);
            out.putNextEntry(e);
            String sb = readCurrentFileContent(fileName);
            byte[] data = sb.getBytes();
            out.write(data, 0, data.length);
        }

        out.closeEntry();
        out.close();
    }

    private static String readCurrentFileContent(String fileName) throws IOException {
        String fullPath = PATH + fileName;
        String everything;

        try (BufferedReader br = new BufferedReader(new FileReader(fullPath))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            everything = sb.toString();
        }

        return everything;
    }
}
