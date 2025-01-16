public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Instantiating a Car object
        Car car = new Car();
        car.setDoor(3);
        car.setCompany("TATA");
        car.setModel("Curv EV");
        car.setColor("Navy Blue");

        car.describeCar();;
    }
}