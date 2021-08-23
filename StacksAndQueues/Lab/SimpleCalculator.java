package StacksAndQueues.Lab;

import java.util.*;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String[] tokens = scanner.nextLine().split("\\s+");

        ArrayDeque<String> stack = new ArrayDeque<>();

        for (int i = tokens.length - 1; i >= 0; i--) {
            stack.push(tokens[i]);
        }

        while (stack.size() > 1) {
            int first = Integer.parseInt(stack.pop());
            String operator = stack.pop();
            int second = Integer.parseInt(stack.pop());
            int result = operator.equals("+") ? first + second : first - second;

            stack.push(String.valueOf(result));
        }
        System.out.println(stack.pop());
    }

}


