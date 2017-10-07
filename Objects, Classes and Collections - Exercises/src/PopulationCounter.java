import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class PopulationCounter {
    private static Map<String, List<City>> countries = new LinkedHashMap<>();
    private static List<String> countriesList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if (line.equals("report")) {
                break;
            }
            String[] lines = line.split("\\|");
            String name = lines[0];
            String country = lines[1];
            if (!countriesList.contains(country)) {
                countriesList.add(country);
            }
            City c = new City(name, Long.parseLong(lines[2]));
            List<City> temp = new ArrayList<>();
            if (countries.containsKey(country)) {
                temp = countries.get(country);
            }
            temp.add(c);
            countries.put(country, temp);

        }
        prLong();
    }

    private static void prLong() {
        countries = countries.entrySet().stream().sorted((a, b) -> {
            Long operand1 = a.getValue().stream().mapToLong(City::getPop).sum();
            Long operand2 = b.getValue().stream().mapToLong(City::getPop).sum();
            return operand2.compareTo(operand1);
        }).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
        for (Map.Entry<String, List<City>> country_listOfCities : countries.entrySet()) {
            System.out.printf("%s (total population: %d)%n", country_listOfCities.getKey(), country_listOfCities.getValue()
                    .stream().mapToLong(City::getPop).sum());
            List<City> cities = country_listOfCities.getValue().stream()
                    .sorted(Comparator.comparing(City::getPop).reversed())
                    .collect(Collectors.toList());
            for (City city : cities) {
                System.out.printf("=>%s: %d%n", city.name, city.pop);
            }
        }
    }

}

class City {
    String name;
    Long pop;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPop() {
        return pop;
    }

    public void setPop(Long pop) {
        this.pop = pop;
    }

    public City(String name, Long pop) {

        this.name = name;
        this.pop = pop;
    }
}