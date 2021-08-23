package Demo;

import java.util.Scanner;

public class Python {
    static int startRow = 0;
    static int startCol = 0;
    static long sizePython = 1;
    static long foodCount = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[] commands = scanner.nextLine().split(", ");

        char[][] matrix = new char[n][n];

        for (int row = 0; row < n; row++) {
            String line = scanner.nextLine().replaceAll(" ", "");
            matrix[row] = line.toCharArray();
            if (line.contains("s")) {
                startRow = row;
                startCol = line.indexOf("s");
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 'f') {
                    foodCount++;
                }
            }
        }

        boolean isStop = true;
        for (String command : commands) {

            switch (command) {
                case "up":
                    isStop = move(startRow - 1, startCol, matrix, command);
                    break;
                case "down":
                    isStop = move(startRow + 1, startCol, matrix, command);
                    break;
                case "left":
                    isStop = move(startRow, startCol - 1, matrix, command);
                    break;
                case "right":
                    isStop = move(startRow, startCol + 1, matrix, command);
                    break;
            }
            if (!isStop) {
                break;
            }
        }


        if (!isStop) {
            if (foodCount == 0) {
                System.out.println("You win! Final python length is " + sizePython);
            } else {
                System.out.println("You lose! Killed by an enemy!");
            }
        } else {
            System.out.println("You lose! There is still " + foodCount + " food to be eaten.");
        }
        //printMatrix(matrix);


    }

    private static boolean move(int newRow, int newCol, char[][] matrix, String command) {

        matrix[startRow][startCol] = '*';

        if (isOutOfBounds(newRow, newCol, matrix)) {
            switch (command) {
                case "up":
                    newRow = matrix.length - 1;
                    break;
                case "down":
                    newRow = 0;
                    break;
                case "left":
                    newCol = matrix.length - 1;
                    break;
                case "right":
                    newCol = 0;
                    break;
            }
        }
        char symbol = matrix[newRow][newCol];
        if (symbol == 'f') {
            foodCount--;
            sizePython++;
            if (foodCount == 0) {
                return false;
            }
        } else if (symbol == 'e') {
            return false;
        }

        matrix[newRow][newCol] = 's';
        startRow = newRow;
        startCol = newCol;
        return true;
    }

    private static boolean isOutOfBounds(int row, int col, char[][] matrix) {
        // TODO Auto-generated method stub
        return row >= matrix.length || row < 0 || col >= matrix[row].length || col < 0;
    }

}
