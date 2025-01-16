package Model;

import util.QueryItem;

import java.util.Random;

public class Student implements QueryItem {
    
    private String name;
    private String course;
    private int yearStarted;

    protected static Random random = new Random();

    private static String[] firstName = {"Anne", "Bills", "Cathy", "John", "Tim"};

    private static String[] courses = {"C++", "Java", "Python"};

    public Student() {
        int lastName = random.nextInt(65, 91);
        this.name = firstName[random.nextInt(5)] + " " + (char) lastName;
        this.course = courses[random.nextInt(3)];
        this.yearStarted = random.nextInt(2010, 2022);
    }

    @Override
    public String toString() {
        return "%-15s %-15s %d".formatted(name, course, yearStarted);
    }

    @Override
    public boolean matchFieldValue(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName) {
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == (Integer.parseInt(value));
            default -> false;
        };
    }
}
