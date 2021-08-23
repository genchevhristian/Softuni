package MultidimensionalArrays.Exercises;

import java.util.Scanner;

public class FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine(); //3, A -> ["3", "A"]
        int size = Integer.parseInt(input.split(", ")[0]);
        String pattern = input.split(", ")[1]; // A или B

        int [][] matrix = new int[size][size];
        if(pattern.equals("A")) {
            //fill matrix pattern A
            fillPatternA(matrix, size);
        } else if (pattern.equals("B")) {
            //fill matrix pattern B
            fillPatternB(matrix, size);
        }
        printMatrix(matrix, size, size);
    }

    private static void fillPatternA(int[][] matrix, int size) {
        //size -> count rows + count cols
        int startNumber = 1;
        for (int col = 0; col < size; col++) {
            for (int row = 0; row < size; row++) {
                matrix[row][col] = startNumber++;
                //startNumber++;
            }
        }
    }

    private static void fillPatternB(int [][] matrix, int size) {
        //четна колона -> 0 до последния
        //нечетна колона -> последния до първия
        int startNumber = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int row = 0; row < size; row++) {
                    matrix[row][col] = startNumber++;
                }
            } else {
                for (int row = size - 1; row >= 0; row--) {
                    matrix[row][col] = startNumber++;
                }
            }
        }
    }

    //print matrix
    public static void printMatrix (int [][] matrix, int rows, int cols) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}

