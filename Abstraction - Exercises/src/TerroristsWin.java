import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class TerroristsWin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        line = setBombsOff(line);
        System.out.println(line);
    }

    private static String setBombsOff(String line) {
        while (true) {
            int bombBegin = line.indexOf('|');
            int bombEnd = line.indexOf('|', bombBegin + 1);
            if (bombBegin == -1 || bombEnd == -1) {
                break;
            }
            int power = getBombPower(line, bombBegin, bombEnd);
            line = executeBomb(line, bombBegin - power, bombEnd + power);
        }
        return line;
    }

    private static String executeBomb(String line, int i, int i1) {
        char[] a = line.toCharArray();
        for (int j = i; j <= i1; j++) {
            try {
                a[j] = '.';
            } catch (ArrayIndexOutOfBoundsException ex) {

            }
        }
        StringBuilder newLine = new StringBuilder();
        for (char c : a) {
            newLine = newLine.append(c);
        }
        return newLine.toString();
    }

    private static int getBombPower(String line, int bombBegin, int bombEnd) {
        int power = 0;
        for (int i = bombBegin + 1; i < bombEnd; i++) {
            power += line.charAt(i);
        }
        return power % 10;
    }

}
