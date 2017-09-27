import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ParseURL {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] url = in.nextLine().split("://");
        if (url.length == 2) {
            printOutput(url);
        } else {
            System.out.println("Invalid URL");
        }
    }

    private static void printOutput(String[] url) {
        String server = url[1].substring(0, url[1].indexOf("/"));
        String resources = url[1].substring(url[1].indexOf("/") + 1);
        System.out.printf("Protocol = %s\n" +
                "Server = %s\n" +
                "Resources = %s\n", url[0], server, resources);
    }

}
