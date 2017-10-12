import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ReadStudentsData {
    private static final String path = "E:\\SOFTUNI\\Java Advanced - септември 2017\\07. Java-Advanced-Stream-API-Exercises\\StudentData.txt";

    static List<Student> getData() {
        List<Student> students = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line = br.readLine();
            line = br.readLine();

            while (line != null) {
                String[] splitted = line.split("\\s+");
                List<Integer> grades = readGrades(Arrays.copyOfRange(splitted, 6, 10));
                Student student = new Student(splitted[0], splitted[1], splitted[2], splitted[3], Integer.parseInt(splitted[4]),
                        Integer.parseInt(splitted[5]), grades, splitted[10]);
                students.add(student);
                line = br.readLine();
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error.");
        } catch (IOException e) {
            System.err.println("Error.");
        }

        return students;
    }

    private static List<Integer> readGrades(String[] splitted) {
        List<Integer> grades = new ArrayList<>();
        for (String s : splitted) {
            grades.add(Integer.parseInt(s));
        }
        return grades;
    }


}
