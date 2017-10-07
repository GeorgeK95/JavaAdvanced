import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class AMinerTask {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String resources = "";
        Map<String, Integer> minerHolder = new HashMap<>();

        while (true) {
            resources = in.nextLine();

            if (resources.equals("stop")) {
                break;
            }

            int quantity = Integer.parseInt(in.nextLine());
            addResources(minerHolder, resources, quantity);
        }

        print(minerHolder);
    }

    private static void print(Map<String, Integer> minerHolder) {
        for (Map.Entry<String, Integer> pair : minerHolder.entrySet()) {
            System.out.printf("%s -> %s%n", pair.getKey(), pair.getValue());
        }
    }

    private static void addResources(Map<String, Integer> minerHolder, String resources, int quantity) {
        if (minerHolder.containsKey(resources)) {
            minerHolder.put(resources, minerHolder.get(resources) + quantity);
        } else {
            minerHolder.put(resources, quantity);
        }
    }
}
