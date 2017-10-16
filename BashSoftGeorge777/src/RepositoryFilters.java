import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RepositoryFilters {
    public static void printFilteredStudents(String filterType, int studentsCount, HashMap<String, ArrayList<Integer>> courseData) {
        Predicate<Double> filter = createFilter(filterType);
    }

    private static Predicate<Double> createFilter(String filterType) {
        switch (filterType) {
            case "excellent":
                return x -> x >= 5;
            case "average":
                return x -> x >= 3.5 && x <= 5;
            case "poor":
                return x -> x < 3.5;
            default:
                return null;
        }
    }

    private static Double getStudentAvgGrade(List<Integer> grades) {
        double sum = grades.stream().mapToDouble(Double::valueOf).sum();
        double percentage = sum / (grades.size() * 100);
        return (percentage * 4) + 2;
    }

    public static void printOrderedStudents(String filterType, int studentsCount, HashMap<String, ArrayList<Integer>> courseData) {

    }
}
