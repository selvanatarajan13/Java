package model;

public class Subject {
    private String name;
    private int creditHours; // used for PriorityQueue ordering

    public Subject(String name, int creditHours) {
        this.name = name;
        this.creditHours = creditHours;
    }

    public int getCreditHours() {
        return creditHours;
    }

    public void setCreditHours(int creditHours) {
        this.creditHours = creditHours;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
