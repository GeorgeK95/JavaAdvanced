import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/217.
 */
public class Phonebook {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<String, String> phoneBook = new HashMap<>();
        boolean isSearch = false;

        while (true) {
            String command = in.nextLine();
            String[] splittedCommand = command.split("-");
            String current = splittedCommand[0];
            if (current.equals("stop")) {
                break;
            }
            if (current.equals("search")) {
                isSearch = true;
                continue;
            }
            if (!isSearch) {
                addContact(phoneBook, splittedCommand);
            } else {
                isSearch = true;
                searchContact(phoneBook, current);
            }

        }
    }

    private static void searchContact(Map<String, String> phoneBook, String splittedCommand) {
        if (phoneBook.containsKey(splittedCommand)) {
            System.out.printf("%s -> %s%n", splittedCommand, phoneBook.get(splittedCommand));
        } else {
            System.out.printf("Contact %s does not exist.%n", splittedCommand);
        }
    }

    private static void addContact(Map<String, String> phoneBook, String[] splittedCommand) {
        phoneBook.put(splittedCommand[0],splittedCommand[1]);
    }
}
