package DefiningClasses.CarSalesman;

public class Engine {
    private String model;
    private int power;
    private int displacement;
    private String efficiency;

    public Engine(String model, int power) {
        this.model = model;
        this.power = power;
        this.displacement = 0;
        this.efficiency = "n/a";
    }

    public Engine(String model, int power, String efficiency) {
        this.model = model;
        this.power = power;
        this.efficiency = efficiency;
        this.displacement= 0;
    }

    public Engine(String model, int power, int displacement, String efficiency) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = efficiency;
    }

    public Engine(String model, int power, int displacement) {
        this.model = model;
        this.power = power;
        this.displacement = displacement;
        this.efficiency = "n/a";
    }

    @Override
    public String toString(){
        if (this.displacement==0){
            return String.format("%s:%n" + "Power: %d%n" + "Displacement: n/a%n" + "Efficiency: %s",model,power,efficiency );
        }else {
            return String.format("%s:%n" + "Power: %d%n" + "Displacement: %d%n" + "Efficiency: %s",model,power,displacement,efficiency );
        }
    }
}
