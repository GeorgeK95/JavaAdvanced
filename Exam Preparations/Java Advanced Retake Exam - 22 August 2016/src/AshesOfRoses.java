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
public class AshesOfRoses {
    private static Map<String, Long> regionAmount = new HashMap<>();
    private static Map<String, Map<String, Long>> regionColorsAmount = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = in.readLine();
            if ("Icarus, Ignite!".equalsIgnoreCase(line)) {
                printResult();
                break;
            }

            writeData(line);
        }
    }

    private static void writeData(String line) {
        String regex = "^Grow\\s<([A-Z][a-z]+)>\\s<([A-Za-z0-9]+)>\\s(\\d+)$";
        Matcher m = Pattern.compile(regex).matcher(line);

        if (m.find()) {
            String region = m.group(1);
            String color = m.group(2);
            int amount = Integer.parseInt(m.group(3));

            regionColorsAmount.putIfAbsent(region, new HashMap<>());
            regionColorsAmount.get(region).putIfAbsent(color, 0L);
            regionColorsAmount.get(region).put(color, regionColorsAmount.get(region).get(color) + amount);

            regionAmount.putIfAbsent(region, 0L);
            regionAmount.put(region, regionAmount.get(region) + amount);
        }
    }

    private static void printResult() {
        Comparator<? super Map.Entry<String, Long>> comparator = (Comparator<Map.Entry<String, Long>>) (o1, o2) -> {
            long f = o1.getValue();
            long s = o2.getValue();
            int res = Long.compare(s, f);
            if (res == 0) {
                return o1.getKey().compareTo(o2.getKey());
            }
            return res;
        };
        regionAmount = regionAmount.entrySet()
                .stream()
                .sorted(comparator)
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
        for (Map.Entry<String, Long> regAm : regionAmount.entrySet()) {
            System.out.printf("%s%n", regAm.getKey());

            Map<String, Long> colorAmount = regionColorsAmount.get(regAm.getKey());
            Comparator<? super Map.Entry<String, Long>> comparator2 = (Comparator<Map.Entry<String, Long>>) (o1, o2) -> {
                long f = o1.getValue();
                long s = o2.getValue();
                int res = Long.compare(f, s);
                if (res == 0) {
                    return o1.getKey().compareTo(o2.getKey());
                }
                return res;
            };
            colorAmount = colorAmount.entrySet().stream().sorted(comparator2).collect(Collectors.toMap(
                    Map.Entry::getKey,
                    Map.Entry::getValue,
                    (e1, e2) -> e1,
                    LinkedHashMap::new
            ));
            for (Map.Entry<String, Long> currentPair : colorAmount.entrySet()) {
                System.out.printf("*--%s | %d%n", currentPair.getKey(), currentPair.getValue());
            }
        }
    }

}
