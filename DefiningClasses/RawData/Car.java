package DefiningClasses.RawData;

public class Car {
    private String model;
    private Engine engine;
    private Cargo cargo;
    private Tire[] tires;

    public Car(String model, int engineSpeed, int enginePower, int cargoWeight,
               String cargoType, double[] tiresPressure, int[] tiresAge) {
        this.model = model;
        this.engine = new Engine(engineSpeed, enginePower);
        this.cargo = new Cargo(cargoType, cargoWeight);
        this.tires = new Tire[4];
        for (int i = 0; i < tires.length; i++) {
            this.tires[i] = new Tire(tiresPressure[i], tiresAge[i]);
        }
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Tire[] getTires() {
        return tires;
    }

    public Tire getTire(int index) {
        if (index > 0 && index < tires.length) {
            return tires[index];
        }

        return null;
    }
}
