import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class VehiclePark {
    private static List<String> autopark;
    private static int initialSize;
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        autopark = Arrays.stream(in.nextLine().split("\\s+")).collect(Collectors.toList());
        initialSize = autopark.size();
        sellVehicles();
        printLeftVehicles();
    }

    private static void printLeftVehicles() {
        System.out.println("Vehicles left: " + join());
        System.out.printf("Vehicles sold: %d", initialSize - autopark.size());
    }

    private static String join() {
        StringBuilder builder = new StringBuilder();
        Iterator<?> iter = autopark.iterator();
        while (iter.hasNext()) {
            builder.append(iter.next());
            if (!iter.hasNext()) {
                break;
            }
            builder.append(", ");
        }
        return builder.toString();
    }

    private static void sellVehicles() {
        String vehicleInput = in.nextLine();
        while (!vehicleInput.equals("End of customers!")) {
            String[] split = vehicleInput.split("\\s+");
            char type = split[0].charAt(0);
            int seatsCount = Integer.parseInt(split[2]);
            String vehicle = type + "" + seatsCount;
            if (autopark.contains(vehicle.toLowerCase())) {
                sell(vehicle.toLowerCase());
            } else {
                System.out.println("No");
            }

            vehicleInput = in.nextLine();
        }
    }

    private static void sell(String vehicle) {
        for (int i = 0; i < autopark.size(); i++) {
            String iter = autopark.get(i);
            if (iter.equals(vehicle)) {
                System.out.printf("Yes, sold for %d$%n", (int) vehicle.charAt(0) * Integer.parseInt(vehicle.substring(1)));
                autopark.remove(autopark.indexOf(iter));
                break;
            }
        }
    }
}