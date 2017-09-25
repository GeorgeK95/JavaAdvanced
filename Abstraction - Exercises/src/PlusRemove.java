import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class PlusRemove {
    private static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        List<List<Character>> matrix = readMatrix();
        removePlusShapes(matrix);
    }

    private static void removePlusShapes(List<List<Character>> matrix) {
        HashSet<String> indexesToRemove = new HashSet<>();

        for (int i = 0; i < matrix.size() - 2; i++) {
            for (int j = 1; j < matrix.get(i).size(); j++) {
                try {
                    char current = (matrix.get(i).get(j) + "").toLowerCase().charAt(0);
                    if (current == (matrix.get(i + 1).get(j) + "").toLowerCase().charAt(0) &&
                            current == (matrix.get(i + 1).get(j - 1) + "").toLowerCase().charAt(0) &&
                            current == (matrix.get(i + 1).get(j + 1) + "").toLowerCase().charAt(0) &&
                            current == (matrix.get(i + 2).get(j) + "").toLowerCase().charAt(0)) {
                        indexesToRemove.add(String.valueOf(i) + " " + j);
                        indexesToRemove.add(String.valueOf(i + 1) + " " + j);
                        indexesToRemove.add(String.valueOf(i + 2) + " " + (j));
                        indexesToRemove.add(String.valueOf(i + 1) + " " + (j - 1));
                        indexesToRemove.add(String.valueOf(i + 1) + " " + (j + 1));
                    }
                } catch (IndexOutOfBoundsException ex) {

                }
            }
        }

        List<List<Character>> lists = replaceElements(indexesToRemove, matrix);
        printResult(lists);
    }

    private static void printResult(List<List<Character>> lists) {
        for (List<Character> list : lists) {
            for (Character character : list) {
                System.out.print(character);
            }
            System.out.println();
        }
    }

    private static List<List<Character>> replaceElements(HashSet<String> indexesToRemove, List<List<Character>> matrix) {
        List<List<Character>> matrixNew = new ArrayList<>();

        for (int i = 0; i < matrix.size(); i++) {
            List<Character> temp = new ArrayList<>();
            for (int j = 0; j < matrix.get(i).size(); j++) {
                if (!indexesToRemove.contains(i + " " + j)) {
                    temp.add(matrix.get(i).get(j));
                }

            }
            matrixNew.add(temp);
        }
        return matrixNew;

    }

    private static List<List<Character>> readMatrix() {
        List<List<Character>> list = new ArrayList<>();

        while (true) {
            String line = in.nextLine();
            if (line.equals("END")) {
                break;
            }
            List<Character> opa = new ArrayList<>();
            for (char c : line.toCharArray()) {
                opa.add(c);
            }
            list.add(opa);
        }

        return list;
    }

}
