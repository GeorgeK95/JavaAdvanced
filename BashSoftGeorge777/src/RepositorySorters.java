import java.util.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RepositorySorters {
    public static void printSortedStudents(String compareType, int studentsCount, HashMap<String, List<Integer>> courseData) {
        Comparator<Map.Entry<String, List<Integer>>> comparator = createComparator(compareType);
        List<Map.Entry<String, List<Integer>>> sortedStudents = new ArrayList<>();
        sortedStudents.addAll(courseData.entrySet());
        Collections.sort(sortedStudents, comparator);
        for (Map.Entry<String, List<Integer>> currentStudent : sortedStudents) {
            OutputWriter.printStudent(currentStudent.getKey(), currentStudent.getValue());
        }
    }

    private static Comparator<Map.Entry<String, List<Integer>>> createComparator(String compareType) {
        switch (compareType) {
            case "ascending":
                return (firstStudent, secondStudent) -> {
                    double firstStudentScore = getTotalScore(firstStudent.getValue());
                    double secondStudentScore = getTotalScore(secondStudent.getValue());
                    return Double.compare(firstStudentScore, secondStudentScore);
                };
            case "descending":
                return (firstStudent, secondStudent) -> {
                    double firstStudentScore = getTotalScore(firstStudent.getValue());
                    double secondStudentScore = getTotalScore(secondStudent.getValue());
                    return Double.compare(secondStudentScore, firstStudentScore);
                };
            default:
                return null;
        }
    }

    private static double getTotalScore(List<Integer> value) {
        return value.stream().mapToDouble(Double::valueOf).sum() / value.size();
    }

}
