package FunctionalProgramming;

import java.util.*;
import java.util.function.Function;


public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] intNum = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        System.out.println(findMinElement.apply(intNum));
    }

    private static final Function<int[], Integer> findMinElement = new Function<int[], Integer>() {
        public Integer apply(int[] array) {
            int minimum = array[0];
            for (Integer num : array) {
                if (minimum > num) {
                    minimum = num;
                }
            }
            return minimum;
        }
    };

}
