import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SortStudents {
    public static void main(String[] args) {
        List<Student> students = ReadStudentsData.getData();
        students = students.stream().sorted(Comparator.comparing(Student::getLastName)
                .thenComparing(Comparator.comparing(Student::getFirstName).reversed()))
                .collect(Collectors.toList());
        WriteStudentsData.writeToFile(students);
    }

}
