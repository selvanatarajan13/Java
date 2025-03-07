import java.io.*;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Hello world!");
        File file = new File("Files/demo/mahend.txt");
        // readDataFileReader(file);
        readDataUsingBuffer(file);
    }

//    To read the data from the file, here we used FileReader class.
    private static void readDataFileReader(File path) {

        FileReader reader = null;
        try {
            reader = new FileReader(path);
            char[] buffer = new char[1024];
            int character;
            int i = 1;
            while ((character = reader.read()) != -1) {
                System.out.println(i++);
                String data = new String(buffer, 0, character);
                System.out.printf("----->[%d char] %s\n", character, (char) character);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

//    Here, we used BufferedReader class for read the data from the file.
//    It is faster than FileReader class.
    private static void readDataUsingBuffer(File path) {

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {

//            String line;
//            while ((line = bf.readLine()) != null) {
//                System.out.println(line);
//            }

            // we can replace above code using one statement since the JDK 8.
            bf.lines().forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}