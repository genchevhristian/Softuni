package SetsAndMaps.Exercises;

import java.util.*;

public class PeriodicTable {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int compoundsNumber = Integer.parseInt(scanner.nextLine());

        TreeSet<String> compounds = new TreeSet<>();

        for (int i = 0; i < compoundsNumber; i++) {
            String elements = scanner.nextLine();
            String [] chemicalElement = elements.split("\\s+");
            Collections.addAll(compounds, chemicalElement);
        }
        for (String compound : compounds) {
            System.out.print(compound + " ");
        }

    }
}
