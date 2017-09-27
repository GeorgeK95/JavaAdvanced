import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class StudentsResults {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = 1;//Integer.parseInt(in.nextLine());
        printFirstRow();
        for (int i = 0; i < n; i++) {
            List<String> line = getLine(in.nextLine());
            printStudentResult(line);
        }
    }

    private static List<String> getLine(String s) {
        return Arrays.stream(s.split("[, -]")).filter(x -> !x.isEmpty()).collect(Collectors.toList());
    }

    private static void printFirstRow() {
        System.out.println(String.format("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average"));
    }

    private static void printStudentResult(List<String> line) {
        System.out.println(String.format("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.4f|", line.get(0), Double.parseDouble(line.get(1)),
                Double.parseDouble(line.get(2)), Double.parseDouble(line.get(3)), getAvgValue(line)));
    }

    private static double getAvgValue(List<String> line) {
        line.remove(0);
        return line.stream().mapToDouble(Double::parseDouble).average().getAsDouble();
    }

}
