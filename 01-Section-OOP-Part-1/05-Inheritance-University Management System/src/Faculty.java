import java.util.List;

public class Faculty extends Employee {

    private List<String> teachingCourses;

    public Faculty(int id, String name, String email, String department, String position, double annualSalary, List<String> teachingCourses) {
        super(id, name, email, department, position, annualSalary);
        this.teachingCourses = teachingCourses;
    }

    @Override
    public void getWork() {
        super.getWork();
        System.out.println(teachingCourses);
        System.out.println("---------------------------------");
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "teachingCourses=" + teachingCourses +
                "} " + super.toString();
    }
}
