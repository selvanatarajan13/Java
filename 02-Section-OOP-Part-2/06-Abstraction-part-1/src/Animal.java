public abstract class Animal {

    private String type;
    private String size;
    private double weight;

    public Animal(String type, String size, double weight) {
        this.type = type;
        this.size = size;
        this.weight = weight;
    }

    public abstract void move(String speed);

    public abstract void makeNoise();

    public String getType() {
        return type;
    }

    public String getSize() {
        return size;
    }

    public double getWeight() {
        return weight;
    }
}
