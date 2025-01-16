public class Employee {

    // define fields
    private String name;
    private int salary;

    // define constructor

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public void addIncreament(int val) {
        salary += salary * val / 100;
    }

    // getter and setter

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    // define toString()

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
