package Dev.Model;

import Dev.util.QueryItem;

import java.util.Random;

public class Student implements QueryItem {

    private int id;
    private String name;
    private String course;
    private int startedYear;

    protected static int INDEX = 1000;
    protected static Random random = new Random();
    private static String[] courses = {"C++", "Python", "Java", "PHP", "Mern Stack", "Mean Stack"};
    private static String[] firstName = {"Anne", "Bills", "Cathy", "John", "Tim", "John", "Mark"};

    public Student() {
        this.id = INDEX++;
        int lastName = random.nextInt(65,91);
        this.name = firstName[random.nextInt(7)] + " " + (char) lastName;
        this.course = courses[random.nextInt(6)];
        this.startedYear = random.nextInt(2012, 2024);
    }

    @Override
    public String toString() {
        return "%-15d %-15s %-15s %d".formatted(id, name, course, startedYear);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "STARTEDYEAR" -> startedYear == Integer.parseInt(value);
            default -> false;
        };
    }
}
