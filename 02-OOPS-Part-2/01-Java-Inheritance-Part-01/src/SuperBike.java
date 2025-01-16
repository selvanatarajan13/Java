// subclass or child class
public class SuperBike extends Bikes {

    // define fields
    /*
        This fields refer the super bike features
     */
    private int engineSize;
    private int power;
    private int fuelCapacity;
    private double price;
    private String coolingSystem;

    public SuperBike(String brand, String model, String brakeType, int weight, String color) {
        super(brand, model, brakeType, weight, color);
    }

    public SuperBike(String brand, String model, String brakeType, int weight, String color, int engineSize, int power, int fuelCapacity, double price, String coolingSystem) {
        super(brand, model, brakeType, weight, color);
        this.engineSize = engineSize;
        this.power = power;
        this.fuelCapacity = fuelCapacity;
        this.price = price;
        this.coolingSystem = coolingSystem;
    }

    @Override
    public String toString() {
        return "SuperBike{" +
                "engineSize=" + engineSize +
                ", power=" + power +
                ", fuelCapacity=" + fuelCapacity +
                ", price=" + price +
                "} " + super.toString();
    }
}
