import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Hashtable;

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