import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InfernoIII {
    private static Map<String, List<Integer>> commandsIndexes = new LinkedHashMap<>();
    private static int[] numbers;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        numbers = Stream.of(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        while (true) {
            String line = in.readLine();
            if ("Forge".equals(line)) {
                print();
                break;
            }
            String[] split = line.split(";");
            switch (split[0]) {
                case "Exclude":
                    exclude(split[1], Integer.parseInt(split[2]));
                    break;
                case "Reverse":
                    reverse(split[1], Integer.parseInt(split[2]));
                    break;
            }
        }

    }

    private static void reverse(String command, int resultToMatch) {
        if (commandsIndexes.containsKey(command + resultToMatch)) {
            commandsIndexes.remove(command + resultToMatch);
        }
    }

    private static void print() {
        for (List<Integer> integers : commandsIndexes.values()) {
            for (Integer integer : integers) {
                numbers[integer] = -99;
            }
        }
        for (Integer integer : numbers) {
            if (integer != -99) {
                System.out.print(integer + " ");
            }
        }
    }

    private static void exclude(String s, int i) {
        switch (s) {
            case "Sum Left":
                sumLeft(s, i);
                break;
            case "Sum Right":
                sumRight(s, i);
                break;
            case "Sum Left Right":
                sumBoth(s, i);
                break;
        }
    }

    private static void sumBoth(String command, int resultToMatch) {
        for (int j = 0; j < numbers.length; j++) {
            int current = 0;
            int left = 0;
            int right = 0;
            try {
                current = numbers[j];
                left = numbers[j - 1];
                right = numbers[j + 1];
            } catch (ArrayIndexOutOfBoundsException e) {
                try {
                    right = numbers[j + 1];
                } catch (ArrayIndexOutOfBoundsException ee) {
                }

            }
            if (current + left + right == resultToMatch) {
                commandsIndexes.putIfAbsent(command + resultToMatch, new ArrayList<>());
                List<Integer> integers = commandsIndexes.get(command + resultToMatch);
                integers.add(j);
                commandsIndexes.put(command + resultToMatch, integers);
            }
        }

    }

    private static void sumRight(String command, int resultToMatch) {
        for (int j = 0; j < numbers.length - 1; j++) {
            int current = numbers[j];
            int right = 0;
            try {
                right = numbers[j + 1];
            } catch (IndexOutOfBoundsException e) {

            }
            if (current + right == resultToMatch) {
                commandsIndexes.putIfAbsent(command + resultToMatch, new ArrayList<>());
                List<Integer> integers = commandsIndexes.get(command + resultToMatch);
                integers.add(j);
                commandsIndexes.put(command + resultToMatch, integers);
            }
        }
    }

    private static void sumLeft(String command, int resultToMatch) {
        for (int j = numbers.length - 1; j >= 0; j--) {
            int current = numbers[j];
            int left = 0;
            try {
                left = numbers[j - 1];
            } catch (IndexOutOfBoundsException e) {

            }
            if (current + left == resultToMatch) {
                commandsIndexes.putIfAbsent(command + resultToMatch, new ArrayList<>());
                List<Integer> integers = commandsIndexes.get(command + resultToMatch);
                integers.add(j);
                commandsIndexes.put(command + resultToMatch, integers);
            }
        }
    }

}
