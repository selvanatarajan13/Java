// Parent class or Super class
public class Bikes {

    // fields
    /*
        This fields has some common factors that can applied to the most of the bikes.
     */
    private String brand;
    private String model;
    private String brakeType;
    private int weight;
    private String color;

    // define constructor for create object

    public Bikes(String brand, String model, String brakeType, int weight, String color) {
        this.brand = brand;
        this.model = model;
        this.brakeType = brakeType;
        this.weight = weight;
        this.color = color;
    }

    // define toString() method for display the data


    @Override
    public String toString() {
        return "Bikes{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", brakeType='" + brakeType + '\'' +
                ", weight=" + weight +
                ", color='" + color + '\'' +
                '}';
    }
}
