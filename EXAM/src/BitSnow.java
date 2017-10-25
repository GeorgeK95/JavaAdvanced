import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class BitSnow {
    private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] numbers = readNumbers();

        for (int j = 0; j < numbers.length - 2; j++) {
            for (int i = numbers.length - 1; i > 0; i--) {
                int prev = numbers[i];
                numbers[i] = numbers[i] | numbers[i - 1];
                numbers[i - 1] = numbers[i - 1] & prev;
            }
        }

        print(numbers);
    }

    private static void print(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int number : numbers) {
            sb.append(number);
            sb.append(", ");
        }
        System.out.println(sb.substring(0, sb.length() - 2));
    }

    private static int[] readNumbers() throws IOException {
        String[] line = in.readLine().split(", ");
        int[] numbers = new int[line.length];
        int index = 0;
        for (String current : line) {
            numbers[index] = Integer.parseInt(current);
            index++;
        }
        return numbers;
    }
}
