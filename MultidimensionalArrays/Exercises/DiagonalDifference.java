package MultidimensionalArrays.Exercises;

import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[size][size];
        int[] input = new int[size];
        int sumDiagonal1 = 0, sumDiagonal2 = 0;

        for (int i = 0; i < size; i++) {
            input = Arrays.stream(scanner.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < size; j++) {
                matrix[i][j] = input[j];
                if (i == j) {
                    sumDiagonal1 += matrix[i][j];
                }
                if (size - 1 - i == j) {
                    sumDiagonal2 += matrix[i][j];
                }
            }
        }
        System.out.println((Math.abs(sumDiagonal1 - sumDiagonal2)));
    }
}
