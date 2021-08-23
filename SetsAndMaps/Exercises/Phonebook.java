package SetsAndMaps.Exercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        HashMap<String, String> phonebook = new HashMap<>();

        String command = "";
        while (!input.equals("search")) {
            //input (запис) => "John-00359888001122" -> split("-") -> ["John", "00359888001122"]
            String name = input.split("-")[0];
            String phoneNumber = input.split("-")[1];
            phonebook.put(name, phoneNumber);
            input = scanner.nextLine();
        }

        String name = scanner.nextLine();
        while (!name.equals("stop")) {
            //името го има в тел. указател
            if (phonebook.containsKey(name)) {
                System.out.printf("%s -> %s%n", name, phonebook.get(name));
            } else { //името да го няма в тел. указател
                System.out.printf("Contact %s does not exist.%n", name);
            }
            name = scanner.nextLine();
        }
    }
}
