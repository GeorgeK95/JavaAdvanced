import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class RoyalAccounting {
    private static Map<String, Double> total = new HashMap<>();
    private static Map<String, List<Person>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String line = in.nextLine();
            if ("Pishi kuf i da si hodim".equalsIgnoreCase(line)) {
                print();
                break;
            }
            writeData(line);
        }
    }

    private static void print() {
        total = total.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));

        Comparator<? super Person> comp = (Comparator<Person>) (o1, o2) -> {
            int workHours1 = o1.getWorkHoursForDay();
            int workHours2 = o2.getWorkHoursForDay();
            if (workHours1 == workHours2) {
                double dailyIncome1 = o1.getPaymentForDay();
                double dailyIncome2 = o2.getPaymentForDay();
                if (dailyIncome1 == dailyIncome2) {
                    return o1.getName().compareTo(o2.getName());
                }
                return Double.compare(dailyIncome2, dailyIncome1);
            }
            return Integer.compare(workHours2, workHours1);
        };
        for (String team : total.keySet()) {
            System.out.printf("Team - %s%n", team);
            List<Person> people = map.get(team);
            people.sort(comp);
            for (Person person : people) {
                System.out.printf("$$$%s - %d - %.6f%n", person.getName(), person.getWorkHoursForDay(), person.getPaymentForDay());
            }
        }
    }

    private static void writeData(String line) {
        String regex = "^([A-Za-z]+);(\\-?\\d+);(\\-?\\d+[.]?\\d*);([A-Za-z]+)$";
        Matcher m = Pattern.compile(regex).matcher(line);
        if (m.find()) {
            String employeeName = m.group(1);
            if (isThisEmployeeInTeam(employeeName)) {
                return;
            }
            String team = m.group(4);
            int workHoursByDay = Integer.parseInt(m.group(2));
            double dailyPayment = Double.parseDouble(m.group(3));

            double monthlyPayment = ((dailyPayment * workHoursByDay) / 24) * 30;
            total.putIfAbsent(team, 0D);
            total.put(team, total.get(team) + monthlyPayment);

            map.putIfAbsent(team, new ArrayList<>());
            double dailyIncomePerHour = (dailyPayment * workHoursByDay) / 24;
            Person p = new Person(employeeName, workHoursByDay, dailyIncomePerHour);
            map.get(team).add(p);
        }
    }

    private static boolean isThisEmployeeInTeam(String employeeName) {
        for (Map.Entry<String, List<Person>> iter : map.entrySet()) {
            for (Person person : iter.getValue()) {
                if (person.getName().equals(employeeName)) {
                    return true;
                }
            }
        }
        return false;
    }
}

class Person {
    String name;
    int workHoursForDay;
    double paymentForDay;

    public String getName() {
        return name;
    }

    public int getWorkHoursForDay() {
        return workHoursForDay;
    }

    public double getPaymentForDay() {
        return paymentForDay;
    }

    public Person(String name, int workHoursForDay, double paymentForDay) {
        this.name = name;
        this.workHoursForDay = workHoursForDay;
        this.paymentForDay = paymentForDay;
    }
}