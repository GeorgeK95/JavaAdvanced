import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ThePartyReservationFilterModule {
    private static List<String> names;
    private static List<String> removed = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        names = Arrays.stream(in.nextLine().split("\\s+")).collect(Collectors.toList());
        while (true) {
            String[] command = in.nextLine().split(";");
            String action = command[0];
            if ("Print".equals(action)) {
                break;
            }
            Predicate<String> lengthPredicate = (string) -> string.length() == Integer.parseInt(command[2]);
            Predicate<String> startsWithPredicate = (string) -> string.startsWith(command[2]);
            Predicate<String> endsWithPredicate = (string) -> string.endsWith(command[2]);
            Predicate<String> containsPredicate = (string) -> string.contains(command[2]);
            Predicate<String> currentPredicate = null;
            switch (command[1]) {
                case "Length":
                    currentPredicate = lengthPredicate;
                    break;
                case "Starts with":
                    currentPredicate = startsWithPredicate;
                    break;
                case "Ends with":
                    currentPredicate = endsWithPredicate;
                    break;
                case "Contains":
                    currentPredicate = containsPredicate;
                    break;
            }
            switch (command[0]) {
                case "Remove filter":
                    removed.removeIf(currentPredicate);
                    break;
                case "Add filter":
                    addFilter(currentPredicate);
                    break;
            }
        }
        names.removeAll(removed);
        System.out.println(Arrays.toString(names.toArray()).replace("]", "").replace("[", "").replace(",", ""));
    }

    private static void addFilter(Predicate<String> currentPredicate) {
        List<String> result = new ArrayList<>();
        for (String s1 : names) {
            if (currentPredicate.test(s1)) {
                result.add(s1);
            }
        }
        removed.addAll(result);
    }

}
