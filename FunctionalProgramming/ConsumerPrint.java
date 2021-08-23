package FunctionalProgramming;

import java.util.Scanner;
import java.util.function.Consumer;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String [] input = scanner.nextLine().split("\\s+");
        Consumer<String[]> names = inputName -> {
            for (String s : input) {
                System.out.println(s);
            }
        };
        names.accept(input);
    }
}
