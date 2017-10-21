package ExamPreparation_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Highscore {
    private static Map<String, List<String>> duels = new HashMap<>();
    private static Map<String, Long> score = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = in.readLine();
            if ("osu!".equalsIgnoreCase(line)) {
                printResult();
                break;
            }
            writeData(line);
        }
    }

    private static void writeData(String line) {
        String regex = "(\\d+)\\s([A-Za-z0-9]+)<->([A-Za-z0-9]+)\\s(\\d+)";
        Matcher m = Pattern.compile(regex).matcher(line);
        if (m.find()) {
            long player_1Score = Long.parseLong(m.group(1));
            String player_1 = m.group(2);
            String player_2 = m.group(3);
            long player_2Score = Long.parseLong(m.group(4));
            score.putIfAbsent(player_1, 0L);
            score.putIfAbsent(player_2, 0L);
            score.put(player_1, score.get(player_1) + player_1Score - player_2Score);
            score.put(player_2, score.get(player_2) + player_2Score - player_1Score);
            duels.putIfAbsent(player_1, new ArrayList<>());
            duels.get(player_1).add(player_2 + " <-> " + (player_1Score - player_2Score));
            duels.putIfAbsent(player_2, new ArrayList<>());
            duels.get(player_2).add(player_1 + " <-> " + (player_2Score - player_1Score));
        }
    }

    private static void printResult() {
        score = score.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        for (Map.Entry<String, Long> nameScore : score.entrySet()) {
            System.out.printf("%s - (%d)%n", nameScore.getKey(), nameScore.getValue());
            List<String> oponents = duels.get(nameScore.getKey());
            for (String oponent : oponents) {
                System.out.printf("*   %s%n", oponent);
            }
        }
    }
}
