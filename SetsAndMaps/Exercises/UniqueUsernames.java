package SetsAndMaps.Exercises;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int seqUsernames = Integer.parseInt(scanner.nextLine());

        LinkedHashSet<String> data = new LinkedHashSet<>();

        for (int i = 0; i < seqUsernames; i++) {
            String line = scanner.nextLine();
            data.add(line);
        }
        for (String word : data) {
            System.out.println(word);
        }
    }
}

