import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = Arrays.asList(
                new Employee("Muna", "IT", 7500),
                new Employee("Runa", "HR", 90000),
                new Employee("Kuna", "Finance", 60000),
                new Employee("Miku", "IT", 75000),
                new Employee("Sonu", "IT", 24000),
                new Employee("mark", "HR", 65000)
        );

        List<String> emp = employees.stream().map(employee -> employee.name().toUpperCase()).toList();
        emp.forEach(System.out::println);
        System.out.println("-".repeat(50));

        employees.stream().sorted(Comparator.comparingDouble(Employee::salary).reversed()).map(
                employee -> employee.name() + " " + employee.dept() + " " + employee.salary()
        ).forEach(System.out::println);

        System.out.println("-".repeat(50));
        employees.stream().filter(employee -> employee.salary() < 10000).map(employee -> employee.name() + " " + employee.dept() + " " + employee.salary()).forEach(System.out::println);
    }
}