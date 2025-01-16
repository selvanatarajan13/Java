import java.util.ArrayList;
import java.util.List;

public class Main {
    // Aggregation is called loosly coupled
    // In aggregation, classes can exist independently without help of another class.

    public static void main(String[] args) {
        System.out.println("Hello world!");

        MobileNumber number1 = new MobileNumber();
        MobileNumber number2 = new MobileNumber();

        number1.setNumber(9787660170L);
        number2.setNumber(9487270170L);

        Person mahendran = new Person();
        mahendran.setName("Mahendran");

        List<MobileNumber> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(number1);
        listOfNumbers.add(number2);

        mahendran.setMobileNumbers(listOfNumbers);
        mahendran.getContact();
    }
}