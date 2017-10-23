import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RoyalFlush {

    public static void main(String[] args) {
        StringBuilder allCardsBuilder = getCards();//new StringBuilder();
        String pattern = "(2|3|4|5|6|7|8|9|10|J|Q|K|A)(c|d|h|s)";
        List<String> allCardNumbers = Arrays.asList("10", "J", "Q", "K", "A");
        List<String> allCardSuits = Arrays.asList("Diamonds", "Spades", "Hearts", "Clubs");
        List<String> allCardSuitsShort = Arrays.asList("d", "s", "h", "c");

        Map<String, List<String>> combination = new HashMap<>();
        Matcher matcher = Pattern.compile(pattern).matcher(allCardsBuilder);
        int royals = 0;

        while (matcher.find()) {
            String currentCardNumber = matcher.group(1);
            String currentCardSuit = matcher.group(2);
            combination.putIfAbsent(currentCardSuit, new ArrayList<>());
            if (combination.get(currentCardSuit).size() == 0) {
                if (allCardNumbers.indexOf(currentCardNumber) == 0) {
                    combination.get(currentCardSuit).add(currentCardNumber);
                }
            } else {
                if (combination.get(currentCardSuit).size() == allCardNumbers.indexOf(currentCardNumber)) {
                    combination.get(currentCardSuit).add(currentCardNumber);
                } else {
                    combination.get(currentCardSuit).clear();
                    if (allCardNumbers.indexOf(currentCardNumber) == 0) {
                        combination.get(currentCardSuit).add(currentCardNumber);
                    }
                }
            }

            if (combination.get(currentCardSuit).size() == 5) {
                System.out.printf("Royal Flush Found - %s%n", allCardSuits.get(allCardSuitsShort.indexOf(currentCardSuit)));
                combination.get(currentCardSuit).clear();
                royals++;
            }
        }

        System.out.printf("Royal's Royal Flushes - %d.", royals);
    }

    private static StringBuilder getCards() {
        StringBuilder cards = new StringBuilder();
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String line = in.nextLine();
            cards.append(line);
        }
        return cards;
    }
}
