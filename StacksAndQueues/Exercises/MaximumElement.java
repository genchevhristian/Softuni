package StacksAndQueues.Exercises;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfCommands = Integer.parseInt(scanner.nextLine()); //броят на командите
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int count = 0; count < numberOfCommands ; count++) {
            String currentCommand = scanner.nextLine();

            if(currentCommand.equals("2")){
                stack.pop();
            } else if (currentCommand.equals("3")) {
                if(!stack.isEmpty()) {
                    System.out.println(Collections.max(stack));
                }
            } else if (currentCommand.split("\\s+")[0].equals("1")) {
                int pushElement = Integer.parseInt(currentCommand.split(" ")[1]);
                stack.push(pushElement);
            }
        }
    }
}

