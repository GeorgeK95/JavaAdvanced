import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class SoftUniParty {
    public static void main(String[] args) {
        Set<String> guests = new TreeSet<>();
        fillParkingLot(guests);
        printLeftGuests(guests);
    }

    private static void printLeftGuests(Set<String> guests) {
        System.out.println(guests.size());
        for (String guest : guests) {
            System.out.println(guest);
        }
    }

    private static void fillParkingLot(Set<String> guests) {
        Scanner in = new Scanner(System.in);
        boolean isPartyStarted = false;

        while (true) {
            String line = in.nextLine();
            if (line.equals("PARTY")) {
                isPartyStarted = true;
                continue;
            }
            if (line.equals("END")) {
                break;
            }
            if (!isPartyStarted) {
                guests.add(line);
            } else {
                guests.remove(line);
            }
        }
    }
}
