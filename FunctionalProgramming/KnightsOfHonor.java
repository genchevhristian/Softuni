package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        Consumer<String[]> names = inputName -> {
            for (String s : input) {
                System.out.print("Sir " + s);
                System.out.println();
            }
        };
        names.accept(input);

    }
}
