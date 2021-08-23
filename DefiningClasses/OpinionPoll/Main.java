package DefiningClasses.OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>(); //хората над 30 год. възраст

        for (int i = 1; i <= n; i++) {
            String personInfo = scanner.nextLine();
            //"Peter 12" -> ["Peter", "12"]
            String name = personInfo.split("\\s+")[0];
            int age = Integer.parseInt(personInfo.split("\\s+")[1]);
            if(age >  30) {
                Person person = new Person(name, age);
                people.add(person);
            }
        }
        //списък с хората над 30
        people.sort(Comparator.comparing(Person::getName));

        for (Person person : people ) {
            System.out.println(person.getName() + " - " + person.getAge());
        }
    }
}
