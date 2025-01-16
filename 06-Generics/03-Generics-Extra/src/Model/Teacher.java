package Model;

import java.util.Random;

public class Teacher {

    private String name;
    private String courseName;

    protected static Random random = new Random();
    private static String[] firstName = {"Anne", "Bills", "Cathy", "John", "Tim"};
    private static String[] course = {"C++", "Java", "Python"};

    public Teacher() {
        int lastName = random.nextInt(65, 91);
        this.name = firstName[random.nextInt(5)] + " " + (char) lastName;
        this.courseName = course[random.nextInt(3)];
    }

    @Override
    public String toString() {
        return "%-15s %-15s".formatted(name, courseName);
    }
}
