import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int i = 1;
    public static void main(String[] args) {

        String paragraph = """
                Double, double toil and trouble;
                Fire burn and cauldron bubble.
                Fillet of a fenny snake,
                In the cauldron boil and bake;
                Eye of newt and toe of frog,
                Wool of bat and tongue of dog,
                Adder's fork and blind-worm's sting,
                Lizard's leg and owlet's wing,
                For a charm of powerful trouble,
                Like a hell-broth boil and bubble
                """;

        String[] lines = paragraph.split("\\R");
        System.out.println("This paragraph has " + lines.length + " lines.");
        String[] words = paragraph.split("\\s");
        System.out.println("This paragaraph has " + words.length + " words.");
        System.out.println("-".repeat(60));

        System.out.println(paragraph.replaceAll("\\b[a-zA-Z]{3}+ble", "[GRUB]"));
        System.out.println("-".repeat(60));
        // we can also count words or count lines using scanner class
        Scanner scanner = new Scanner(paragraph);
        scanner.useDelimiter("\\R");
        int i = 0;
//        while (scanner.hasNext()) {
//            String element = scanner.nextLine();
//            System.out.println(element);
//            i++;
//        }
        // System.out.println("The paragrah has " + i + " lines..");
        //System.out.println("Print how many words on each line");
        // If you want to print the paragraph instead of using traditional method, and what next I do
        scanner.tokens()
                .map(s -> s.replaceAll("\\p{Punct}", ""))
                .flatMap(s -> Arrays.stream(s.split("\\s+")))
                .filter(s -> s.matches("[a-zA-Z]+ble"))
                .forEach(System.out::println);

        /*
        * you can see the above code and you may think that we can use the map api instead of
        * using flatMap api. Because the reason of this, we want individual elements to apply for
        * that given filter so we use flatMap api. This api returns a stream of individual element
        * while on the other hand, map api, it return a stream of array.
        *
        * If you don't want to use the filter api on each element, then you may use map api rather
        * than the flatMap api stream method.
        *
        * map return a array of stream and flatMap return the individual element.
        */
        scanner.close();
        System.out.println("-".repeat(60));

        regExpTask(paragraph);
    }

    private static void regExpTask(String testString) {

        Scanner scanner = new Scanner(testString);
        scanner.useDelimiter("\\R");
        scanner.tokens()
                .map(s -> s.replaceAll("\\p{Punct}", ""))
                        .flatMap(s -> Arrays.stream(s.split("\\s+")))
                                .filter(s -> s.matches("^[a].*"))
                                        .forEach(System.out::println);
        scanner.close();
    }

    private static String splitFunc(String arr) {
        int length = arr.split("\\s+").length;
        return "%s %d %s %d %s".formatted("The ", Main.i++, "st line has ", length, " words.");
    }
}