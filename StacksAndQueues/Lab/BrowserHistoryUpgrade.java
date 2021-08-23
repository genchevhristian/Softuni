package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistoryUpgrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        ArrayDeque <String> stack = new ArrayDeque<>();
        ArrayDeque <String> queue = new ArrayDeque<>();

        while (!input.equals("Home")){
            if (input.equals("back")){
                if (stack.size() < 2){
                    System.out.println("no previous URLs");
                }
                else {
                    String currentUrl = stack.pop();
                    queue.push(currentUrl);
                    System.out.println(stack.peek());
                }
            }
            else if (input.equals("forward")){
                if (queue.isEmpty()){
                    System.out.println("no next URLs");
                }
                else {
                    String currentForward = queue.pop();
                    System.out.println(currentForward);
                    stack.push(currentForward);
                }
            }
            else {
                stack.push(input);
                System.out.println(input);
                queue.clear();
            }
            input = scanner.nextLine();
        }
    }
}
