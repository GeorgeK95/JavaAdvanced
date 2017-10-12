import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FilterStudentsByEmailDomain {
    public static void main(String[] args) {
        List<Student> students = ReadStudentsData.getData();
        String domaine = "@gmail.com";
        students = students.stream().filter(x -> x.getEmail().endsWith(domaine)).collect(Collectors.toList());
        WriteStudentsData.writeToFile(students);
    }
}
