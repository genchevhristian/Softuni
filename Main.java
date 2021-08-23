import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] liquids = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();
        int[] ingredients = Arrays.stream(scanner.nextLine().split("\\s")).mapToInt(Integer::parseInt).toArray();


        ArrayDeque<Integer> liquidQueue = new ArrayDeque();
        for (int i: liquids) {
            liquidQueue.offer(i);
        }

        ArrayDeque<Integer> ingredientStack = new ArrayDeque();
        for (int i :ingredients) {
            ingredientStack.push(i);
        }

        Map<String, Integer> foodMap = new LinkedHashMap<>();
        foodMap.put("Biscuit", 0);
        foodMap.put("Cake", 0);
        foodMap.put("Pie", 0);
        foodMap.put("Pastry", 0);

        while (!liquidQueue.isEmpty() && !ingredientStack.isEmpty()) {
            int firstLiquid = liquidQueue.poll();
            int lastIngredient = ingredientStack.pop();

            int sum = firstLiquid + lastIngredient;

            String food = "";
            int count = 0;

            switch (sum) {
                case 25:
                    food = "Biscuit";
                    count = foodMap.get(food);
                    foodMap.put(food, count + 1);
                    break;
                case 50:
                    food = "Cake";
                    count = foodMap.get(food);
                    foodMap.put(food, count + 1);
                    break;
                case 75:
                    food = "Pie";
                    count = foodMap.get(food);
                    foodMap.put(food, count + 1);
                    break;
                case 100:
                    food = "Pastry";
                    count = foodMap.get(food);
                    foodMap.put(food, count + 1);
                    break;
                default:
                    lastIngredient += 3;
                    ingredientStack.push(lastIngredient);
                    break;
            }
        }



        if(foodMap.values().contains(0)){
            System.out.println("What a pity! You didn't have enough materials to to cook everything.");
        } else {
            System.out.println("Great! You succeeded in cooking all the food!");
        }

        System.out.println("Liquids left: " + getLeftovers(liquidQueue));
        System.out.println("Ingredients left: " + getLeftovers(ingredientStack));

        foodMap.entrySet()
                .forEach(e -> {
                    System.out.printf("%s: %d%n", e.getKey(), e.getValue());
                });
    }

    private static String getLeftovers(ArrayDeque<Integer> list) {
        if (list.isEmpty()) {
            return "none";
        }
        return String.join(", ", String.valueOf(list)
                .replaceAll("[\\[\\]]", ""));

    }
}
