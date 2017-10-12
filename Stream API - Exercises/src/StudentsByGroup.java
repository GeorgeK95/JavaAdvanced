import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 7/7/2017.
 */
public class StudentsByGroup {
    public static void main(String[] args) {
        List<Student> students = ReadStudentsData.getData();
        students = students.stream().filter(x -> x.getGroup() == 2).sorted(Comparator.comparing(Student::getFirstName))
                .collect(Collectors.toList());
        WriteStudentsData.writeToFile(students);
    }
}
