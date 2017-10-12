import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class StudentsByFirstAndLastName {
    public static void main(String[] args) {
        List<Student> students = ReadStudentsData.getData();
        students = students.stream().filter(x -> x.getFirstName().compareTo(x.getLastName()) < 0).collect(Collectors.toList());
        WriteStudentsData.writeToFile(students);
    }

}
