import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class LegendaryFarming {
    public static void main(String[] args) {
        Map<String, Integer> goodMaterials = new TreeMap<>();
        goodMaterials.put("shards", 0);
        goodMaterials.put("fragments", 0);
        goodMaterials.put("motes", 0);
        Map<String, Integer> junk = new TreeMap<>();
        Scanner in = new Scanner(System.in);
        boolean isOver = false;

        while (!isOver) {
            String[] splitted = in.nextLine().toLowerCase().split(" ");

            for (int i = 0; i < splitted.length; i += 2) {
                int quantity = Integer.parseInt(splitted[i]);
                String material = splitted[i + 1];

                if (goodMaterials.containsKey(material)) {
                    goodMaterials.put(material, goodMaterials.get(material) + quantity);

                    if (isLimitReached(goodMaterials)) {
                        String winner = getWinner(goodMaterials);
                        print(goodMaterials, junk, winner);
                        isOver = true;
                        break;
                    }
                } else {
                    if (junk.containsKey(material)) {
                        junk.put(material, junk.get(material) + quantity);
                    } else {
                        junk.put(material, quantity);
                    }
                }
            }
        }
    }

    private static void print(Map<String, Integer> goodMaterials, Map<String, Integer> junk, String winner) {
        if (winner.equals("shards")) {
            System.out.println("Shadowmourne" + " obtained!");
        } else if (winner.equals("fragments")) {
            System.out.println("Valanyr" + " obtained!");
        } else {
            System.out.println("Dragonwrath" + " obtained!");
        }
        goodMaterials.put(winner, goodMaterials.get(winner) - 250);

        for (Map.Entry<String, Integer> material : goodMaterials.entrySet().stream()
                .sorted(Comparator.comparing(Map.Entry::getValue, Comparator.reverseOrder()))
                .collect(Collectors.toList())) {
            System.out.printf("%s: %s%n", material.getKey(), material.getValue());
        }
        for (Map.Entry<String, Integer> junkMaterial : junk.entrySet().stream().sorted(Comparator.comparing(Map.Entry::getKey)).collect(Collectors.toList())) {
            System.out.printf("%s: %s%n", junkMaterial.getKey(), junkMaterial.getValue());
        }
    }

    private static String getWinner(Map<String, Integer> goodMaterials) {
        String retValue = "";
        for (Map.Entry<String, Integer> item : goodMaterials.entrySet()) {
            if (item.getValue() >= 250) {
                retValue = item.getKey();

            }
        }
        return retValue;
    }

    private static boolean isLimitReached(Map<String, Integer> goodMaterials) {
        for (Map.Entry<String, Integer> item : goodMaterials.entrySet()) {
            if (item.getValue() >= 250) {
                return true;
            }
        }
        return false;
    }

}
