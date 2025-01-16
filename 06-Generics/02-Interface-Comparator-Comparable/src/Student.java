import java.util.Random;

public class Student implements Comparable<Student> {

    private static int LAST_ID = 1000;
    private static Random random = new Random();

    public int id;
    public String name;
    public double gpa;

    public Student(String name) {
        this.name = name;
        this.id = LAST_ID++;
        this.gpa = random.nextDouble(1.0, 10.0);
    }

    @Override
    public String toString() {
        return "{%d - %s (%.2f)}".formatted(id, name, gpa);
    }

    @Override
    public int compareTo(Student o) {
        // return name.compareTo(o.name);
        return Integer.valueOf(id).compareTo(Integer.valueOf(o.id));
    }
}
