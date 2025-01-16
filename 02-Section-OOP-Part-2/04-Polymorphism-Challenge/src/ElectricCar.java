public class ElectricCar extends Car {

    private double avgKmPerCharge;
    private int batteryCapacity;


    public ElectricCar(String description) {
        super(description);
    }

    public ElectricCar(String description, double avgKmPerCharge, int batteryCapacity) {
        super(description);
        this.avgKmPerCharge = avgKmPerCharge;
        this.batteryCapacity = batteryCapacity;
    }

    @Override
    public void startEngine() {
        super.startEngine();
        System.out.printf(this.getClass().getSimpleName() + "-> swith %d kwh battery on, Ready to drag..%n", batteryCapacity);
    }

    @Override
    public void drive() {
        super.drive();
        System.out.printf(this.getClass().getSimpleName() + "-> Usage exceeds the average: %.2f KmPerCharge%n", avgKmPerCharge);
        System.out.println("---------------------------------------");
    }
}
