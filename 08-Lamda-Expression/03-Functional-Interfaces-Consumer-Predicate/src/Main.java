import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // Functional interfaces are classified four different category. we will see in this program.
        // First Consumer interface. Here, I'm showing two most important consumer interface
        // -->functional method.

        // Using Consumer functional interface with lamda expression
        printMessage(() -> System.out.println(
                "This is the zero parameter and consumer functional interface example.."
        ));
        System.out.println("-".repeat(30));

        // another consumer functional interface using with lamda expression
        var nameList = Arrays.asList(
                new String[] {"Mahendran", "S"},
                new String[] {"Selvanataran", "S"},
                new String[] {"Vengad", "T"},
                new String[] {"Iyyappan", "T"}
        );
        nameList.forEach((s) -> System.out.println(Arrays.toString(s)));

        BiConsumer<String, String> names = (firstName, lastName) -> System.out.println(
                "First Name: " + firstName + " Last Name: " + lastName
        );

        var value = nameList.get(0);
        printNames(value[0], value[1], names);

        System.out.println("-".repeat(30));
        nameList.forEach(s -> printNames(s[0], s[1], names));
        System.out.println("-".repeat(30));

        // instead of we can use biconsumer without declare reference
        nameList.forEach(
                s -> printNames(
                        s[0], s[1],
                        (firstName, lastName) ->
                                System.out.println(
                                        "FirstName: " + firstName + " LastName: " + lastName
                                )
                )
        );

        // 2. Second one is predicate funtional interface
        // example with lamda expression
        System.out.println("-".repeat(30));
        List<String> studentNames = new ArrayList<>(List.of(
                "Mahendran", "Karthi", "Nazeer", "Albart"
        ));
        studentNames.removeIf(s-> s.equalsIgnoreCase("nazeer"));
        studentNames.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(30));

        studentNames.addAll(List.of("echo", "easy", "east"));
        studentNames.forEach(s -> print(s));

        System.out.println("-".repeat(30));

        studentNames.removeIf(s -> s.startsWith("ea"));
        // here, I'm using the method reference to print those string values
        studentNames.forEach(System.out::println);
        System.out.println("-".repeat(30));

        // 3. Third is functional interface.
        // it recieve only a single argument and return a value after the required procession.
        // On this program, I want to write a function interface example.
        // the unary operator takes one argument and returned result which has the same type as the argument.
        studentNames.replaceAll(s -> s.charAt(0) + " " + s.toUpperCase());
        studentNames.forEach(System.out::println);

        // Do you know what is intFunction interface
        // intFunction is also a functional interface and represent a function that accept an int-valued
        // -> argument and produce the result of any data type
        // it commonly used for operations that transform or process int values into other types

        String[] emptyString = new String[10];
        System.out.println(Arrays.toString(emptyString));

        Arrays.setAll(
                emptyString, (i) -> "" + (i+1) + ". " + switch (i) {
                    case 0 -> "One";
                    case 1 -> "Two";
                    default -> "";
                }
        );
        System.out.println(Arrays.toString(emptyString));
        // Bi-functional interface
        // it takes two arguments and produces a result.

        // 4. Suppiler functional interface
        //  it does not take any input or argument and yet returns a single value.
        String[] cars = {"Ferrari", "Rolls Royce", "TATA", "Tesla", "Mitsubishi"};
        String[] randomlySelectedValues = randomlySelectValues(10, cars, () -> new Random().nextInt(0, cars.length));
        System.out.println(Arrays.toString(randomlySelectedValues));
    }

    // example of supplier functional interface.
    public static String[] randomlySelectValues(int count, String[] value, Supplier<Integer> s) {

        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++) {
            selectedValues[i] = value[s.get()];
        }
        return selectedValues;
    }

    public static void printMessage(ConsumerInterface printMessage) {
        printMessage.print();
    }


    public static <T> void printNames(T value1, T value2, BiConsumer<T,T> biConsumer) {
        biConsumer.accept(value1, value2);
        /*
         here, the parameter named BiConsumer indicate the BiConsumer functional interface.
         it takes two argument and execute the program.
         it doesn't return any value or instance.
         */
    }

    public static <T> void print(T value) {
        System.out.println(value);
    }
}