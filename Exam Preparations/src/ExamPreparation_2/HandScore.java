package ExamPreparation_2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class HandScore {
    private static Map<Character, List<Integer>> map = new HashMap<>();

    public static void main(String[] args) {
        fillMap();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        String regex = "(\\d+|[JQKA])([HDCS])";
        Matcher m = Pattern.compile(regex).matcher(line);
        System.out.println(processCards(m));
    }

    private static long processCards(Matcher m) {
        String number;
        char suit = '\0';
        long sum = 0;

        if (m.find()) {
            number = m.group(1);
            suit = m.group(2).charAt(0);
            int currentNumberInt = getValue(number);
            map.get(suit).add(currentNumberInt);
        }

        while (m.find()) {
            String currentNumber = m.group(1);
            char currentSuit = m.group(2).charAt(0);

            if (suit != currentSuit) {
                int size = map.get(suit).size();
                long currentSum = map.get(suit).stream().mapToInt(Integer::valueOf).sum();
                if (size != 0) {
                    currentSum *= size;
                }
                sum += currentSum;
                map.get(suit).clear();
                suit = currentSuit;
            }

            int currentNumberInt = getValue(currentNumber);
            map.get(currentSuit).add(currentNumberInt);
        }

        for (Character character : map.keySet()) {
            if (!map.get(character).isEmpty()) {
                sum += map.get(character).stream().mapToInt(Integer::valueOf).sum() * map.get(suit).size();
                map.get(character).clear();
            }
        }

        return sum;
    }

    private static int getValue(String currentNumber) {
        int res = 0;

        try {
            res = Integer.parseInt(currentNumber);
        } catch (NumberFormatException e) {
            switch (currentNumber) {
                case "J":
                    res = 12;
                    break;
                case "Q":
                    res = 13;
                    break;
                case "K":
                    res = 14;
                    break;
                case "A":
                    res = 15;
                    break;
            }
        }

        return res;
    }


    private static void fillMap() {
        map.put('S', new ArrayList<>());
        map.put('H', new ArrayList<>());
        map.put('C', new ArrayList<>());
        map.put('D', new ArrayList<>());
    }
}
