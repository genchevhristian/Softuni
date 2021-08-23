package StacksAndQueues.Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();
        String printerInput = scanner.nextLine();

        while (!printerInput.equals("print")){
            if (printerInput.equals("cancel")){
                String canceledInput = queue.poll();
                if (canceledInput == null){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " + canceledInput);
                }
            }else {
                queue.offer(printerInput);

                }
            printerInput = scanner.nextLine();
            }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
    }
}
