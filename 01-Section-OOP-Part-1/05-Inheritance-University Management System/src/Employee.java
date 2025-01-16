public class Employee extends Person {

    private String position;
    private double annualSalary;

    private static double pf = 12;

    public Employee(int id, String name, String email, String department, String position, double annualSalary) {
        super(id, name, email, department);
        this.position = position;
        this.annualSalary = annualSalary;
    }

    // calculate salary
    public void getSalary() {
        double monthlySalary = annualSalary / 12;
        System.out.println("Monthly salary : " + monthlySalary);
        double netSalary = monthlySalary - monthlySalary * pf/100;
        System.out.println("net salary per month : " + netSalary);
    }

    public void getWork() {
        System.out.println("He/She is a " + position);
        System.out.println("He/She teaching the below subjects : ");
    }

    @Override
    public String toString() {
        return "Employee{" +
                "position='" + position + '\'' +
                ", annualSalary=" + annualSalary +
                "} " + super.toString();
    }
}
