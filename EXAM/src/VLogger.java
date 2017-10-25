import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class VLogger {
    private static HashMap<String, Set<String>> userFollow = new HashMap<>();
    private static HashMap<String, Set<String>> userFollowers = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = in.readLine();
            if ("Statistics".equalsIgnoreCase(line)) {
                print();
                break;
            }
            String[] split = line.split(" ");
            if (split[1].equals("joined")) {
                join(split[0]);
            } else if (split[1].equals("followed")) {
                follow(split[0], split[2]);
            }
        }

    }

    private static void follow(String userName, String followName) {
        if (userFollow.containsKey(userName) && userFollow.containsKey(followName)) {
            if (!Objects.equals(userName, followName)) {
                userFollow.get(userName).add(followName);
                userFollowers.get(followName).add(userName);
            }
        }
    }

    private static void join(String s) {
        userFollow.putIfAbsent(s, new HashSet<>());
        userFollowers.putIfAbsent(s, new TreeSet<>());
    }

    private static void print() {
        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", userFollow.size());

        Comparator<? super Map.Entry<String, Set<String>>> entryComparator = (Comparator<Map.Entry<String, Set<String>>>) (o1, o2) -> {
            int f1 = o1.getValue().size();
            int f2 = o2.getValue().size();
            if (f2 == f1) {
                int size_1 = userFollow.get(o1.getKey()).size();
                int size_2 = userFollow.get(o2.getKey()).size();
                return Integer.compare(size_1, size_2);
            }
            return Integer.compare(f2, f1);
        };

        userFollowers = userFollowers.entrySet()
                .stream()
                .sorted(entryComparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));


        int counter = 1;
        for (Map.Entry<String, Set<String>> iter : userFollowers.entrySet()) {
            System.out.printf("%d. %s : %d followers, %d following%n", counter, iter.getKey(), iter.getValue().size(), userFollow.get(iter.getKey()).size());

            if (counter == 1) {
                for (String s : iter.getValue()) {
                    System.out.printf("*  %s%n", s);
                }
            }
            counter++;
        }

    }

}
