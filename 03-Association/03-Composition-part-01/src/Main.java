public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Engine engine = new Engine(200, 4);
        Transmission transmission = new Transmission(5, "Manual");

        Car car = new Car(engine, transmission, "Blue", "2012");
        car.accelerate();
        car.brake();
        
    }

    public void hello() {
        System.out.println("Hello world!");
    }
}