package DefiningClasses.CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            int power = Integer.parseInt(input[1]);
            int displacement = 0;
            String efficiency = "n/a";
            if (input.length == 3) {
                try {
                    displacement = Integer.parseInt(input[2]);
                    Engine engine = new Engine(model, power, displacement);
                    engines.put(model, engine);
                } catch (NumberFormatException e) {
                    efficiency = input[2];
                    Engine engine = new Engine(model, power, efficiency);
                    engines.put(model, engine);
                }
                Engine engine = new Engine(model, power, displacement, efficiency);
                engines.put(model, engine);
            } else if (input.length == 4) {
                displacement = Integer.parseInt(input[2]);
                efficiency = input[3];
                Engine engine = new Engine(model, power, displacement, efficiency);
                engines.put(model, engine);

            } else {
                Engine engine = new Engine(model, power, displacement, efficiency);
                engines.put(model, engine);
            }

        }
        int m = Integer.parseInt(scanner.nextLine());

        while (m-- > 0) {
            String[] input = scanner.nextLine().split("\\s+");
            String model = input[0];
            String engine = input[1];
            int weight = 0;
            String color = "n/a";
            if (input.length == 2) {
                Car car = new Car(model, engines.get(engine));
                cars.add(car);
            } else if (input.length == 3) {
                try {
                    weight = Integer.parseInt(input[2]);
                    Car car = new Car(model, engines.get(engine), weight);
                    cars.add(car);
                } catch (NumberFormatException e) {
                    color = input[2];
                    Car car = new Car(model, engines.get(engine), color);
                    cars.add(car);
                }
            } else {
                weight = Integer.parseInt(input[2]);
                color = input[3];
                Car car = new Car(model, engines.get(engine), weight, color);
                cars.add(car);
            }
        }
        for (Car car : cars) {
            System.out.println(car.getModel() + ":");
            System.out.println(car.getEngine().toString());
            System.out.println(car.toString());
        }

    }
}
