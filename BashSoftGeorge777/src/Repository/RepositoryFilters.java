package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Predicate;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RepositoryFilters {
    public static void printFilteredStudents(String filterType, int studentsCount, HashMap<String, ArrayList<Integer>> courseData) {
        Predicate<Double> filter = createFilter(filterType);

        if (filter == null) {
            OutputWriter.writeException(ExceptionMessages.INVALID_FILTER);
            return;
        }

        int studentsPrinted = 0;
        for (String student : courseData.keySet()) {
            if (studentsPrinted >= studentsCount) {
                break;
            }

            ArrayList<Integer> studentMarks = courseData.get(student);
            Double averageMark = studentMarks
                    .stream()
                    .mapToInt(Integer::valueOf)
                    .average()
                    .getAsDouble();

            Double percentageOfFulfilment = averageMark / 100;
            Double mark = percentageOfFulfilment * 4 + 2;

            if (filter.test(mark)) {
                OutputWriter.printStudent(student, studentMarks);
                studentsPrinted++;
            }
        }
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

}
