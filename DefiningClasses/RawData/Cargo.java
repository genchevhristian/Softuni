package DefiningClasses.RawData;

public class Cargo {
    private String type;
    private int weight;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Cargo(String type, int weight) {
        this.type = type;
        this.weight = weight;
    }
}
