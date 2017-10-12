import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ExcellentStudents {
    public static void main(String[] args) {
        List<Student> students = ReadStudentsData.getData();
        Predicate<Student> hasExcellentGrade = x -> x.getGrades().contains(6);
        students = students.stream().filter(hasExcellentGrade)
                .collect(Collectors.toList());
        WriteStudentsData.writeToFile(students);
    }


}
