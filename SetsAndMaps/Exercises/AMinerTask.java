package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();


        while (true) {
            String resource = scanner.nextLine();
            if (resource.equals("stop")) {
                break;
            }
            if (!map.containsKey(resource)) {
                map.put(resource, 0);
            }
            Integer quantity = Integer.parseInt(scanner.nextLine());
            map.put(resource, map.get(resource) + quantity);

        }
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            System.out.printf("%s -> %d%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }
}
