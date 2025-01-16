public class Car {
    private String model;
    private Engine engine; // when you create a property as an instance of another it is called composition.



    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
    }

    public void startCar() {
        engine.start();
        System.out.println("Car started...");
    }
}
