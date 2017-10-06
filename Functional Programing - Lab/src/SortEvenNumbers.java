import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> collected = Arrays.stream(Arrays.stream(in.nextLine().split(", ")).mapToInt(Integer::parseInt)
                .toArray()).filter(x -> x % 2 == 0).boxed().collect(Collectors.toList());

        System.out.println(join(collected, ", "));
        Collections.sort(collected);
        System.out.println(join(collected, ", "));
    }

    private static String join(Collection<?> s, String delimiter) {
        StringBuilder builder = new StringBuilder();
        Iterator<?> iter = s.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (!iter.hasNext()) {
                break;
            }
            builder.append(delimiter);
        }
        return builder.toString();
    }
}
