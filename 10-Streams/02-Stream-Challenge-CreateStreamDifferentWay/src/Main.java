import java.util.Arrays;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        /*
        This challenge is create stream using in different way.
         */

        int seed = 1;
        String[] bLetters = new String[15];
        int finalSeed = seed;
        Arrays.setAll(bLetters, n -> "B" + (finalSeed +n));
        var lettersB = Arrays.stream(bLetters);
//        lettersB.forEach(s -> System.out.print(s + " "));
        System.out.println();

        seed += 15;
        int seed2 = seed;
        var iLetters = Stream.iterate(seed2, n -> n <= 30, n -> (n+1)).
                map(n -> "I" + n);
//        iLetters.forEach(s -> System.out.print(s + " "));

        seed += 15;
        int seed3 = seed;
        var nLetters = Stream.iterate(seed3, n-> n+1).limit(15).
                map(n -> "N" + n);
        System.out.println();
//        nLetters.forEach(s -> System.out.print(s + " "));

        seed += 15;
        var gLetters = Stream.of(
                "G46", "G47", "G48", "G49", "G50", "G51", "G52", "G53", "G54", "G55",
                "G56", "G57", "G58", "G59", "G60"
        );
        System.out.println();
//        gLetters.forEach(s -> System.out.print(s + " "));

        seed += 15;
        int seed4 = seed;
        var oLetters = Stream.generate(Main::generate).limit(15).
                map(n -> "O" + (seed4+n));

        var biCombine = Stream.concat(lettersB, iLetters);
        var ngCombine = Stream.concat(nLetters, gLetters);
        var bingCombine = Stream.concat(biCombine, ngCombine);
        var bingoCombine = Stream.concat(bingCombine, oLetters);

    }

    static int counter = 0;
    public static int generate() {
        return counter++;
    }
}