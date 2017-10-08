import java.util.*;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class InfernoIII {
    private static Deque<int[]> history = new ArrayDeque<>();
    private static int[] collected;
    private static Set<Integer> indexesToRemove = new HashSet<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        collected = Arrays.stream(in.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        history.addLast(collected);

        while (true) {
            String line = in.nextLine();
            if (line.equals("Forge")) {
                print();
                break;
            }
            String[] split = line.split(";");
            switch (split[0]) {
                case "Exclude":
                    switch (split[1]) {
                        case "Sum Left":
                            sumLeft(Integer.parseInt(split[2]));
                            break;
                        case "Sum Right":
                            sumRight(Integer.parseInt(split[2]));
                            break;
                        case "Sum Left Right":
                            sumBoth(Integer.parseInt(split[2]));
                            break;
                    }
                    history.addLast(collected);
                    removeElementsAtPositions(indexesToRemove);
                    indexesToRemove = new HashSet<>();
                    break;
                case "Reverse":
                    collected = history.poll();
                    break;
            }
        }
    }

    private static void sumBoth(int searchedValue) {
        for (int i = 0; i < collected.length; i++) {
            int center = collected[i];
            int left = 0;
            int right = 0;
            try {
                left = collected[i - 1];
                right = collected[i + 1];
            } catch (IndexOutOfBoundsException ignored) {
            }
            if (left + center + right == searchedValue) {
                indexesToRemove.add(i);
            }
        }
    }

    private static void sumRight(int searchedValue) {
        for (int i = 0; i < collected.length; i++) {
            int center = collected[i];
            int right = 0;
            try {
                right = collected[i + 1];
            } catch (IndexOutOfBoundsException ignored) {
            }
            if (center + right == searchedValue) {
                indexesToRemove.add(i);
            }
        }
    }

    private static void print() {
        System.out.println(Arrays.toString(collected).replace("]", "").replace("[", "").replace(",", ""));
    }

    private static void sumLeft(int searchedValue) {
        for (int i = 0; i < collected.length; i++) {
            int center = collected[i];
            int left = 0;
            try {
                left = collected[i - 1];
            } catch (IndexOutOfBoundsException ignored) {
            }
            if (center + left == searchedValue) {
                indexesToRemove.add(i);
            }
        }
    }

    private static void removeElementsAtPositions(Set<Integer> indexesToRemove) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < collected.length; i++) {
            if (!indexesToRemove.contains(i)) {
                result.add(collected[i]);
            }
        }
        collected = result.stream().mapToInt(Integer::intValue).toArray();
    }

}
