import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("Files/info/demo.txt");
        //printPathInfo(path);
        String data = "I'm selvanatarajan, I'm recently graduated in ECE..";
        writeFile(path, data);
        //extraInfo(path);
    }

    private static void writeFile(Path path, String data) {
        Path parent = path.getParent();
        boolean fileExists = Files.exists(parent);
        if (fileExists) {
            System.out.println("File exist.");
            writeData(path, data);
        } else {
            System.out.println("File was not exists");
            try {
                Files.createDirectory(parent);
                System.out.println("File was created successfully!");
                writeData(path, data);
            } catch (NoSuchFileException e) {
                try {
                    Files.createDirectories(parent);
                    System.out.println("File was created successfully!");
                    writeData(path, data);
                } catch (IOException f) {
                    f.printStackTrace();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void writeData(Path path, String data) {
        try {
            Files.writeString(
                    path, Instant.now() + ": " + data  + "\n",
                    StandardOpenOption.CREATE, StandardOpenOption.APPEND
            );
            System.out.println("File was written successfully..");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void delete(Path path) {
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        System.out.println("Something wrong");
    }

    private static void printPathInfo(Path path) {
        System.out.println("Path: " + path);
        System.out.println("FileName: " + path.getFileName());
        System.out.println("Parent: " + path.getParent());
        Path absolutePath = path.toAbsolutePath();
        System.out.println("Asolute path: " + absolutePath);
        System.out.println("Absolute path root: " + absolutePath.getRoot());
        System.out.println("Root: " + path.getRoot());
        System.out.println("isAbsolute: " + path.isAbsolute());
        System.out.println("-".repeat(50));

        System.out.println(absolutePath.getRoot());
        int i = 1;
        var it = path.toAbsolutePath().iterator();
        while (it.hasNext()) {
            System.out.println(".".repeat(i++) + " " + it.next());

        }

        System.out.println("-".repeat(50));
        int itr = absolutePath.getNameCount();
        System.out.println(itr);
        int k = 1;

        for (int j = 0; j<itr; j++) {
            System.out.println(".".repeat(k++) + " " + absolutePath.getName(j));
        }

        logStatement(path);
    }

    private static void logStatement(Path path) {

        try {
            Path parent = path.getParent();
            if (!Files.exists(parent)) {
                Files.createDirectory(parent);
                Files.writeString(path, Instant.now() + """
                        Java is the popular programming language..
                        """);
            } else {
                System.out.println("Is " + path + " directory exists: TRUE");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * Let see the below code what kind of information, we can get about a file.
    */

    private static void extraInfo(Path path) {
        try {
            var data = Files.readAttributes(path, "*");
            data.entrySet().forEach(System.out::println);
            System.out.println(Files.probeContentType(path)); // it is return what is content type of the file.
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}