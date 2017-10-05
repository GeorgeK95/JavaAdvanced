import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ParkingLot {

    public static void main(String[] args) {
        Set<String> parkingLot = new HashSet<>();
        fillParkingLot(parkingLot);
        printLeftCars(parkingLot);
    }

    private static void printLeftCars(Set<String> parkingLot) {
        if (parkingLot.size() > 0) {
            for (String currentCar : parkingLot) {
                System.out.println(currentCar);
            }
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }

    private static void fillParkingLot(Set<String> parkingLot) {
        Scanner in = new Scanner(System.in);
        while (true) {
            String[] line = in.nextLine().split(", ");
            String command = line[0];
            if (command.equals("END")) {
                break;
            }
            String number = line[1];
            if (command.equals("IN")) {
                parkingLot.add(number);
            } else if (command.equals("OUT")) {
                parkingLot.remove(number);
            }
        }
    }

}
