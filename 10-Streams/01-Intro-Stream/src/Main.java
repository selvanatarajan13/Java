import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Integer> numbers = new ArrayList<>(List.of(
                10,15,20,25,30,35,40,45,50
        ));
        List<Integer> evenNumbers = new ArrayList<>();

        // sort the array without using stream
        for (int n: numbers) {
            if (n%2==0) {
                // evenNumbers.add(n);
                break;
            }
        }

        // System.out.println(evenNumbers);

        // sort the array using stream
            evenNumbers = numbers.stream().filter((n) -> n%2==0).collect(Collectors.toList());
        System.out.println(evenNumbers);

        // if I want to print that data without storing other source
        numbers.stream().filter((n) -> n%2==1).forEach(System.out::println);

        // another example
        List<String> names = new ArrayList<>(List.of(
                "Melisandre", "Sansa", "Jon", "Daenerys", "Joffery"
        ));
        // here,
        names.stream().filter((n) -> n.length() <= 3 || n.length() > 7).forEach(System.out::println);

        // Stream computation are optimized
        /*
             It may change order of the intermediate operation, it may combine or skipped
             altogether.
         */

        // -----------------------------------------------------------------------------

        Map<Character, int[]> myMap = new LinkedHashMap<>();

        int bingoIndex = 1;
        for (char n: "BINGO".toCharArray()) {
            int[] numbers1 = new int[15];
            int labelNo = bingoIndex;
            Arrays.setAll(numbers1, i -> i+labelNo);
            myMap.put(n, numbers1);
            bingoIndex += 15;
        }

        myMap.entrySet().stream().map(e -> e.getKey() + " - Has range " + e.getValue()[0] + " - " + e.getValue()[e.getValue().length -1])
                        .forEach(System.out::println);

        System.out.println(myMap);

        System.out.println("-".repeat(30));

        // Stream.of(1,2,3,4,4,2,6,2,5).distinct().forEach(System.out::println);

        IntStream.iterate(1, n -> n+1).limit(20).forEach(s -> System.out.print(s + " "));
        System.out.println();
        IntStream.iterate(1, n-> n+1).filter(Main::isPrime).limit(20)
                .forEach(s -> System.out.print(s + " "));

        IntStream.iterate(1, n-> n+1).limit(100).filter(n -> isPrime(n))
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        IntStream.range(1, 100).filter(Main::isPrime).forEach(s -> System.out.print(s + " "));

        System.out.println();

        var numbers1 = Stream.of("One", "Two", "Three");
        var numbers2 = Arrays.stream(new List[]{List.of("Four", "Five", "Six")});
        Stream.concat(numbers1, numbers2).forEach(s -> System.out.print(s + " "));
    }

    public static boolean isPrime(int value) {
        if (value <= 2) {
            return (value == 2);
        } else {
            for (int i = 2; i < value; i++) {
                if (value % i == 0) {
                    return false;
                }
            }
        }

        return true;
    }


}