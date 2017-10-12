import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class WeakStudents {
    public static void main(String[] args) {
        List<Student> students = ReadStudentsData.getData();
        Comparator<Student> comparator = (o1, o2) -> {
            int sum_o1 = o1.getGrades().stream().mapToInt(Integer::intValue).sum();
            int sum_o2 = o2.getGrades().stream().mapToInt(Integer::intValue).sum();
            return Integer.compare(sum_o1, sum_o2);
        };
        students = students
                .stream()
                .filter(x -> x.getGrades().stream().filter(y -> y <= 3)
                        .collect(Collectors.toList()).size() >= 2)
                .sorted(comparator)
                .collect(Collectors.toList());
        WriteStudentsData.writeToFile(students);
    }

}
