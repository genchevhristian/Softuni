import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class OSPlanning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] tasks = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] threads = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int taskToKill = Integer.parseInt(scanner.nextLine());

        ArrayDeque<Integer> stackTasks = new ArrayDeque<>();
        ArrayDeque<Integer> queueThreads = new ArrayDeque<>();

        for (int i = 0; i < tasks.length; i++) {
            stackTasks.push(tasks[i]);
        }
        for (int i = 0; i < threads.length; i++) {
            queueThreads.offer(threads[i]);
        }
        int finalThread = 0;
        int finalTask = 0;
        while (stackTasks.size() > 0 && queueThreads.size() > 0) {
            int task = stackTasks.peek();
            int thread = queueThreads.peek();

            if (thread >= task && taskToKill != task) {

                stackTasks.pop();
                queueThreads.poll();

            }
            if (thread >= task && taskToKill == task) {
                finalThread = thread;
                break;
            } else if (thread < task) {
                if (task == taskToKill) {
                    finalThread = thread;
                    //stackTasks.pop();

                    break;
                }
                queueThreads.poll();
                // finalTask = task;
            }

        }
        System.out.printf("Thread with value %d killed task %d%n", finalThread, taskToKill);
        System.out.println(getLeftOvers(queueThreads));
    }

    private static String getLeftOvers(ArrayDeque<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer integer : list) {
            stringBuilder.append(integer + " ");
        }
        return stringBuilder.toString();
    }
}
