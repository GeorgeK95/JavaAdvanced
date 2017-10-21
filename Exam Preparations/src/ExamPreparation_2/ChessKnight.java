package ExamPreparation_2;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by George-Lenovo on 6/29/2017.
 */
public class ChessKnight {
    private static char[][] board = new char[8][8];
    private static int invalidMoves = 0;
    private static int outOfBoardMoves = 0;
    private static List<Character> pieces = new ArrayList<>();
    private static List<String> possibleMoves = new ArrayList<>();
    private static Scanner in = new Scanner(System.in);


    public static void main(String[] args) {
        readGameBoard();
        move();
    }

    private static void move() {
        String startPos = in.nextLine();//i think its redundant
        String coordinatesRegex = "(\\d)(\\d)(\\s->\\s)(\\d)(\\d)";

        while (true) {
            String line = in.nextLine();
            if ("END".equals(line)) {
                printGameResult();
                break;
            }
            Matcher m = Pattern.compile(coordinatesRegex).matcher(line);
            m.find();
            makeMove(Integer.parseInt(m.group(1)), Integer.parseInt(m.group(2)),
                    Integer.parseInt(m.group(4)), Integer.parseInt(m.group(5)));
        }

    }

    private static void printGameResult() {
        System.out.printf("Pieces take: %s%n", pieces.toString().replace("[", "").replace("]", ""));
        System.out.printf("Invalid moves: %d%n", invalidMoves);
        System.out.printf("Board out moves: %d%n", outOfBoardMoves);
    }

    private static void makeMove(int startRow, int startCol, int destRow, int destCol) {
        generatePossibleMoves(startRow, startCol);
        try {
            if (!possibleMoves.contains(destRow + "" + destCol)) {
                invalidMoves++;
            } else {
                try {
                    char currentCell = board[destRow][destCol];
                    if (currentCell != ' ') {
                        pieces.add(currentCell);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    outOfBoardMoves++;
                }
            }
        } catch (NullPointerException e) {
            invalidMoves++;
        }


    }

    private static void generatePossibleMoves(int startRow, int startCol) {
        possibleMoves.clear();
        possibleMoves.add(String.valueOf(startRow - 2) + "" + String.valueOf(startCol + 1));
        possibleMoves.add(String.valueOf(startRow - 2) + "" + String.valueOf(startCol - 1));
        possibleMoves.add(String.valueOf(startRow - 1) + "" + String.valueOf(startCol + 2));
        possibleMoves.add(String.valueOf(startRow - 1) + "" + String.valueOf(startCol - 2));
        possibleMoves.add(String.valueOf(startRow + 1) + "" + String.valueOf(startCol - 2));
        possibleMoves.add(String.valueOf(startRow + 1) + "" + String.valueOf(startCol + 2));
        possibleMoves.add(String.valueOf(startRow + 2) + "" + String.valueOf(startCol + 1));
        possibleMoves.add(String.valueOf(startRow + 2) + "" + String.valueOf(startCol - 1));
    }

    private static void readGameBoard() {
        String valuesRegex = "[A-Z ]";
        for (int i = 0; i < board.length; i++) {
            String line = in.nextLine();
            Matcher m = Pattern.compile(valuesRegex).matcher(line);
            int j = 0;

            while (m.find()) {
                char c = m.group().charAt(0);
                board[i][j] = c;
                j++;
            }

        }
    }

}
