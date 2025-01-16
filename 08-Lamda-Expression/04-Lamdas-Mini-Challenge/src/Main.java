import java.util.Arrays;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Consumer<String> printValues = s -> {
            String[] values = s.split(" ");
            for (String part: values) {
                System.out.println(part);
            }
        };

        Consumer<String> printPartOfWords = s -> {
            String[] values = s.split(" ");
            Arrays.asList(values).forEach(System.out::println);
        };

        printPartOfWords.accept("Hello Mahend, What's new update? ya");
        System.out.println("-".repeat(30));
        printValues.accept("Hello Karthikka, What's up?");
    }
}