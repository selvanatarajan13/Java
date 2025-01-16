import java.util.Comparator;

public class CompanyEmployee extends Employee {

    private String company;

    public CompanyEmployee() {

    }

    public CompanyEmployee(String name, String companyName) {
        super(name);
        this.company = companyName;
    }

    public class CompanyComparator <T extends CompanyEmployee> implements Comparator<CompanyEmployee> {
        @Override
        public int compare(CompanyEmployee o1, CompanyEmployee o2) {
            int result = o1.company.compareTo(o2.company);

            if (result == 0) {
                return new Employee.EmployeeComparator(SortType.startedYear).compare(o1, o2);
            }
            return result;
        }
    }

    @Override
    public String toString() {
        return "%-16s %s".formatted(company, super.toString());
    }
}
