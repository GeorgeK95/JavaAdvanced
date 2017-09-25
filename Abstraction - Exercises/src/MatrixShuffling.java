import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class MatrixShuffling {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        String[][] matrix = readMatrix();
        executeCommands(matrix);
    }

    private static void executeCommands(String[][] matrix) {
        while (true) {
            String[] command = in.nextLine().split("\\s+");
            if (command.length != 5) {
                if (command[0].equals("END")) {
                    break;
                }
                System.out.println("Invalid input!");
                continue;
            }


            try {
                String first = matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])];
                String second = matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])];

                matrix[Integer.parseInt(command[1])][Integer.parseInt(command[2])] = second;
                matrix[Integer.parseInt(command[3])][Integer.parseInt(command[4])] = first;

                printMatrix(matrix);
            } catch (IndexOutOfBoundsException i) {
                System.out.println("Invalid input!");
            }
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.printf("%s ", string);
            }
            System.out.println();
        }
    }

    private static String[][] readMatrix() {
        String[] size = in.nextLine().split("\\s+");
        String[][] matrix = new String[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
        for (int i = 0; i < matrix.length; i++) {
            String[] line = in.nextLine().split("\\s+");
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = String.valueOf(line[j]);
            }
        }
        return matrix;
    }

}
