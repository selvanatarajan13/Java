import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    static int counter = 0;

    public static void main(String[] args) {
        System.out.println("Hello world!");
        int index = 1;
        Stream.iterate(index, n-> n<=15, n -> n+1).map(n -> "B" + n).
                forEach(s -> System.out.print(s + " "));

        System.out.println();
        index += 15;
        Stream.iterate(index, n -> n+1).map(n -> "I" + n).limit(15)
                .forEach(s -> System.out.print(s + " "));

        System.out.println();
        index += 15;
        int finalIndex = index;
        String[] nLetters = new String[15];
        Arrays.setAll(nLetters, n -> "N" + (finalIndex + n));
        var nStream = Arrays.stream(nLetters);
        nStream.forEach(s -> System.out.print(s + " "));

        System.out.println();
        index += 15;
        var gLetters = Stream.of(
                "G46", "G47", "G48", "G49", "G50", "G51", "G52", "G53", "G54", "G55",
                "G56", "G57", "G58", "G59", "G60"
        );
        gLetters.forEach(s -> System.out.print(s + " "));


        index += 15;
        int oIndex = index;
        var oLetters = Stream.generate(Main::generate).limit(15).
                map(n -> "O" + (oIndex + n));
        System.out.println();
        oLetters.forEach(s -> System.out.print(s + " "));

        
    }

    public static int generate() {
        return counter++;
    }
}