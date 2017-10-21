package ExamPreparation_1;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Ascend {
    private static String reg = "(([,_])([A-Za-z]+)(\\d))";
    private static Map<String, String> mem = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if ("Ascend".equalsIgnoreCase(line)) {
                break;
            }
            writeData(line);
        }
    }

    private static void writeData(String line) {
        line = memorize(line);
        Matcher m = Pattern.compile(reg).matcher(line);

        while (m.find()) {
            StringBuilder sb = new StringBuilder();
            int digit = Integer.parseInt(m.group(4));
            switch (m.group(2).charAt(0)) {
                case ',':
                    //add
                    String text = m.group(3);
                    for (char c : text.toCharArray()) {
                        sb.append((char) (c + digit));
                    }
                    break;
                case '_':
                    //substr
                    String text1 = m.group(3);
                    for (char c : text1.toCharArray()) {
                        sb.append((char) (c - digit));
                    }
                    break;

            }
            line = line.replace(m.group(1), sb);
            mem.put(m.group(1), sb.toString());
        }

        System.out.println(line);

    }

    private static String memorize(String line) {
        for (Map.Entry<String, String> oldNew : mem.entrySet()) {
            line = line.replace(oldNew.getKey(), oldNew.getValue());
        }
        return line;
    }

}
