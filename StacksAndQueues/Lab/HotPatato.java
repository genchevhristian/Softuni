package StacksAndQueues.Lab;
import java.util.ArrayDeque;
import java.util.Scanner;

public class HotPatato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] children = scanner.nextLine().split("\\s+");
        int numberToRemove = Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> queue = new ArrayDeque<>();

        for (String child : children) {
            queue.offer(child);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < numberToRemove; i++) {
                queue.offer(queue.poll());
            }
            System.out.println("Removed " + queue.poll());
        }
        System.out.println("Last is " + queue.poll());
    }
}
