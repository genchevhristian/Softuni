package SetsAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] line = scanner.nextLine().split("\\s+");

        int nLength = Integer.parseInt(line[0]);
        int mLength = Integer.parseInt(line[1]);

        LinkedHashSet<Integer> firstSet = new LinkedHashSet<>(nLength);
        LinkedHashSet<Integer> secondSet = new LinkedHashSet<>(mLength);

        for (int i = 0; i < nLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            firstSet.add(number);
        }

        for (int i = 0; i < mLength; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            secondSet.add(number);
        }

        //{1, 3, 5, 7}
        //{3, 4, 5}

        firstSet.retainAll(secondSet);
        //firstSet -> дублирани елементи

        for (int number : firstSet) {
            System.out.print(number + " ");
        }

    }
}
