package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> stack = new ArrayDeque<>();
        String urlOrCommand = scanner.nextLine();
        String current = "";

        while (!urlOrCommand.equals("Home")) {
            if (urlOrCommand.equals("back")) {
                if (!stack.isEmpty()) {
                    current = stack.pop();
                } else {
                    System.out.println("no previous URLs");
                    urlOrCommand = scanner.nextLine();
                    continue;
                }
            } else {
                if (!current.equals("")) {
                    stack.push(current);
                }
                current = urlOrCommand;
            }
            System.out.println(current);
            urlOrCommand = scanner.nextLine();
        }

    }
}

