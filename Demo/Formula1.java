package Demo;

import java.util.Scanner;

public class Formula1 {
    static int startRow;
    static int startCol;
    static boolean isReachTheFinish = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[size][size];
        for (int row = 0; row < size; row++) {
            String line = scanner.nextLine();
            matrix[row] = line.toCharArray();
            if (line.contains("P")) {
                startRow = row;
                startCol = line.indexOf("P");
            }
        }

        while (countCommands > 0 && !isReachTheFinish) {
            String command = scanner.nextLine();
            if (command.equals("up")) {
                isReachTheFinish = move(startRow - 1, startCol, matrix, command);
            } else if (command.equals("down")) {
                isReachTheFinish = move(startRow + 1, startCol, matrix, command);
            } else if (command.equals("left")) {
                isReachTheFinish = move(startRow, startCol - 1, matrix, command);
            } else if (command.equals("right")) {
                isReachTheFinish = move(startRow, startCol + 1, matrix, command);
            }

            countCommands--;
        }

        if (isReachTheFinish) {
            System.out.println("Well done, the player won first place!");
        } else {
            System.out.println("Oh no, the player got lost on the track!");
        }
        printMatrix(matrix);
    }

    private static boolean move(int newRow, int newCol, char[][] matrix, String command) {
        matrix[startRow][startCol] = '.';

        if (isOutOdBounds(newRow, newCol, matrix)) {
            int[] newPosition = findPositionOnOtherSide(command, matrix);
            if (matrix[newPosition[0]][newPosition[1]] == 'F') {
                matrix[newPosition[0]][newPosition[1]] = 'P';
                return true;
            }
            matrix[newPosition[0]][newPosition[1]] = 'P';
            startRow = newPosition[0];
            startCol = newPosition[1];
            return false;
        }

        char symbol = matrix[newRow][newCol];
        if (symbol == 'F') {
            matrix[newRow][newCol] = 'P';
            return true;
        } else if (symbol == 'B') {
            int[] nextPosition = findNextPotision(command);
            newRow = nextPosition[0];
            newCol = nextPosition[1];
            if (isOutOdBounds(newRow, newCol, matrix)) {
                int[] positionsOnOtherSide = findPositionOnOtherSide(command, matrix);
                if (matrix[positionsOnOtherSide[0]][positionsOnOtherSide[1]] == 'F') {
                    matrix[positionsOnOtherSide[0]][positionsOnOtherSide[1]] = 'P';
                    return true;
                }
                newRow = positionsOnOtherSide[0];
                newCol = positionsOnOtherSide[1];
            }
        } else if (symbol == 'T') {
            newRow = startRow;
            newCol = startCol;
        }

        matrix[newRow][newCol] = 'P';
        startRow = newRow;
        startCol = newCol;

        return false;
    }

    private static int[] findPositionOnOtherSide(String command, char[][] matrix) {
        int[] indexes = new int[2];
        if ("up".equals(command)) {
            indexes = new int[]{matrix.length - 1, startCol};
        } else if ("down".equals(command)) {
            indexes = new int[]{0, startCol};
        } else if ("left".equals(command)) {
            indexes = new int[]{startRow, matrix.length - 1};
        } else if ("right".equals(command)) {
            indexes = new int[]{startRow, 0};
        }
        return indexes;
    }

    private static boolean isOutOdBounds(int row, int col, char[][] matrix) {
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

    private static int[] findNextPotision(String command) {
        int[] indexes = new int[2];
        if ("up".equals(command)) {
            indexes = new int[]{startRow - 2, startCol};
        } else if ("down".equals(command)) {
            indexes = new int[]{startRow + 2, startCol};
        } else if ("left".equals(command)) {
            indexes = new int[]{startRow, startCol - 2};
        } else if ("right".equals(command)) {
            indexes = new int[]{startRow, startCol + 2};
        }
        return indexes;
    }

    public static void printMatrix(char[][] matrix) {
        for (char[] arr : matrix) {
            for (char element : arr) {
                System.out.print(element);
            }
            System.out.println();
        }
    }
}
