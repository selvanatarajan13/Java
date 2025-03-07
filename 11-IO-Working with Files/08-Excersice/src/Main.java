import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        File file = new File("files/file.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            // System.out.println(reader.lines().count());
            Pattern pattern = Pattern.compile("\\s");
            // count the total number of words
            System.out.println(
                    reader.lines()
//                            .flatMap(pattern::splitAsStream)
                            .flatMap(l -> Arrays.stream(l.split(pattern.toString())))
                            .count()
            );
            System.out.println();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}