package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> people = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        String input = scanner.nextLine();
        while (!input.equals("Party!")) {
            String[] commands = input.split("\\s+");

            Predicate<String> predicate = getPredicate(commands[1], commands[2]);

            if (predicate != null) {
                int count = people.size();
                for (int i = 0; i < people.size(); i++) {
                    if (count-- == 0) {
                        break;
                    }
                    if (predicate.test(people.get(i))) {
                        if (commands[0].equals("Remove")) {
                            people.remove(i);
                            i--;
                        } else {
                            people.add(people.get(i));
                        }
                    }
                }
            }

            input = scanner.nextLine();
        }

        if (people.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.println(people.stream().sorted().collect(Collectors.joining(", "))
                    + " are going to the party!");
        }

    }

    private static Predicate<String> getPredicate(String command, String n) {
        if ("Length".equals(command)) {
            return x -> x.length() == Integer.parseInt(n);
        } else if ("StartsWith".equals(command)) {
            return x -> x.startsWith(n);
        } else if ("EndsWith".equals(command)) {
            return x -> x.endsWith(n);
        }
        return null;

    }
}
