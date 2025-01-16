public class Student extends Person {

    private String studentId;
    private int year;
    private String joinDate;
    private double gpa;

    public Student(int id, String name, String email, String department, String studentId,
                   int year, String joinDate, double gpa) {
        super(id, name, email, department);
        this.studentId = studentId;
        this.year = year;
        this.joinDate = joinDate;
        this.gpa = gpa;
    }

    public void getPassedOutYear() {
        int passYear = year + 4;
        System.out.println("Passout Year : " + passYear);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", year=" + year +
                ", joinDate='" + joinDate + '\'' +
                ", gpa=" + gpa +
                "} " + super.toString();
    }
}
