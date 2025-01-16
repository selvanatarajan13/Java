import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<String> list = new ArrayList<>(List.of(
                "Alpha", "Bravo", "Charlie", "Delta"
        ));

        // traditional printing mechanism
        for (String name: list) {
            System.out.println(name);
        }

        System.out.println("-".repeat(30));

        // using lamda expression for print the list of elements
        list.forEach((s) -> System.out.println(s));

        list.forEach(
                (myString) -> {
                    char first = myString.charAt(0);
                    System.out.println(myString + " means " + first);
                }
        );

        // using functional interface with lamda expression
        var result = calculate((a, b) -> a-b, 66,45);
        System.out.println("Result of operation: " + result);
        System.out.println(
                "Result of operation: " + calculate(
                        (var a, var b) -> a.toUpperCase() + " " + b.toUpperCase(),
                        "selvanatarajan", "mahendran s"
                )
        );

        printMessage(() -> System.out.println("Hello Java, This is the zero parameter lamda expression example."));
    }

    public static <T> T calculate(Operation<T> operation, T value1, T value2) {
        return operation.operate(value1, value2);
    }

    public static void printMessage(PrintableInterface printableInterface) {
        printableInterface.print();
    }
}