public class Car {

    private Engine engine;
    private Transmission transmission;
    private String color;
    private String model;

    public Car(Engine engine, Transmission transmission, String color, String model) {
        this.engine = engine;
        this.transmission = transmission;
        this.color = color;
        this.model = model;
    }

    public void accelerate() {
        engine.start();
        transmission.shiftGear(1);
        System.out.println("Accelerating..");
    }

    public void brake() {
        transmission.shiftGear(0);
        engine.stop();
        System.out.println("Breaking..");
    }
}
