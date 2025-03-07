import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // testFile("demo.txt");
        testFile2("demo.txt");

    }

    private static void testFile2(String fileName) {
        File file = new File(fileName);
        boolean fileFlag = file.exists();

        System.out.printf("File %s %s%n", fileName, fileFlag ? "exists." : "doesn't exist.");
        if (fileFlag) {
            System.out.println("Deleting file." + fileName);
            fileFlag = !file.delete();
        }

        if (!fileFlag) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Something went wrong!");
            }

            System.out.println("File created successfully");
            if (file.canWrite()) {
                System.out.println("Would write to file here..");
            }
        }
    }

    private static void testFile(String fileName) {

        Path path = Paths.get(fileName);

        try {
            List<String> file = Files.readAllLines(path);
        } catch (IOException e) {
            if (e instanceof NoSuchFileException) {
                System.out.println("File not found");
            }
            throw new RuntimeException(e);

        } finally {
            System.out.println("May I'd log something either way");
        }

        System.out.println("I'm good go ahead!..");
    }
}