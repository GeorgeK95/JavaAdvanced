package ExamPreparation_2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class FootballStats {
    private static Map<String, List<String>> map = new HashMap<>();
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String teamRegex = "(.*)\\s-\\s(.*)\\sresult\\s(\\d+):(\\d+)";
        while (true) {
            String line = in.nextLine();
            if ("Season End".equals(line)) {
                print(in.nextLine().split(", "));
                break;
            }
            Matcher m = Pattern.compile(teamRegex).matcher(line);
            if (m.find()) {
                writeData(m);
            }
        }
    }

    private static void writeData(Matcher m) {
        String home = m.group(1);
        String away = m.group(2);
        int homeGoals = Integer.parseInt(m.group(3));
        int awayGoals = Integer.parseInt(m.group(4));

        map.putIfAbsent(home, new ArrayList<>());
        map.get(home).add(away + " -> " + homeGoals + ":" + awayGoals);
        map.putIfAbsent(away, new ArrayList<>());
        map.get(away).add(home + " -> " + awayGoals + ":" + homeGoals);
    }

    private static void print(String[] teams) {
        for (String team : teams) {
            Comparator<? super String> comparator = new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    String firstTeam = o1.split(" -> ")[0];
                    String secondTeam = o2.split(" -> ")[0];
                    return firstTeam.compareTo(secondTeam);
                }
            };

            List<String> matches = map.get(team).stream().sorted(comparator).collect(Collectors.toList());
            for (String match : matches) {
                System.out.printf("%s - %s%n", team, match);
            }
        }
    }

}
