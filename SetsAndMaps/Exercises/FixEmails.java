package SetsAndMaps.Exercises;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> map = new LinkedHashMap<>();


        while (true) {
            String name = scanner.nextLine();
            if (name.equals("stop")) {
                break;
            }
            String email = scanner.nextLine();
            if (!map.containsKey(name)) {
                if (!email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com")) {
                    //валиден
                    map.put(name, email);
                }
            }
        }
        for (Map.Entry<String, String> stringIntegerEntry : map.entrySet()) {
            System.out.printf("%s -> %s%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }
}
