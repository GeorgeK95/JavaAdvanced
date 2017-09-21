import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ReadInput {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstString = in.next("\\w+");
        String secondString = in.next("\\w+");
        in.nextLine();
        int num_1 = in.nextInt();
        int num_2 = in.nextInt();
        int num_3 = in.nextInt();
        in.nextLine();
        String lastString = in.nextLine();
        System.out.println(firstString + " " + secondString + " " + lastString + " " + sum(num_1, num_2, num_3));
    }

    private static Integer sum(int num_1, int num_2, int num_3) {
        return num_1 + num_2 + num_3;
    }
}
