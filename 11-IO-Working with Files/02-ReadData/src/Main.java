import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        //testFile2("demoe.txt");

        File file = new File("demo.txt");
        System.out.println(file.getAbsolutePath());
        if (!file.exists()) {
            System.out.println("I Can't run unless this file exists.");
            return;
        }
        System.out.println("I'm good to go.");
        System.out.println("Current working dir: " + new File("").getAbsolutePath());

        // This is the example of utility class
        System.out.println(StringUtils.toUpper("mahendran"));

        Path path = Paths.get("demo7.txt");
        if (!Files.exists(path)) {
            System.out.println("2. I can't run unless this file exists..");
            return;
        }
        System.out.println("2. I'm good to go..");
    }


    /*
        Here, I was written a code for reading data from the file using FileReader class.
        its very convenient way to read the data from a file. Its subclass.
     */
    private static void testFile(String fileName) {

        FileReader read = null;
        try {
            read = new FileReader(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (read != null) {
                    read.close();
                }
            } catch (IOException e) {
                System.out.println(e);
            }
            System.out.println("Maybe I'd log something either way...");
        }
    }

    private static void testFile2(String fileName) {

        /*
        * FileReader class implements the autoclosable interface, through its parent class
          reader.
        * This class open a file resource implicitly.
        */

        try (FileReader fileReader = new FileReader(fileName)) {

        } catch (NullPointerException | IllegalArgumentException badData) {
            System.out.println("User has added a bad data: " + badData.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("File " + fileName + " doesn't exists.");
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println("Someting unrelated and unexpected happen.");
        }
    }
}