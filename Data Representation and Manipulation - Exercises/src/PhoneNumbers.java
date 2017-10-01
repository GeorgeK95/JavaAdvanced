import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class PhoneNumbers {

    public static void main(String[] args) {
        StringBuilder input = readWholeInput();
        String reg = "([A-Z][a-zA-Z]*)([^a-zA-Z\\+]*\\+?\\d[\\(\\)\\-\\.\\s\\/\\d]*\\d)";
        Matcher matcher = Pattern.compile(reg).matcher(input);
        printResultList(getResultList(matcher));
    }

    private static void printResultList(List<String> resultList) {
        if (resultList.isEmpty()) {
            System.out.println("<p>No matches!</p>");
            return;
        }

//        resultList.sort(String::compareToIgnoreCase);
        System.out.print("<ol>");
        for (String s : resultList) {
            System.out.print(s);
        }
        System.out.print("</ol>");

    }

    private static List<String> getResultList(Matcher matcher) {
        List<String> outputList = new ArrayList<>();
        while (matcher.find()) {
            String name = matcher.group(1);
            String phone = getPhone(matcher.group(2));
            outputList.add(getFormattedLine(name, phone));
        }
        return outputList;
    }

    private static String getFormattedLine(String name, String phone) {
        return String.format("<li><b>%s:</b> %s</li>", name, phone);
    }

    private static StringBuilder readWholeInput() {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String currentLine = in.nextLine();
            if (currentLine.equals("END")) {
                break;
            }
            sb.append(currentLine);
        }
        return sb;
    }


    private static String getPhone(String group) {
        List<Character> containingSymbols = new ArrayList<Character>() {{
            {
                add('(');
                add(')');
                add('/');
                add('.');
                add('-');
                add(' ');
                add('+');
            }
        }};

        StringBuilder sb = new StringBuilder();
        for (int i = group.toCharArray().length - 1; i >= 0; i--) {
            char current = group.charAt(i);
            if (!containingSymbols.contains(current) && (current < 48 || current > 57)) {
                break;
            }
            sb.append(current);
        }

        String phone = sb.reverse().toString().trim();
        phone = clearNumber(phone);
        return phone;
    }

    private static String clearNumber(String phone) {
        StringBuilder cleared = new StringBuilder();
        boolean isPlusAdded = false;
        if (phone.charAt(0) == '+') {
            cleared.append('+');
            isPlusAdded = true;
        }

        int i;
        if (isPlusAdded)
            i = 1;
        else
            i = 0;

        for (; i < phone.toCharArray().length; i++) {
            char current = phone.charAt(i);
            if (current >= 48 && current <= 57) {
                cleared.append(current);
            }
        }
        return cleared.toString();
    }

}
