import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class Greeting {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstName = in.nextLine();
        String lastName = in.nextLine();
        printGreeting(firstName, lastName);
    }

    private static void printGreeting(String firstName, String lastName) {
        if (firstName.isEmpty()) {
            firstName = "*****";
        }
        if (lastName.isEmpty()) {
            lastName = "*****";
        }
        System.out.printf("Hello, %s %s!", firstName, lastName);
    }
}
