package Repository;

import IO.OutputWriter;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RepositorySorters {
    public static void printSortedStudents(String compareType, int studentsCount, HashMap<String, ArrayList<Integer>> courseData) {
        Comparator<? super Map.Entry<String, ArrayList<Integer>>> comparator = Comparator.comparingDouble(x -> x.getValue().stream()
                .mapToInt(Integer::valueOf).average().getAsDouble());
        List<String> sortedStudents = courseData.entrySet().stream().sorted(comparator).limit(studentsCount).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        if (compareType.equals("descending")) {
            Collections.reverse(sortedStudents);
        }
        for (String currentStudent : sortedStudents) {
            OutputWriter.printStudent(currentStudent, courseData.get(currentStudent));
        }
    }


}
