import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FindTheMissingNumber {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        Set<Integer> fullSet = getFullSet(n);
        Set<Integer> arraySet = IntStream.of(Arrays.stream(in.nextLine().split("[, ]"))
                .filter(x -> !x.equals("")).mapToInt(Integer::parseInt)
                .toArray()).boxed().collect(Collectors.toSet());
        printMissingNumber(fullSet, arraySet);
    }

    private static void printMissingNumber(Set<Integer> fullSet, Set<Integer> arraySet) {
        fullSet.removeAll(arraySet);
        for (Integer integer : fullSet) {
            System.out.println(integer);
        }
    }

    private static Set<Integer> getFullSet(int n) {
        Set<Integer> fullSet = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            fullSet.add(i);
        }
        return fullSet;
    }

}
