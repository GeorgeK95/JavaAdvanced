import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class StudentsByAge {
    public static void main(String[] args) {
        List<Student> students = ReadStudentsData.getData();
        students = students.stream().filter(x -> x.getAge() >= 18 && x.getAge() <= 24)
                .collect(Collectors.toList());
        WriteStudentsData.writeToFile(students);
    }

}
