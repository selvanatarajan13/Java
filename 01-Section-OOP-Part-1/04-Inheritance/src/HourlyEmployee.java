public class HourlyEmployee extends Employee {

    private int hourlyPerRate;

    public HourlyEmployee(String name, String birthDate, String hireDate, int hourlyPerRate) {
        super(name, birthDate, hireDate);
        this.hourlyPerRate = hourlyPerRate;
    }

    @Override
    public double collectPay() {
        return 15 * hourlyPerRate;
    }
}
