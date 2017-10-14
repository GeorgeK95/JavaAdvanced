import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ExtractIntegers {
    private static final String inputTxtPath = "E:\\SOFTUNI\\Java Advanced - септември 2017\\08. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

    public static void main(String[] args) {
        StringBuilder builder = getContent();
        Matcher m = Pattern.compile(" \\d+ ").matcher(builder);
        while (m.find()) {
            String group = m.group().trim();
            System.out.println(group);
        }
    }

    private static StringBuilder getContent() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(inputTxtPath))) {
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }
}
