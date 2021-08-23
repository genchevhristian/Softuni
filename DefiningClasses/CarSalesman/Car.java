package DefiningClasses.CarSalesman;

public class Car {
    //model, engine, weight and colour
    private String model;
    private Engine engine;
    private int weight;
    private String color;

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getModel() {
        return model;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = 0;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.weight = 0;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }
    @Override
    public String toString(){
        if (this.weight==0){
            return String.format("Weight: n/a%n" + "Color: %s",color);
        }else {
            return String.format("Weight: %d%n" + "Color: %s",weight,color);
        }
    }

}
