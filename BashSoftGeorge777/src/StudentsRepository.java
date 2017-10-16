import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

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
        /*Scanner in = new Scanner(System.in);
        String inputLine = in.nextLine();*/

        String fullpath = SessionData.currentPath + "\\" + fileName;
        List<String> allLines = Files.readAllLines(Paths.get(fullpath));
        for (String currentLine : allLines) {
            String[] split = currentLine.split("\\s+");

        }

        /*while (!inputLine.equals("")) {
            String[] splittedLine = inputLine.split("\\s+");
            addInfo(splittedLine);
            inputLine = in.nextLine();
        }*/

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
}
