public class Manager extends Employee {

    private int bonus;

    public Manager(String name, int salary) {
        super(name, salary);
    }

    public void addBonus(int val) {
        this.bonus = val;
    }

    @Override
    public int getSalary() {
        return super.getSalary() + bonus;
    }
}
