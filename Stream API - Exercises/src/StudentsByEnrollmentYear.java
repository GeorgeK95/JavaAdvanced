import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class StudentsByEnrollmentYear {
    private static Map<String, List<Student>> yearStudents = new HashMap<>();

    public static void main(String[] args) {
        List<Student> students = ReadStudentsData.getData();
        fillMap();

        for (Map.Entry<String, List<Student>> stringListEntry : yearStudents.entrySet()) {
            String yearKey = stringListEntry.getKey();
            List<Student> currentFiltered = students.stream().filter(x -> x.getYear().equals(yearKey))
                    .collect(Collectors.toList());
            yearStudents.put(yearKey, currentFiltered);
        }

        WriteStudentsData.writeToFile(yearStudents);
    }

    private static void fillMap() {
        yearStudents.put("11", new ArrayList<>());
        yearStudents.put("12", new ArrayList<>());
        yearStudents.put("13", new ArrayList<>());
        yearStudents.put("14", new ArrayList<>());
        yearStudents.put("15", new ArrayList<>());
        yearStudents.put("16", new ArrayList<>());
        yearStudents.put("17", new ArrayList<>());
        yearStudents.put("18", new ArrayList<>());
        yearStudents.put("19", new ArrayList<>());
    }

}
