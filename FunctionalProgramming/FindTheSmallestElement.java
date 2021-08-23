package FunctionalProgramming;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class FindTheSmallestElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //приемаме списък -> печатаме индекса на най-малкото число
        List<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Consumer<List<Integer>> minElement = list -> {
            int min = Integer.MAX_VALUE;
            for (int number : list) {
                if(number < min) {
                    min = number;
                }
            }
            //минималното число
            System.out.println(list.lastIndexOf(min));
        };

        minElement.accept(numbers);

    }
}
