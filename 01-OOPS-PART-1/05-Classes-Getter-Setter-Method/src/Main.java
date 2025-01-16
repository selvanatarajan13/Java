public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Create another instance
        Car myCar = new Car();

        // set the attributes for this instance by setter method
        myCar.setCarCompany("Nissan");
        myCar.setModel("GT-R");
        myCar.setColor("White");

        // Use method on this instance
        myCar.describeCar();

        // Create another instance without adding attributes
        Car theCar = new Car();

        // Called the method on this instance
        theCar.describeCar();
    }
}