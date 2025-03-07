import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // useFile("demo.txt");
        // usePath("demo.txt");
    }

    /*
    * To summarize in this code, I used instance of file, to test some condition in the file
      system as well as to create and delete a file.
    */
    private static void useFile(String fileName) {

        File file = new File(fileName);
        boolean fileExists = file.exists();
        System.out.printf("file %s %s\n", fileName, fileExists ? "exists." : "doesn't exists.");

        if (file.exists()) {
            System.out.println("Deleting file: " + fileName);
            fileExists = !file.delete();
            return;
        }

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("File was created successfully..");
            } catch (IOException e) {
                System.out.println("Something went wrong try again later..");
            }
        }
    }

    /*
    * I'll do that same thing as above, but I'll instead be using instance older File class,
      I'm going to use an instance of newer Path type, with the help of the method on the Files
      class.
    */

    private static void usePath(String filePath) {

        Path path = Path.of(filePath);
        boolean fileExists = Files.exists(path);

        // Next, I want to do same thing as the above useFile method

        System.out.printf("File %s %s\n", filePath, fileExists ? "exists." : "doesn't exists..");

        if (Files.exists(path)) {
            try {
                Files.delete(path);
                fileExists = false;
                System.out.println("The File " + filePath + " deleted successfully");
                return;
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }

        if (!Files.exists(path)) {
            try {
                Files.createDirectory(path);
                System.out.println("The file " + filePath + " was created");
            } catch (IOException e) {
                System.out.println("Something went wrong");
                throw new RuntimeException(e);
            }

            if (Files.isWritable(path)) {
                System.out.println("The file is writable");
                writeFile(path);
            } else {
                System.out.println("The file is not writable");
            }

            if (Files.isReadable(path)) {
                try {
                    List<String> data = Files.readAllLines(path);
                    System.out.println("-".repeat(50));
                    data.forEach(System.out::println);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void writeFile(Path path) {

        try {
            Files.writeString(path, """
                    Hello world, Java.
                    My name is Selvanatarajan..
                    """);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}