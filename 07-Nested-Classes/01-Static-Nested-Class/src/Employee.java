import java.util.Comparator;
import java.util.Random;

public class Employee {

    public static class EmployeeComparator implements Comparator<Employee> {

        private String sortType;

        public EmployeeComparator(SortType type) {
            this.sortType = String.valueOf(type);
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            if (sortType.equalsIgnoreCase("startedYear")) {
                return o1.startedYear - o2.startedYear;
            }
            return o1.name.compareTo(o2.name);
        }
    }

    private static int INDEX_ID = 1000;
    private Random random = new Random();

    private int empId;
    private String name;
    private int startedYear;

    public Employee() {

    }

    public Employee(String name) {
        this.empId = ++INDEX_ID;
        this.name = name;
        this.startedYear = random.nextInt(1995, 2024);
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(empId, name, startedYear);
    }
}
