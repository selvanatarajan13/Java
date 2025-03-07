import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {

        readDataFilerReader("Files/BenchMark/Data.txt", "Files/BenchMark/Performance_log.txt");
        readDataBufferedReader("Files/BenchMark/Data.txt", "Files/BenchMark/Performance_log.txt");
    }

    private static void readDataBufferedReader(String path, String log) {
        long startTime = 0, fileReaderTime = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader(path))) {
            startTime = System.nanoTime();
            bf.lines().forEach(System.out::println);
            fileReaderTime = System.nanoTime() - startTime;
            System.out.println("Buffered Reader time: " + fileReaderTime);
            Files.writeString(Path.of(log), """
                    Buffered Reader time: 
                    """ + fileReaderTime + "\n", StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void readDataFilerReader(String path, String log) {
        long startTime = 0, fileReaderTime = 0;
        FileReader reader = null;
        try {
            reader = new FileReader(path);
            char[] charArr = new char[1024];
            int character;
            startTime = System.nanoTime();
            while ((character = reader.read(charArr)) != -1) {
                String data = new String(charArr, 0, character);
                System.out.printf("---> [%d char] %s\n", character, data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                    fileReaderTime += System.nanoTime() - startTime;
                    System.out.println("File reader time: " + fileReaderTime);
                    Files.writeString(Path.of(log), """
                            File Reader time: 
                            """ + fileReaderTime + "\n", StandardOpenOption.CREATE);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}