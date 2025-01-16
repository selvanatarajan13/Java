import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // create sports person objects
        SportPerson dhoni = new SportPerson("MS Dhoni");
        SportPerson rachin = new SportPerson("Rachin Ravindra");
        SportPerson aswin = new SportPerson("Aswin");

        // create country object
        Country india = new Country("India");

        // create list
        List<SportPerson> listOfSportsPerson = new ArrayList<>();
        listOfSportsPerson.add(dhoni);
        listOfSportsPerson.add(rachin);
        listOfSportsPerson.add(aswin);

        india.setSportPersons(listOfSportsPerson);

        // print
        System.out.println("The sports people from country " + india.getName() + " are " + india.getSportPersons());
    }
}