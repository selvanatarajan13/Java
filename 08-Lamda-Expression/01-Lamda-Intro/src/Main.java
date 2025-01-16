import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        System.out.println("Lamda expression");

        List<Person> personList = new ArrayList<>(Arrays.asList(
                new Person("Mahendran", "S"),
                new Person("Abiram", "KE"),
                new Person("Suthakar", "P"),
                new Person("Arun Siva", "R"),
                new Person("Manikandan", "S"),
                new Person("Iyyappan", "T"),
                new Person("Vengad", "T")
        ));

        System.out.println("before sorted");
        System.out.println(personList);

        // sorted lastName using comparator by anonyms class
        // var personListComparator = new Comparator<Person>() {
            //@Override
            //public int compare(Person o1, Person o2) {
              //  return o1.lastName.compareTo(o2.lastName);
            //}
        //};

        // personList.sort(personListComparator);

        // sorting using lamda expression..
        personList.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));


        System.out.println("After sorting the list using lastName");
        System.out.println(personList);

        // sorting lastName as well as firstName
        var personListComparator2 = new EnhanceComparator<Person>() {

            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName.compareTo(o2.lastName);
                return (result == 0 ? secondLevelComparatot(o1, o2) : result);
            }

            @Override
            public int secondLevelComparatot(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };

        personList.sort(personListComparator2);
        System.out.println("After sorting firstName and lastName");
        System.out.println(personList);
    }

    interface EnhanceComparator<T> extends Comparator<T> {
        int secondLevelComparatot(T o1, T o2);
    }
}