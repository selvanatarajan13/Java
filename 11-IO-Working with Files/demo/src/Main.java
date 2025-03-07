import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        File filePath = new File("demo.txt");
        String data = "Hello, I'm Karthikka, What's up?";
        File file = new File("vel.png");
        readImageFile(file);

        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            FileDescriptor fd = fileInputStream.getFD();
            System.out.println("File descriptor value: " + fd);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readImageFile(File filePath) {

        try {
            FileInputStream fis = new FileInputStream(filePath);
            BufferedImage bw = ImageIO.read(fis);

            System.out.println("Image width: " + bw.getWidth());
            System.out.println("Image height: " + bw.getHeight());
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void fileWriteUsingClass(File file, String data) {

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(data);
            fw.close();
            System.out.println("Data was written successfully");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readData(String filePath) {
        try {
            File f = new File(filePath);
            Scanner read = new Scanner(f);
            while(read.hasNext()) {
                System.out.println(read.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void writeDataUsingStream(File filePath, String data) {

        FileOutputStream file = null;
        try {
            file = new FileOutputStream(filePath);
            byte[] bytes = data.getBytes();
            file.write(bytes);
            System.out.println("Data is written to the file successfully..");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (Exception e) {
                System.out.println(e);
            } finally {
                try {
                    if (file != null) {
                        file.close();
                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }
}