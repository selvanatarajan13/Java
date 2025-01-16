import java.util.ArrayList;
import java.util.List;

public class Person {


    private String name;
    private List<MobileNumber> mobileNumbers;

    public Person(String name) {
        this.name = name;
    }

    public Person() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNumbers(List<MobileNumber> mobileNumbers) {
        this.mobileNumbers = mobileNumbers;
    }

    public List<Long> getMobileNumbers() {
        List<MobileNumber> listOfNumbers = this.mobileNumbers;
        List<Long> numbers = new ArrayList<>();

        for (MobileNumber mobileNumber : listOfNumbers) {
            numbers.add(mobileNumber.getNumber());
        }

        return numbers;
    }

    public void getContact() {
        System.out.println("The person name is " + getName() + " and numbers are " + getMobileNumbers());
    }
}
