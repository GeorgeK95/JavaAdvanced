import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class WriteStudentsData {
    private static final String path = "C:\\Users\\George-Lenovo\\Desktop\\output.txt";

    static void writeToFile(List<Student> students) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path, "UTF-8");
            for (int i = 0; i < students.size(); i++) {
                if (i == students.size() - 1) {
                    writer.print(students.get(i));
                } else {
                    writer.println(students.get(i));
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println("Error. FileNotParsed ex.");
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error. UnsupportedEncodingException ex.");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }

    static void writeToFile(Map<String, List<Student>> students) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path, "UTF-8");
            for (Map.Entry<String, List<Student>> yearStudents : students.entrySet()) {
                writer.println("20" + yearStudents.getKey() + ":");
                List<Student> value = yearStudents.getValue().stream()
                        .sorted(Comparator.comparing(Student::getFirstName).thenComparing(Student::getLastName))
                        .collect(Collectors.toList());
                for (Student student : value) {
                    writer.println("-- " + student);
                }

            }
        } catch (FileNotFoundException e) {
            System.err.println("Error. FileNotParsed ex.");
        } catch (UnsupportedEncodingException e) {
            System.err.println("Error. UnsupportedEncodingException ex.");
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }
}
