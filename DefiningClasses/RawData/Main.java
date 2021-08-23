package DefiningClasses.RawData;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int carsCount = Integer.parseInt(scanner.nextLine());
        Car[] cars = new Car[carsCount];

        while (carsCount-- > 0) {
            String[] tokens = scanner.nextLine().split("\\s+");
            cars[cars.length - 1 - carsCount] = getCar(tokens);
        }

        Predicate<Car> filterCars = getCarFilter(scanner.nextLine());

        Arrays.stream(cars)
                .filter(filterCars)
                .forEach(car -> System.out.println(car.getModel()));
    }

    private static Predicate<Car> getCarFilter(String filterType) {
        if (filterType.equals("fragile")) {
            return car -> car.getCargo().getType().equals(filterType) &&
                    Arrays.stream(car.getTires()).anyMatch(tire -> tire.getTirePressure() < 1);
        } else {
            return car -> car.getCargo().getType().equals(filterType) &&
                    car.getEngine().getEnginePower() > 250;
        }
    }

    private static Car getCar(String[] tokens) {
        String model = tokens[0];
        int engineSpeed = Integer.parseInt(tokens[1]);
        int enginePower = Integer.parseInt(tokens[2]);
        int cargoWeight = Integer.parseInt(tokens[3]);
        String cargoType = tokens[4];

        double[] tiresPressure = new double[4];
        int[] tiresAge = new int[4];
        int tokenIndex = 5;
        for (int i = 0; i < 4; i++) {
            tiresPressure[i] = Double.parseDouble(tokens[tokenIndex++]);
            tiresAge[i] = Integer.parseInt(tokens[tokenIndex++]);
        }

        return new Car(model, engineSpeed, enginePower, cargoWeight, cargoType, tiresPressure, tiresAge);
    }
}
