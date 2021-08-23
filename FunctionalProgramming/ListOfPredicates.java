package FunctionalProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] dividers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Predicate<Integer> isDivisible = x -> {
            for (int divider : dividers) {
                if (x % divider != 0) {
                    return false;
                }
            }
            return true;
        };

        getNumbersInRange(n).forEach(e -> {
            if (isDivisible.test(e)) {
                System.out.print(e + " ");
            }
        });
    }

    private static List<Integer> getNumbersInRange(int n) {
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            temp.add(i);
        }
        return temp;
}

}


