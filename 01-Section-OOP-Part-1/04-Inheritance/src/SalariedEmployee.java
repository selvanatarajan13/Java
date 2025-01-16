public class SalariedEmployee extends Employee {

    private int annualSalary;
    private boolean isRetired;

    public SalariedEmployee(String name, String birthDate, String hireDate, int annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    @Override
    public double collectPay() {
        return (int) annualSalary / 12;
    }
    
    public void retire() {
        terminate("25/12/2028");
        isRetired = true;
    }
}
