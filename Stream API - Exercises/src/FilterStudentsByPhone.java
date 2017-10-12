import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FilterStudentsByPhone {
    public static void main(String[] args) {
        List<Student> students = ReadStudentsData.getData();
        String first_phone = "02";
        String second_phone = "+3592";
        students = students.stream().filter(x -> x.getPhone().startsWith(first_phone) || x.getPhone().startsWith(second_phone))
                .collect(Collectors.toList());
        WriteStudentsData.writeToFile(students);
    }

}
