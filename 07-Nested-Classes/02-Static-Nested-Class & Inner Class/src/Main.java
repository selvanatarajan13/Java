import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Employee> employees = new ArrayList<>(List.of(
                new Employee("Abiram"),
                new Employee("Suthakar"),
                new Employee("Jeni"),
                new Employee("Suba"),
                new Employee("Hari"),
                new Employee("Mani")
        ));

        employees.sort(new Employee.EmployeeComparator(SortType.startedYear));

        for (Employee n: employees) {
            System.out.println(n);
        }

        System.out.println("-".repeat(60));

        List<CompanyEmployee> companyEmployees = new ArrayList<>(List.of(
                new CompanyEmployee("Kasiram", "avl network"),
                new CompanyEmployee("Abiram", "ilgin"),
                new CompanyEmployee("Arun", "zoho"),
                new CompanyEmployee("Jeya", "tcs"),
                new CompanyEmployee("Suthakar", "ilgin")
        ));

        companyEmployees.sort(new CompanyEmployee(). new CompanyComparator<>());

        for (CompanyEmployee n: companyEmployees) {
            System.out.println(n);
        }
    }
}