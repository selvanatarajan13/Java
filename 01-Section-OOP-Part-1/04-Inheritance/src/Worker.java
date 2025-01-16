public class Worker {

    private String name;
    private String birthDate;
    private String endDate;


    public Worker() {

    }

    public Worker(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }

    public void getAge() {
        int currentYear = 2024;
        int birthYear = Integer.parseInt(birthDate.substring(6));
        int age = currentYear - birthYear;
        System.out.println("Age : " + age);
    }

    public void terminate(String terminateDate) {
        this.endDate = terminateDate;
    }

    public double collectPay() {
        return 0.0;
    }

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

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }
}
