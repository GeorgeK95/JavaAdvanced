import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class HandsOfCards {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        Map<String, List<Integer>> deck = new LinkedHashMap<>();
        Map<String, Integer> typesDict = declarateTypesMap();

        while (!line.equals("JOKER")) {
            List<String> asd = Arrays.stream(line.split(":")).filter(x -> !x.equals("")).collect(Collectors.toList());
            String name = asd.toArray(new String[asd.size()])[0];
            String[] cardsArray = getCards(asd.get(1));

            for (String currentCard : cardsArray) {
                String type = String.valueOf(currentCard.charAt(currentCard.length() - 1));
                int power = getPower(currentCard);
                List<Integer> temp = new ArrayList<>();

                if (deck.containsKey(name)) {
                    temp = deck.get(name);

                    if (!temp.contains(power * typesDict.get(type))) {
                        temp.add(power * typesDict.get(type));
                        deck.put(name, temp);
                    }

                }
                if (!temp.contains(power * typesDict.get(type))) {
                    temp.add(power * typesDict.get(type));
                    deck.put(name, temp);
                }
            }

            line = in.nextLine();
        }

        print(deck);
    }

    private static void print(Map<String, List<Integer>> deck) {
        for (Map.Entry<String, List<Integer>> pair : deck.entrySet()) {
            System.out.printf("%s: %d%n", pair.getKey(), getSumOfList(pair.getValue()));
        }
    }

    private static int getSumOfList(List<Integer> deck) {
        int sum = 0;
        for (Integer integer : deck) {
            sum += integer;
        }
        return sum;
    }

    private static Map<String, Integer> declarateTypesMap() {
        Map<String, Integer> typesDict = new HashMap<>();
        typesDict.put("S", 4);
        typesDict.put("H", 3);
        typesDict.put("D", 2);
        typesDict.put("C", 1);
        return typesDict;
    }

    private static int getPower(String currentCard) {
        Map<String, Integer> powers = new HashMap<>();
        powers.put("J", 11);
        powers.put("Q", 12);
        powers.put("K", 13);
        powers.put("A", 14);

        String powerStr = currentCard.substring(0, currentCard.length() - 1);

        if (powers.containsKey(powerStr)) {
            return powers.get(powerStr);
        }

        return Integer.parseInt(powerStr);
    }

    private static String[] getCards(String v) {
        v = v.trim();
        List<String> temp = Arrays.stream(v.split("[, ]")).filter(x -> !x.equals("")).collect(Collectors.toList());
        return temp.toArray(new String[temp.size()]);
    }
}
