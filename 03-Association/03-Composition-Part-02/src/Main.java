public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Engine engine = new Engine(200);
        Car maruti = new Car("500 X", engine);

        maruti.startCar();

        // Composition is tightly coupled compared to the aggregation.
        // In composition, classes can't exist independently, because it doesn't make sense if exist independently.

        // For example,
        engine.start();
    }
}