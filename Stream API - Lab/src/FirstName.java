import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FirstName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Set<String> names = getNames(in.nextLine().split("\\s+"));
        List<Character> letters = Arrays.stream(in.nextLine().toLowerCase().split("\\s+"))
                .map(x -> x.toLowerCase().charAt(0))
                .collect(Collectors.toList());
        Optional<String> first = names.stream().filter(x -> letters.contains(x.toLowerCase().charAt(0))).findFirst();
        if (first.isPresent()) {
            System.out.println(first.get());
        } else {
            System.out.println("No match");
        }
    }

    private static Set<String> getNames(String[] data) {
        Set<String> names = new TreeSet<>();
        for (String name : data) {
            names.add(name);
        }
        return names;
    }

}
