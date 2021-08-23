import java.util.*;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] bombEffects = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();
        int[] bombCases = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).toArray();

        ArrayDeque<Integer> effectQueue = new ArrayDeque<>();
        ArrayDeque<Integer> caseStack = new ArrayDeque<>();

        for (int i = 0; i < bombEffects.length; i++) {
            effectQueue.offer(bombEffects[i]);
        }
        for (int i = 0; i < bombCases.length; i++) {
            caseStack.push(bombCases[i]);

        }

        int daturaCounter = 0;
        int cherryCounter = 0;
        int smokeCounter = 0;

        boolean allBombs = false;

        while (caseStack.size() > 0 && effectQueue.size() > 0) {
            int effect = effectQueue.peek();
            int casing = caseStack.peek();

            if (effect + casing == 40) {
                daturaCounter++;
                caseStack.pop();
                effectQueue.poll();
            } else if (effect + casing == 60) {
                cherryCounter++;
                caseStack.pop();
                effectQueue.poll();
            } else if (effect + casing == 120) {
                smokeCounter++;
                caseStack.pop();
                effectQueue.poll();
            } else {
                caseStack.pop();
                caseStack.push(casing - 5);
            }


            if (daturaCounter >= 3 && cherryCounter >= 3 && smokeCounter >= 3) {
                allBombs = true;
                break;
            }
        }
        if (allBombs) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (effectQueue.size() == 0) {
            System.out.println("Bomb Effects: empty");
        } else if (effectQueue.size() > 0) {
            for (Integer integer : effectQueue) {
                System.out.println("Bomb Effects: " + getLeftovers(effectQueue));
                break;
            }

        }
        if (caseStack.size() == 0) {
            System.out.println("Bomb Casings: empty");
        } else if (caseStack.size() > 0) {
            for (Integer integer : caseStack) {
                System.out.println("Bomb Casings: " + getLeftovers(caseStack));
                break;
            }
        }
        System.out.printf("Cherry Bombs: %d%n", cherryCounter);
        System.out.printf("Datura Bombs: %d%n", daturaCounter);
        System.out.printf("Smoke Decoy Bombs: %d%n", smokeCounter);
    }
    private static String getLeftovers(ArrayDeque<Integer> list) {
        if (list.isEmpty()) {
            return "none";
        }
        return String.join(", ", String.valueOf(list)
                .replaceAll("[\\[\\]]", ""));
    }
}