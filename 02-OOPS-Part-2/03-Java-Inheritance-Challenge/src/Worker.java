// This is the Parent class

import java.time.LocalDateTime;

public class Worker {

    // initialize the fields
    private String name;
    private String birthDate;
    private String endDate;

    // define constructor

    public Worker(String name, String birthDate, String endDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.endDate = endDate;
    }

    // define methods
    public int getAge() {
        int currentYear = LocalDateTime.now().getYear();
        int birthYear = Integer.parseInt(birthDate.substring(7));

        return currentYear-birthYear;
    }

    public double collectPay() {
        return 0.0;
    }

    public void termiante(String endDate) {
        this.endDate = endDate;
    }

    // define getter and setter methods

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    // define toString() method

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
