import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Enter the Car Name : ");
            String name = s.next();
            if (name.toUpperCase().equals("QUIT")) {
                break;
            }

            Car car = Car.getCarInstance();
            toCarStuff(car);
        }
    }

    private static void toCarStuff(Car car) {

        System.out.println(car);
    }
}