public class Main {
    public static void main(String[] args) {

        Car newFerrari = new PatroleumCar("Ferrari F8 Turbo", 3.9, 8);
        doCarStuff(newFerrari);

        Car newTesla = new ElectricCar("Tesla Model Y", 565, 100);
        doCarStuff(newTesla);
    }

    private static void doCarStuff(Car car) {
        car.startEngine();
        car.drive();
    }
}