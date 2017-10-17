package Repository;

import IO.OutputWriter;
import StaticData.ExceptionMessages;
import StaticData.SessionData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class StudentsRepository {
    public static boolean isDataInitialized = false;
    public static HashMap<String, HashMap<String, ArrayList<Integer>>> studentsByCourse;

    public static void initializeData(String fileName) throws IOException {
        if (isDataInitialized) {
            System.out.println(ExceptionMessages.DATA_ALREADY_INITIALIZED);
            return;
        }
        studentsByCourse = new HashMap<>();
        readData(fileName);
    }

    private static void readData(String fileName) throws IOException {
        String regex = "([A-Z][A-Za-z\\+\\#]+_[A-Z][A-Za-z]{2}_201[45678])\\s+([A-Z][a-z]{0,3}\\d{2}_\\d{2,4})\\s+(\\d+)";
        Pattern pattern = Pattern.compile(regex);
        Matcher m;
        String fullpath = SessionData.currentPath + "\\" + fileName;
        List<String> allLines = Files.readAllLines(Paths.get(fullpath));


        for (String currentLine : allLines) {
            m = pattern.matcher(currentLine);

            if (m.find() && !currentLine.isEmpty()) {
                String course = m.group(1);
                String studentName = m.group(2);
                int studentScore = Integer.parseInt(m.group(3));

                if (!studentsByCourse.containsKey(course)) {
                    studentsByCourse.put(course, new LinkedHashMap<>());
                }
                if (!studentsByCourse.get(course).containsKey(studentName)) {
                    studentsByCourse.get(course).put(studentName, new ArrayList<>());
                }
                studentsByCourse.get(course).get(studentName).add(studentScore);
            }
        }

        isDataInitialized = true;
        OutputWriter.writeMessageOnNewLine("Data read.");
    }

    private static void addInfo(String[] splittedLine) {
        String course = splittedLine[0];
        String student = splittedLine[1];
        int grade = Integer.parseInt(splittedLine[2]);

        if (!studentsByCourse.containsKey(course)) {
            studentsByCourse.put(course, new HashMap<>());
        }
        if (!studentsByCourse.get(course).containsKey(student)) {
            studentsByCourse.get(course).put(student, new ArrayList<>());
        }
        studentsByCourse.get(course).get(student).add(grade);
    }

    private static boolean isQueryForCoursePossible(String courseName) {
        if (!isDataInitialized) {
            OutputWriter.writeException(ExceptionMessages.DATA_NOT_INITIALIZED);
            return false;
        }
        if (!studentsByCourse.containsKey(courseName)) {
            OutputWriter.writeException(ExceptionMessages.NON_EXISTING_COURSE);
            return false;
        }
        return true;
    }

    private static boolean isQueryForStudentPossible(String course, String student) {
        if (!isQueryForCoursePossible(course)) {
            return false;
        }
        if (!studentsByCourse.get(course).containsKey(student)) {
            OutputWriter.writeException(ExceptionMessages.NON_EXISTING_STUDENT);
            return false;
        }
        return true;
    }

    public static void getStudentMarksInCourse(String course, String student) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }
        OutputWriter.printStudent(student, studentsByCourse.get(course).get(student));
    }

    public static void getStudentsByCourse(String course) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }
        HashMap<String, ArrayList<Integer>> studentsGrades = studentsByCourse.get(course);
        for (Map.Entry<String, ArrayList<Integer>> currentStudent : studentsGrades.entrySet()) {
            OutputWriter.printStudent(currentStudent.getKey(), currentStudent.getValue());
        }
    }

    public static void printOrderedStudents(String course, String filter, Integer count) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }
        if (count == null) {
            count = studentsByCourse.get(course).size();
        }

        RepositorySorters.printSortedStudents(filter, count, studentsByCourse.get(course));
    }

    public static void printFilteredStudents(String course, String filter, Integer count) {
        if (!isQueryForCoursePossible(course)) {
            return;
        }
        if (count == null) {
            count = studentsByCourse.get(course).size();
        }

        RepositoryFilters.printFilteredStudents(filter, count, studentsByCourse.get(course));
    }
}
