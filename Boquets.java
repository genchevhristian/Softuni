import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Boquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String firstLine = scanner.nextLine(); // tulips
        String secondLine = scanner.nextLine(); // daffodils

        ArrayDeque<Integer> tulips = new ArrayDeque<>();

        for (String s : firstLine.split(", ")) {
            int i = Integer.parseInt(s);
            tulips.push(i);
        }

        ArrayDeque<Integer> daffodils = Arrays.stream(secondLine.split(", "))
                .map(Integer::parseInt).collect(Collectors.toCollection(ArrayDeque::new));

        int boquetCounts = 0;
        int otherSum = 0;

        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            int currentTulip = tulips.peek();
            int currentDaff = daffodils.peek();
            int sum = currentTulip + currentDaff;
            if (sum == 15) {
                boquetCounts++;
                tulips.pop();
                daffodils.poll();
            } else if (sum > 15) {
                tulips.pop();
                currentTulip = currentTulip - 2;
                tulips.push(currentTulip);
            } else {
                otherSum += sum;
                tulips.pop();
                daffodils.poll();
            }
        }
        if (boquetCounts >= 5) {
            System.out.printf("You made it! You go to the competition with %d bouquets!", boquetCounts);
        } else {
            int moreBoquets = (otherSum / 15);
            int boquetsNeeded = 5 - (boquetCounts + moreBoquets);
            System.out.printf("You failed... You need more %d bouquets.", boquetsNeeded);
        }
    }
}
