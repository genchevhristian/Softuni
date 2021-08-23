import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Snake {

    public static BufferedReader cylon = new BufferedReader(new InputStreamReader(System.in));
    public static char[][] matrix;
    public static int[] player = new int[2];
    public static int score = 0;
    public static int[] burrow = new int[4];

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(cylon.readLine());
        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        populateMatrix(size);

        while(true) {
            boolean test = movePlayer();

            if (score >= 10) {
                System.out.println("You won! You fed the snake.");
                break;
            } else if (!test) {
                System.out.println("Game over!");
                break;
            }
        }
        printMatrix();
    }


    public static void populateMatrix(Integer size) throws IOException {

        matrix = new char[size][size];
        boolean firstBurrow = false;

        for (int i = 0; i < size; i++) {
            String line = cylon.readLine();

            if (line.contains("S")) {
                player[0] = i;
                player[1] = line.indexOf("S");
            }

            matrix[i] = line.toCharArray();

            if (line.contains("B") && !firstBurrow) { // First Burrow
                burrow[0] = i;
                burrow[1] = line.indexOf("B");
                matrix[burrow[0]][burrow[1]] = 'B';
                firstBurrow = true;
            }

            if (line.contains("B")) { // Second Burrow
                burrow[2] = i;
                burrow[3] = line.lastIndexOf("B");
                matrix[burrow[2]][burrow[3]] = 'B';
            }
        }
    }

    public static boolean movePlayer() throws IOException { // Returns a char on the new matrix coordinates
        String command = cylon.readLine();
        boolean test = true;

        switch (command) {
            case "up":
                test = newPlayerPos(-1, 0);
                break;
            case "down":
                test = newPlayerPos(1, 0);
                break;
            case "left":
                test = newPlayerPos(0, -1);
                break;
            case "right":
                test = newPlayerPos(0, 1);
                break;
        }

        return test;
    }

    public static boolean newPlayerPos(Integer row, Integer col) {
        matrix[player[0]][player[1]] = '.';
        player[0] += row;
        player[1] += col;

        if (player[0] < 0 || player[1] < 0 || player[0] >= matrix.length || player[1] >= matrix.length) {
            return false;

        } else {

            if (matrix[player[0]][player[1]] == 'B') goToOtherBurrow();
            else if (matrix[player[0]][player[1]] == '*') score++;
            matrix[player[0]][player[1]] = 'S';
            return true;
        }
    }

    public static void goToOtherBurrow() {

        if (player[0] == burrow[0] && player[1] == burrow[1]) {
            player[0] = burrow[2];
            player[1] = burrow[3];
        } else {
            player[0] = burrow[0];
            player[1] = burrow[1];
        }
        matrix[burrow[0]][burrow[1]] = '.';
        matrix[burrow[2]][burrow[3]] = '.';
    }

    public static void printMatrix() {
        System.out.printf("Food eaten: %d%n", score);
        for (int i = 0; i < matrix.length; i++) {
            for (int ii = 0; ii < matrix[i].length; ii++) {
                System.out.printf("%c", matrix[i][ii]);
            }
            System.out.println();
        }

    }
}
