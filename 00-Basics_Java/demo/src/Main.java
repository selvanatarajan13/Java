import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main  {

    public static void main(String[] args) {
        System.out.println("Hello world!");

        Student michel = new Student("Michel Chellai", 9);
        // System.out.println(michel);

        PrimarySchoolStudent tom = new PrimarySchoolStudent("Tom", 8, "Jim and Loosi");
        PrimarySchoolStudent parani = new PrimarySchoolStudent(
                "Siva Paraniswari", 8, "Suseela & Mariappan"
        );
        // System.out.println(student);

        ArrayList<Student> data = new ArrayList<>();
        data.add(tom);
        data.add(parani);
        data.addFirst(michel);

        int index = data.indexOf(tom);
        System.out.println(index);

        int size = data.size();
        System.out.println(size);

        Student value = data.getLast();
        System.out.println(value);
        System.out.println(data);


        Hashtable<Integer, String> names = new Hashtable<>();
        names.put(101, "Selvanatarajan");
        names.put(102, "Mahendran");

        System.out.println(names);

        String fileName = "C:\\Users\\User\\Desktop\\Links\\LinkedIn.txt";
        Path path = Paths.get(fileName);
        try {
            List<String> lines = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            System.out.println("May I'd log something either way");
        }

        testMethod("cvs.s");

        //System.out.println("File exists and able to use as a resource");
    }

    private static void testMethod(String fileName) {
        Path path = Paths.get(fileName);
        try {
            // FileReader fileReader = new FileReader(fileName);
            List<String> list = Files.readAllLines(path);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        } catch (IOException e) {
            if (e instanceof NoSuchFileException) {
                System.out.println("File Not Found");
            } else {
                throw new RuntimeException(e    );
            }
        } catch (NullPointerException e) {
            System.out.println(e);
        } finally {
            System.out.println("May I'd log something either way");
        }

        System.out.println("File exists and able to use as a resource");
        System.out.println("Current working dir : " + new File("").getAbsolutePath());
    }
}

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class PrimarySchoolStudent extends Student {

    String parentName;

    public PrimarySchoolStudent(String name, int age, String parentName) {
        super(name, age);
        this.parentName = parentName;
    }

    public String getParentName() {
        return parentName;
    }

    @Override
    public String toString() {
        return getParentName() + " kid, " + super.name + " is " + super.age + " years old.";
    }
}